package fr.devcoop.jee.tp10.business;

import fr.devcoop.jee.tp10.persistence.Book;
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