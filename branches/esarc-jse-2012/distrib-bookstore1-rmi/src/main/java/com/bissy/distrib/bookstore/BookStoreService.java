package com.bissy.distrib.bookstore;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * Magasin de livre en ligne. 
 */
public interface BookStoreService extends Remote {

    
    /**
     * Cette méthode permet de chercher tous les livres disponibles.
     * @return
     * @throws Exception
     */
    public Collection<Book> findAllBooks() throws Exception;

    /**
     * Cette méthode permet de chercher un livre selon son titre.
     *
     * @param title
     * @return
     * @throws Exception
     */
    public Collection<Book> findBooks(String title) throws Exception;

}
