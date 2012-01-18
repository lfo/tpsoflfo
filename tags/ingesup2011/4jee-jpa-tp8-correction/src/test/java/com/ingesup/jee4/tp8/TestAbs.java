package com.ingesup.jee4.tp8;

import com.ingesup.jee4.tp8.impl.BookDAOJPAImpl;
import com.ingesup.jee4.tp8.impl.DVDDAOJPAImpl;
import com.ingesup.jee4.tp8.impl.PersonDAOJPAImpl;
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

    protected static EntityManager entityManager;
    protected static PersonDAOJPAImpl personDAO;
    protected static BookDAOJPAImpl bookDAO;
    protected static DVDDAOJPAImpl dvdDAO;

    @BeforeClass
    public static void init() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("4jee-tp8-pu");
        entityManager = emf.createEntityManager();
        personDAO = new PersonDAOJPAImpl(entityManager);
        bookDAO = new BookDAOJPAImpl(entityManager);
        dvdDAO = new DVDDAOJPAImpl(entityManager);
    }

    @AfterClass
    public static void close() throws DAOException {
        entityManager.close();
    }
}
