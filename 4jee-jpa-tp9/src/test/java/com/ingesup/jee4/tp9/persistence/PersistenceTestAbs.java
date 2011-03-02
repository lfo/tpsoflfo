package com.ingesup.jee4.tp9.persistence;

import com.ingesup.jee4.tp9.persistence.DAOException;
import com.ingesup.jee4.tp9.persistence.impl.BookDAOJPAImpl;
import com.ingesup.jee4.tp9.persistence.impl.PersonDAOJPAImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author lfo
 */
public abstract class PersistenceTestAbs {

    protected static EntityManager em;
    protected static PersonDAOJPAImpl personDAO;
    protected static BookDAOJPAImpl bookDAO;

    @BeforeClass
    public static void init() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("4jee-tp9-pu");
        em = emf.createEntityManager();
        personDAO = new PersonDAOJPAImpl(em);
        bookDAO = new BookDAOJPAImpl(em);
    }

    @AfterClass
    public static void close() throws DAOException {
        em.close();
    }
}
