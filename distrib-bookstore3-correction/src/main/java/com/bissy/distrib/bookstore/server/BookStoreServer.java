package com.bissy.distrib.bookstore.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import com.bissy.distrib.bookstore.BookStoreRegistryService;
import com.bissy.distrib.bookstore.BookStoreService;
import com.bissy.distrib.bookstore.persistence.BookStoreDao;
import com.bissy.distrib.change.ChangeService;

public class BookStoreServer {

	private String serviceUrl;
	private Registry registry;
	private BookStoreDao bookStoreDao;
	

	public BookStoreServer(String serviceUrl, Registry registry, BookStoreDao bookStoreDao) {
		this.serviceUrl = serviceUrl;
		this.registry = registry;
		this.bookStoreDao = bookStoreDao;
	}
	
	public void launch() throws RemoteException, NotBoundException{
		ChangeService changeService = (ChangeService) registry.lookup(ChangeService.SERVICE_URL);
		BookStoreRegistryService bookStoreRegistryService = (BookStoreRegistryService) registry.lookup(BookStoreRegistryService.SERVICE_URL);
		BookStoreService bookStoreService = 
			new BookStoreServiceRemoteImpl(serviceUrl, bookStoreDao, bookStoreRegistryService, changeService, registry);
		registry.rebind(serviceUrl, bookStoreService);
		System.out.println(serviceUrl+" bound to RMIRegistry");
		bookStoreRegistryService.addServer(serviceUrl);
		System.out.println(serviceUrl+" bound to BSRegistryService");
	}
}
