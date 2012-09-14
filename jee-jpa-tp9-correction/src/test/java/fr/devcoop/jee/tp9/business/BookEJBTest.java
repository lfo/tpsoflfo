package fr.devcoop.jee.tp9.business;

import fr.devcoop.jee.tp9.persistence.Book;
import java.util.List;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class BookEJBTest extends BusinessTestAbs {

    @Test
    public void test() throws NamingException {
        BookEJBLocal bookEJBLocal = (BookEJBLocal) ctx.lookup("java:global/classes/BookEJB!fr.devcoop.jee.tp9.business.BookEJBLocal");
        Assert.assertNotNull(bookEJBLocal);
        BookEJBRemote bookEJBRemote = (BookEJBRemote) ctx.lookup("java:global/classes/BookEJB!fr.devcoop.jee.tp9.business.BookEJBRemote");
        Assert.assertNotNull(bookEJBRemote);

        bookEJBLocal.persistBook(new Book("La pelouse"));
        
        List<Book> books = bookEJBRemote.getAllBooks();
        int size = books.size();
        Assert.assertTrue(size > 0);                
    }
    
    
}
