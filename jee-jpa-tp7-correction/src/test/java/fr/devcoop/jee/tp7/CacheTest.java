package fr.devcoop.jee.tp7;

import fr.devcoop.jee.tp7.Book;
import fr.devcoop.jee.tp7.Person;
import javax.persistence.Cache;
import javax.persistence.EntityTransaction;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class CacheTest extends TestAbs {

    @Test
    public void testCache() {
        Person pierre = new Person("Pierre", "Dupond");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pierre);
        tx.commit();

        final Book foire = bookDAO.persistBook(new Book(BookDAOTest.LA_FOIRE_AUX_ASTICOTS));
        final Book pelouse = bookDAO.persistBook(new Book(BookDAOTest.LA_PELOUSE));
        
        Cache cache = emf.getCache();
        
        Assert.assertTrue(cache.contains(Person.class, pierre.getId()));
        Assert.assertTrue(cache.contains(Book.class, foire.getId()));
        Assert.assertTrue(cache.contains(Book.class, pelouse.getId()));
         
        cache.evict(Person.class);
        cache.evict(Book.class, foire.getId());
        Assert.assertFalse(cache.contains(Person.class, pierre.getId()));
        Assert.assertFalse(cache.contains(Book.class, foire.getId()));
        Assert.assertTrue(cache.contains(Book.class, pelouse.getId()));
    }
}
