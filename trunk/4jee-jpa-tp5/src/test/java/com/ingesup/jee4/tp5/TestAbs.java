package com.ingesup.jee4.tp5;

import com.ingesup.jee4.tp5.DAOException;
import com.ingesup.jee4.tp5.impl.PersonDAOJPAImpl;
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

    @BeforeClass
    public static void init() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("4jee-tp5-pu");
        entityManager = emf.createEntityManager();
        personDAO = new PersonDAOJPAImpl(entityManager);
    }

    @AfterClass
    public static void close() throws DAOException {
        entityManager.close();
    }
}
