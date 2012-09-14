package com.bissy.distrib.bookstore.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookStoreServerMain {

    public final static String SERVICE_URL = "rmi://localhost/bsService";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        System.out.println("Registry launched ...");
        BookStoreServiceImpl bsServiceImpl = new BookStoreServiceImpl();
        registry.rebind(SERVICE_URL, bsServiceImpl);
        System.out.println(SERVICE_URL + " bound ...");
    }
}
