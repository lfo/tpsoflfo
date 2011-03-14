package com.ingesup.jee4.tp9.business;

import com.ingesup.jee4.tp9.persistence.Book;
import java.math.BigDecimal;
import javax.ejb.Remote;

/**
 *
 * @author lforet
 */
@Remote
public interface CartRemote {

    
    public void addBook(Book book);
    public void removeBook(Book book);

    public BigDecimal checkoutCart();
    
}