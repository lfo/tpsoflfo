package fr.devcoop.jee.tp7;

import fr.devcoop.jee.tp7.DAOException;
import fr.devcoop.jee.tp7.impl.BookDAOJPAImpl;
import fr.devcoop.jee.tp7.impl.PersonDAOJPAImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author lfo
 */
public abstract class TestAbs {

    protected static EntityManager em;
    protected static PersonDAOJPAImpl personDAO;
    protected static BookDAOJPAImpl bookDAO;
    protected static EntityManagerFactory emf;
    
    @BeforeClass
    public static void init() throws Exception {
        emf = Persistence.createEntityManagerFactory("jee-tp7-pu");
        em = emf.createEntityManager();
        personDAO = new PersonDAOJPAImpl(em);
        bookDAO = new BookDAOJPAImpl(em);
    }

    @AfterClass
    public static void close() throws DAOException {
        em.close();
    }
}
