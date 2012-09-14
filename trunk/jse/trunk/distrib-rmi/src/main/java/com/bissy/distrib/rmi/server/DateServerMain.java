package com.bissy.distrib.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DateServerMain {

    public final static String SERVICE_URL = "rmi://localhost/heureDeMoscou";

    public static void main(String... args) throws Exception {        
//        System.setSecurityManager(new UnsecurityManager());
        
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        System.out.println("Registry launched ...");
        DateServiceRemoteImpl dateServiceServer = new DateServiceRemoteImpl();
        registry.rebind(SERVICE_URL, dateServiceServer);
        System.out.println(SERVICE_URL+" bound ...");
    }
}
