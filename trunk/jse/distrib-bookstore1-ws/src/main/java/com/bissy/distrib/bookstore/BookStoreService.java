package com.bissy.distrib.bookstore;

import java.util.Collection;
import javax.jws.WebService;

/**
 * Magasin de livre en ligne. 
 */
@WebService
public interface BookStoreService {

    
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
