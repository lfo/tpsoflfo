package com.bissy.distrib.bookstore.client;

import java.awt.EventQueue;

public abstract class BookStoreClientMain {

    
    public static void main(String ... args) throws Exception {
//        Collection<Book> books = BookFactory.createBooks();
        final BookViewer bookViewer = new BookViewer(new BookStoreClient());
//        bookViewer.setBooks(books);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                bookViewer.setVisible(true);
            }
        });
       
    }

}
