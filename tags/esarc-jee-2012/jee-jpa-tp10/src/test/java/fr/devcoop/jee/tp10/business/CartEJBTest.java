package fr.devcoop.jee.tp10.business;

import fr.devcoop.jee.tp10.business.BookEJBLocal;
import fr.devcoop.jee.tp10.business.CartRemote;
import fr.devcoop.jee.tp10.persistence.Book;
import java.math.BigDecimal;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class CartEJBTest extends BusinessTestAbs {

    @Test
    public void test() throws NamingException {
        BookEJBLocal bookEJBLocal = (BookEJBLocal) ctx.lookup("java:global/classes/BookEJB!fr.devcoop.jee.tp9.business.BookEJBLocal");
        Assert.assertNotNull(bookEJBLocal);
        
        Book pelouseBook = bookEJBLocal.persistBook(new Book("La pelouse"));
        int storeSize =  bookEJBLocal.getAllBooks().size();
                
        CartRemote cart = (CartRemote)ctx.lookup("java:global/classes/CartEJB");
        Assert.assertNotNull(cart);
        
        cart.addBook(pelouseBook);
        BigDecimal price = cart.checkoutCart();
        Assert.assertNotNull(price);
        int newStoreSize =  bookEJBLocal.getAllBooks().size();
        
        Assert.assertTrue( newStoreSize == storeSize-1);
        System.out.println("Price to pay :"+price);
    }

}
