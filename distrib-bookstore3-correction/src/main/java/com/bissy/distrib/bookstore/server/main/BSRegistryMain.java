package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.bookstore.BookStoreRegistryService;
import com.bissy.distrib.bookstore.registry.BSRegistryServiceRemoteImpl;

public class BSRegistryMain {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        BookStoreRegistryService bookStoreRegistryService = new BSRegistryServiceRemoteImpl();
        registry.rebind(BookStoreRegistryService.SERVICE_URL, bookStoreRegistryService);
        System.out.println(BookStoreRegistryService.SERVICE_URL + " bound ...");
    }
}
