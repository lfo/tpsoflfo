package com.bissy.distrib.bookstore.server;

import com.bissy.distrib.bookstore.server.persistence.BookStoreDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;
import com.bissy.distrib.change.ChangeService;

public class BookStoreServiceImpl extends UnicastRemoteObject implements BookStoreService {

	private static final long serialVersionUID = 1L;
	private ChangeService changeService;
    

	protected BookStoreServiceImpl(ChangeService changeService) throws RemoteException {
		super();		
		this.changeService = changeService;
	}

	private final static BookStoreDao BOOK_STORE_DAO = new BookStoreDao();
	
	
	public Collection<Book> findAllBooks() throws Exception {
		System.out.println("findAllBooks ... ");
		return new ArrayList<Book>(BOOK_STORE_DAO.findAllBook());
	}

	public Collection<Book> findBooks(String title) throws Exception {
		System.out.println("findBooks ... "+title);
        
		Collection<Book> toReturn = new ArrayList<Book>();
		Book book = BOOK_STORE_DAO.findBook(title);
		if (book != null) {
			toReturn.add(book);
		}
		return toReturn;
	}

	public Book buy(Book book, Amount amount) throws Exception {
		System.out.println(String.format("buy(%s,%s)", book.getIsbn(), amount));
        try {
            Amount bookPrice = BOOK_STORE_DAO.findPrice(book);
            if (bookPrice != null) {
                if (!bookPrice.getCurrency().equals(amount.getCurrency())) {
                    amount = changeService.getChange(amount, bookPrice.getCurrency());
                }
                if (amount.equals(bookPrice)) {
                	System.out.println(String.format("\"%s\" bought", book.getTitle()));
                    BOOK_STORE_DAO.remove(book);
                    return book;
                } else {
                    throw new RemoteException(String.format("Montant inexact. Le prix du livre est de %s. Le montant envoyé est de %s", bookPrice, amount));
                }
            }
           return null;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }
	}

	public Amount getPrice(Book book) throws Exception {
		System.out.println("getPrice");
		return BOOK_STORE_DAO.findPrice(book);
	}	
	
}
