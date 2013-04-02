package com.bissy.distrib.bookstore;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface BookStoreRegistryService extends Remote {

	public final static String SERVICE_URL = "rmi://bookStoreRegistryService";
	
	public void addServer(String rmiURL) throws RemoteException;
	public void removeServer(String rmiURL) throws RemoteException;
	public Collection<String> getServers() throws RemoteException;
	
}
