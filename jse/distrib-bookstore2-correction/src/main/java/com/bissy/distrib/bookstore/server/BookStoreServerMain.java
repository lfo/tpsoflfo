package com.bissy.distrib.bookstore.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.change.ChangeService;

public class BookStoreServerMain {

    public final static String SERVICE_URL = "rmi://localhost/bsService";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        System.out.println("Registry found ...");
        ChangeService changeService = null;
        Remote remote = registry.lookup(ChangeService.SERVICE_URL);
        if (remote instanceof ChangeService) {
            changeService = (ChangeService) remote;
        }
        System.out.println(ChangeService.SERVICE_URL + " found ...");

        BookStoreServiceImpl bsServiceImpl = new BookStoreServiceImpl(changeService);
        registry.rebind(SERVICE_URL, bsServiceImpl);
        System.out.println(SERVICE_URL + " bound ...");
    }
}
