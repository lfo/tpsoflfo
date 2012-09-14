package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.bookstore.persistence.BookStoreDao;
import com.bissy.distrib.bookstore.persistence.Databases;
import com.bissy.distrib.bookstore.server.BookStoreServer;

public class MerignacServerMain {

    public final static String MERIGNAC_URL = "rmi://MerignacBookStore";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        BookStoreDao bookStoreDao = new BookStoreDao(Databases.MERIGNAC_BOOK_DATABASE, Databases.MERIGNAC_PRICE_DATABASE);
        BookStoreServer bookStoreServer = new BookStoreServer(MERIGNAC_URL, registry, bookStoreDao);
        bookStoreServer.launch();
    }
}
