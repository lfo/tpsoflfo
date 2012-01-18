package com.ingesup.jee4.tp9.business.impl;

import com.ingesup.jee4.tp9.business.BookEJBLocal;
import com.ingesup.jee4.tp9.business.CartRemote;
import com.ingesup.jee4.tp9.persistence.Book;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author lforet
 */
@Stateful
public class CartEJB implements CartRemote {

    @EJB
    private PriceGenerator priceGenerator;
    @EJB
    private BookEJBLocal bookEJBLocal;
    
    private Set<Book> cart = new HashSet<Book>();

    @Override
    public void addBook(Book book) {
        cart.add(book);
    }

    @Override
    public void removeBook(Book book) {
        cart.remove(book);
    }

    @Remove
    @Override
    public BigDecimal checkoutCart() {
        BigDecimal price = new BigDecimal(0);
        for (Book book : cart) {
            price = price.add(priceGenerator.getPrice(book.getTitle()));
            bookEJBLocal.removeBook(book);
        }
        cart.clear();
        return price;
    }
}
