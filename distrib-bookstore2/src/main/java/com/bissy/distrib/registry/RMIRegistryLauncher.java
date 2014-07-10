package com.bissy.distrib.registry;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author lfo
 */
public class RMIRegistryLauncher {
    
    public static void main(String ... args) throws Exception {
         LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
         System.out.println("RMI registry launched ...");
    }
    
}
