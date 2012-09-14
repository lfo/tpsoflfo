package com.bissy.distrib.bookstore.server;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;
import java.util.Collection;
import java.util.Collections;
import javax.jws.WebService;

/**
 *
 * @author lforet
 */
@WebService(endpointInterface = "com.bissy.distrib.bookstore.BookStoreService",
serviceName = "BookStoreWS")
public class BookStoreWS implements BookStoreService {

    private final static BookStoreDao BOOK_STORE_DAO = new BookStoreDao();

    public Collection<Book> findAllBooks() throws Exception {
        return BOOK_STORE_DAO.findAllBooks();
    }

    public Collection<Book> findBooks(String title) throws Exception {
        return Collections.singletonList(BOOK_STORE_DAO.findBook(title));
    }
}
