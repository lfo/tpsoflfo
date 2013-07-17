package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.bookstore.persistence.BookStoreDao;
import com.bissy.distrib.bookstore.persistence.Databases;
import com.bissy.distrib.bookstore.server.BookStoreServer;

public class NewYorkServerMain {

    public final static String NEW_YORK_URL = "rmi://NewYorkBookStore";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        BookStoreDao bookStoreDao = new BookStoreDao(Databases.NEW_YORK_BOOK_DATABASE, Databases.NEW_YORK_PRICE_DATABASE);
        BookStoreServer bookStoreServer = new BookStoreServer(NEW_YORK_URL, registry, bookStoreDao);
        bookStoreServer.launch();

    }
}
