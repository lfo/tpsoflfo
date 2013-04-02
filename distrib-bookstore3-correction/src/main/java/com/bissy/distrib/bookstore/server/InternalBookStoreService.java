package com.bissy.distrib.bookstore.server;

import java.rmi.RemoteException;
import java.util.Collection;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;

public interface InternalBookStoreService extends BookStoreService {

	public Collection<Book> findLocallyAllBooks() throws RemoteException;
	public Collection<Book> findLocallyBook(String title) throws RemoteException;
	public Amount getLocallyPrice(Book book) throws RemoteException;
	public boolean buyLocally(Book book, Amount price) throws RemoteException;
}
