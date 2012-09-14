package com.bissy.distrib.bookstore.client;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;

public class BookStoreClient implements BookStoreService {

    public final static String RMI_SERVICE_NAME = "rmi://localhost/bsService";
    BookStoreService remoteService;

    public BookStoreClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        Remote remote = registry.lookup(RMI_SERVICE_NAME);
        if (remote instanceof BookStoreService) {
            remoteService = (BookStoreService) remote;
        }

    }

    public Collection<Book> findAllBooks() throws Exception {
        return remoteService.findAllBooks();
    }

    public Collection<Book> findBooks(String title) throws Exception {
        return remoteService.findBooks(title);
    }
}
