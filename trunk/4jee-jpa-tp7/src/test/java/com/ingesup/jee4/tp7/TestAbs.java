package com.ingesup.jee4.tp7;

import com.ingesup.jee4.tp7.impl.BookDAOJPAImpl;
import com.ingesup.jee4.tp7.impl.PersonDAOJPAImpl;
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

    @BeforeClass
    public static void init() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("4jee-tp7-pu");
        em = emf.createEntityManager();
        personDAO = new PersonDAOJPAImpl(em);
        bookDAO = new BookDAOJPAImpl(em);
    }

    @AfterClass
    public static void close() throws DAOException {
        em.close();
    }
}
