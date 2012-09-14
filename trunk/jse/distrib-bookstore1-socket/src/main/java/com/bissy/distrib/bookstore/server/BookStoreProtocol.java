package com.bissy.distrib.bookstore.server;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import com.bissy.distrib.bookstore.Book;

public class BookStoreProtocol {

	private final static BookStoreDao BOOK_STORE_DAO = new BookStoreDao();
	
	public Collection<Book> processInput(String inputLine) throws Exception {
		System.out.println("processInput : "+inputLine);
		StringTokenizer tokenize = new StringTokenizer(inputLine, "#");
		String command = tokenize.nextToken();
		List<Book> toReturn = null;
		if ("findAllBooks".equals(command)) {
			toReturn = new ArrayList<Book>(BOOK_STORE_DAO.findAllBooks());
		} else if ("findBooks".equals(command)) {
			toReturn = new ArrayList<Book>();
			Book book = BOOK_STORE_DAO.findBook(tokenize.nextToken());
			if (book != null) {
				toReturn.add(book);
			}
			
		} else {
			throw new UnsupportedOperationException("Not supported");
		}
		System.out.println("find "+toReturn.size());
		return toReturn;
	}
}
