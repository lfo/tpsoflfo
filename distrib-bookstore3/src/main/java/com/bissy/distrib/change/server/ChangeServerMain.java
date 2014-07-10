package com.bissy.distrib.change.server;

import com.bissy.distrib.change.ChangeService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChangeServerMain {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
        System.out.println("Registry found ...");
        ChangeService changeService = new ChangeServiceRemoteImpl();
        registry.rebind(ChangeService.SERVICE_URL, changeService);
        System.out.println(ChangeService.SERVICE_URL + " bound ...");

    }
}
