package com.bissy.distrib.bookstore.server.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.bissy.distrib.change.ChangeService;
import com.bissy.distrib.change.ChangeServiceRemoteImpl;

public class ChangeServiceMain {

	public static void main(String... args) throws Exception {
    	Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        
        ChangeService changeService = new ChangeServiceRemoteImpl();
        registry.rebind(ChangeService.SERVICE_URL, changeService);
        System.out.println(ChangeService.SERVICE_URL+" bound ...");
    }
}
