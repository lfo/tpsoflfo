package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Book;
import java.awt.EventQueue;
import java.util.Collection;
import java.util.Collections;

public abstract class BookStoreClientMain {

    
    public static void main(String ... args) {
        Collection<Book> books = Collections.emptyList();
        final BookViewer bookViewer = new BookViewer(new BookStoreClient());
        bookViewer.setBooks(books);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                bookViewer.setVisible(true);
            }
        });
       
    }

}
