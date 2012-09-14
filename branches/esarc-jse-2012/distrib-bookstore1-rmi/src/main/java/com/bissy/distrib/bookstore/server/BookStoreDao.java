package com.bissy.distrib.bookstore.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;

/**
 * Data Access Object du magazin en ligne.
 */
public class BookStoreDao {

    private final static Map<String, Book> BOOK_DB_MAP = new HashMap<String, Book>();

    static {
        Collection<Book> books = BookFactory.createBooks();
        for (Book book : books) {
            BOOK_DB_MAP.put(book.getTitle(), book);
        }
    }

    public Book findBook(String title) throws Exception {
        return BOOK_DB_MAP.get(title);
    }

    public Collection<Book> findAllBooks() throws Exception {
        return BOOK_DB_MAP.values();
    }

    public void remove(Book book) throws Exception {
        BOOK_DB_MAP.remove(book.getTitle());
    }
}
