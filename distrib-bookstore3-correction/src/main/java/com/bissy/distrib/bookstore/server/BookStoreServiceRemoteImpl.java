package com.bissy.distrib.bookstore.server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreRegistryService;
import com.bissy.distrib.bookstore.persistence.BookStoreDao;
import com.bissy.distrib.change.ChangeService;
import java.rmi.NotBoundException;

public class BookStoreServiceRemoteImpl extends UnicastRemoteObject implements InternalBookStoreService {

    private String serviceURL;
    private BookStoreDao bookStoreDao;
    private BookStoreRegistryService bookStoreRegistryService;
    private ChangeService changeService;
    private Registry registry;

    public BookStoreServiceRemoteImpl(String serviceURL, BookStoreDao bookStoreDao, BookStoreRegistryService bsRegistryService, ChangeService changeService, Registry registry) throws RemoteException {
        this.bookStoreDao = bookStoreDao;
        this.bookStoreRegistryService = bsRegistryService;
        this.changeService = changeService;
        this.serviceURL = serviceURL;
        this.registry = registry;
    }

    public void buy(Book book, Amount price) throws RemoteException {
        System.out.println(String.format("buy(%s,%s)", book.getIsbn(), price));
        if (buyLocally(book, price)) {
            return;
        }
        try {
            for (InternalBookStoreService bss : getOtherServers()) {
                if (bss.buyLocally(book, price)) {
                    return;
                }
            }
        } catch (Exception e) {
            throw new RemoteException(e.getMessage(), e);
        }
        throw new RemoteException("Déjà vendue ou livre n'existe pas");
    }

    public boolean buyLocally(Book book, Amount price) throws RemoteException {
        System.out.println(String.format("buyLocally(%s,%s)", book.getIsbn(), price));
        try {
            boolean toReturn = false;
            Amount bookPrice = bookStoreDao.findPrice(book);
            if (bookPrice != null) {
                if (!bookPrice.getCurrency().equals(price.getCurrency())) {
                    price = getChangeService().getChange(price, bookPrice.getCurrency());
                }
                if (price.equals(bookPrice)) {
                    bookStoreDao.remove(book);
                    return true;
                } else {
                    throw new RemoteException(String.format("Montant inexact. Le prix du livre est de %s. Le montant envoyé est de %s", bookPrice, price));
                }
            }
            System.out.println(String.format("return %s", toReturn));
            return toReturn;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public Collection<Book> findAllBooks() throws RemoteException {
        System.out.println(String.format("findAllBooks()"));
        try {
            List<Book> books = (List<Book>) findLocallyAllBooks();
            for (InternalBookStoreService bss : getOtherServers()) {
                books.addAll(bss.findLocallyAllBooks());
            }
            System.out.println(String.format("return %s", books.size()));
            return books;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public Collection<Book> findBook(String title) throws RemoteException {
        System.out.println(String.format("findBook(%s)", title));
        try {
            Collection<Book> books = (List<Book>) findLocallyBook(title);
            if (books.isEmpty()) {
                for (InternalBookStoreService bss : getOtherServers()) {
                    books = bss.findLocallyBook(title);
                    if (!books.isEmpty()) {
                        break;
                    }
                }
            }
            System.out.println(String.format("return %s", books.size()));
            return books;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public Amount getPrice(Book book) throws RemoteException {
        System.out.println(String.format("getPrice(%s)", book.getIsbn()));
        try {
            Amount price = getLocallyPrice(book);
            if (price == null) {
                for (InternalBookStoreService bss : getOtherServers()) {
                    price = bss.getLocallyPrice(book);
                    if (price != null) {
                        break;
                    }
                }
            }
            System.out.println(String.format("return %s", price));
            return price;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public ChangeService getChangeService() {
        return changeService;
    }

    private List<InternalBookStoreService> getOtherServers() throws Exception {
        List<InternalBookStoreService> toReturn = new ArrayList<InternalBookStoreService>();
        Collection<String> servers = bookStoreRegistryService.getServers();
        for (String bsUrl : servers) {
            if (!bsUrl.equals(serviceURL)) {
                try {
                    toReturn.add((InternalBookStoreService) registry.lookup(bsUrl));
                    System.out.println("\task to " + bsUrl);
                } catch (RemoteException remoteException) {
                    bookStoreRegistryService.removeServer(bsUrl);
                } catch (NotBoundException notBoundException) {
                    bookStoreRegistryService.removeServer(bsUrl);
                }
            }
        }
        return toReturn;
    }

    public Collection<Book> findLocallyAllBooks() throws RemoteException {
        System.out.println(String.format("findAllBooks()"));
        try {
            List<Book> toReturn = new ArrayList<Book>(bookStoreDao.findAllBooks());
            System.out.println(String.format("return %s", toReturn.size()));
            return toReturn;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public Collection<Book> findLocallyBook(String title) throws RemoteException {
         System.out.println(String.format("findLocallyBook(%s)", title));
        try {
            Book book = bookStoreDao.findBook(title);
            System.out.println(String.format("return %s", book));
            return (book != null) ? Collections.singleton(book) : Collections.EMPTY_LIST;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
    }

     public Amount getLocallyPrice(Book book) throws RemoteException {
         System.out.println(String.format("getLocallyPrice(%s)", book.getIsbn()));
        try {
            Amount price = bookStoreDao.findPrice(book);
            System.out.println(String.format("return %s", price));
            return price;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
     }
}
