package com.bissy.distrib.bookstore.registry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashSet;

import com.bissy.distrib.bookstore.BookStoreRegistryService;

public class BSRegistryServiceRemoteImpl extends UnicastRemoteObject implements BookStoreRegistryService {

    Collection<String> servers = new HashSet<String>();

    public BSRegistryServiceRemoteImpl() throws RemoteException {
    }

    public void addServer(String rmiURL) throws RemoteException {
        System.out.println(String.format("addServer(%s)", rmiURL));
        servers.add(rmiURL);
    }

    public Collection<String> getServers() throws RemoteException {
        System.out.println(String.format("getServers() return %s servers", servers.size()));
        return servers;
    }

    public void removeServer(String rmiURL) throws RemoteException {
        System.out.println(String.format("removeServer(%s)", rmiURL));
        servers.remove(rmiURL);
    }
}
