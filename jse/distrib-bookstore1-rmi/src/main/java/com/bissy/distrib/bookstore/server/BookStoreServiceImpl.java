package com.bissy.distrib.bookstore.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;
import java.util.List;

public class BookStoreServiceImpl extends UnicastRemoteObject implements BookStoreService {

    protected BookStoreServiceImpl() throws RemoteException {
        super();
    }
    private final static BookStoreDao BOOK_STORE_DAO = new BookStoreDao();

    public Collection<Book> findAllBooks() throws Exception {
        List<Book> books = new ArrayList<Book>(BOOK_STORE_DAO.findAllBooks());
        System.out.println(String.format("findAllBooks() return %s books", books.size()));
        return books;
    }

    public Collection<Book> findBooks(String title) throws Exception {
        Collection<Book> books = new ArrayList<Book>();
        Book book = BOOK_STORE_DAO.findBook(title);
        if (book != null) {
            books.add(book);
        }
        System.out.println(String.format("findBooks(%s) return %s books", title, books.size()));
        return books;
    }
}
