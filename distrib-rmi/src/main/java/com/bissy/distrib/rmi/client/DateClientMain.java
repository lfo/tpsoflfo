package com.bissy.distrib.rmi.client;

import com.bissy.distrib.rmi.DateService;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DateClientMain {

    public final static String RMI_SERVICE_NAME = "rmi://localhost/heureDeMoscou";

    public static void main(String... args) throws Exception {
//        System.setSecurityManager(new UnsecurityManager());
        Registry registry = LocateRegistry.getRegistry();
        Remote remote = registry.lookup(RMI_SERVICE_NAME);
        if (remote instanceof DateService) {
            System.out.print("l'heure de moscou est : ");
            DateService dateService = (DateService)remote;
            System.out.println(dateService.getOfficialDate());
        }
    }
}
