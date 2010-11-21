package com.ingesup.jee4.tp4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonDAOTest {
    public static final String DUPONT = "Dupont";
    public static final String DURAND = "Durand";
    public static final String JACQUES = "Jacques";
    public static final String PAUL = "Paul";
    public static final String PIERRE = "Pierre";
    public static final String SMITH = "Smith";

    private static PersonDAOJPAImpl personDAO;
    private static EntityManager entityManager;

    @BeforeClass
    public static void init() throws Exception {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("4jee-tp4-pu");
       entityManager = emf.createEntityManager();
    }

    @AfterClass
    public static void close() throws DAOException {
        entityManager.close();
    }
        
    
    @Test
    public void testDeleteAll() throws DAOException {
        createPersons();
        List<Person> persons = personDAO.getAllPersons();
        assertFalse(persons.isEmpty());
        deleteAll();
        persons = personDAO.getAllPersons();
        assertTrue(persons.isEmpty());
    }
    
    @Test
    public void testCreate() throws DAOException {
        deleteAll(); 
        List<Person> persons = personDAO.getAllPersons();
        assertTrue(persons.isEmpty());
        createPersons();
        persons = personDAO.getAllPersons();
        assertEquals(3, persons.size());
    }
    
    @Test 
    public void testByPrefix() throws DAOException {
        deleteAll();
        createPersons();
        List<Person> persons = personDAO.findAllWithPrefixLastName("Du");
        assertEquals(2, persons.size());
    }
    
    @Test 
    public void testUpdate() throws DAOException {
        deleteAll();
        createPersons();
        
    }

    private void createPersons() throws DAOException {
        personDAO.create(PIERRE, DUPONT);
        personDAO.create(PAUL, DURAND);
        personDAO.create(JACQUES, SMITH);        
    }
    
    private void deleteAll() throws DAOException {
        List<Person> persons = personDAO.getAllPersons();
        for (Person person : persons) {
            personDAO.delete(person);
        }
    }
    
}
