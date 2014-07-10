package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import java.awt.EventQueue;
import java.util.Collection;

public abstract class BookStoreClientMain {

    
    public static void main(String ... args) throws Exception {
        Collection<Book> books = BookFactory.createBooks();
        final BookViewer bookViewer = new BookViewer(new BookStoreClient());
        bookViewer.setBooks(books);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                bookViewer.setVisible(true);
            }
        });
       
    }

}
