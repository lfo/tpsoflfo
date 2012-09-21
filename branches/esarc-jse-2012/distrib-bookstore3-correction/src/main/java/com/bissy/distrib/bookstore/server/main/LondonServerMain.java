package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.bookstore.persistence.BookStoreDao;
import com.bissy.distrib.bookstore.persistence.Databases;
import com.bissy.distrib.bookstore.server.BookStoreServer;

public class LondonServerMain {

    public final static String LONDON_URL = "rmi://LondonBookStore";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        BookStoreDao bookStoreDao = new BookStoreDao(Databases.LONDON_BOOK_DATABASE, Databases.LONDON_PRICE_DATABASE);
        BookStoreServer bookStoreServer = new BookStoreServer(LONDON_URL, registry, bookStoreDao);
        bookStoreServer.launch();
    }
}
