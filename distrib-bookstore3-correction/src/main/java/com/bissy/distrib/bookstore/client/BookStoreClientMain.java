package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import com.bissy.distrib.bookstore.BookStoreService;

import java.awt.EventQueue;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

public abstract class BookStoreClientMain {

	public final static String SERVICE_URL = "rmi://MerignacBookStore";
	
    public static void main(String ... args) throws Exception {
        
        Registry registry = LocateRegistry.getRegistry();
        Remote remote = registry.lookup(SERVICE_URL);
        System.out.println(SERVICE_URL +" lookup : \n"+remote);
        final BookViewer bookViewer = new BookViewer((BookStoreService)remote);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                bookViewer.setVisible(true);
            }
        });
       
    }

}
