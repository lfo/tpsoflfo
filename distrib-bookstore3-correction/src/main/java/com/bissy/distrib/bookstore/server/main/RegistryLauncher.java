package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RegistryLauncher {

    public static void main(String... args) throws Exception {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        System.out.println("Registry launched ...");
        while (true) {
            Thread.sleep(60*1000);
        }
    }
}
