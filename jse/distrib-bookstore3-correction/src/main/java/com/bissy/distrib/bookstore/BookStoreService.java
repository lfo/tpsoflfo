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
    public Collection<Book> findAllBooks() throws RemoteException;

    /**
     * Cette méthode permet de chercher un livre selon son titre.
     *
     * @param title
     * @return
     * @throws Exception
     */
    public Collection<Book> findBook(String title) throws RemoteException;

    /**
     * Cette méthode renvoit le prix d'un livre dans une certaine monnaie.
     *
     * @param book
     * @return le prix 
     * @throws Exception
     */
    public Amount getPrice(Book book) throws RemoteException;

    /**
     * Cette méthode permet d'acheter un livre. Le montant donnée en paramètre
     * doit être égale au prix réel du livre.
     *
     * @param book
     * @param price
     * @throws Exception est levée si le montant n'est pas égale au prix réel.
     */
    public void buy(Book book, Amount price) throws RemoteException;

}
