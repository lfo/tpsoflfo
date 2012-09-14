package com.bissy.distrib.bookstore.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;

public class BookStoreClient implements BookStoreService {
	public static final String HOST_NAME = "localhost";
	public static final int SERVER_PORT = 4444;
	
	private PrintWriter out;
	private ObjectInputStream in;
	private Socket socket;
	
	public Collection<Book> findAllBooks() throws Exception {
		throw new UnsupportedOperationException("TODO");
	}

	public Collection<Book> findBooks(String title) throws Exception {
		throw new UnsupportedOperationException("TODO");
	}

	
}
