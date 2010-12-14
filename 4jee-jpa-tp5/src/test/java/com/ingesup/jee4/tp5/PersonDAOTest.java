package com.ingesup.jee4.tp5;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonDAOTest extends TestAbs {

    public static final String DUPONT = "Dupont";
    public static final String DURAND = "Durand";
    public static final String JACQUES = "Jacques";
    public static final String PAUL = "Paul";
    public static final String PIERRE = "Pierre";
    public static final String SMITH = "Smith";
      

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
        List<Person> smiths = personDAO.findAllWithPrefixLastName(SMITH);
        assertEquals(1, smiths.size());
        Person personToUpdate = smiths.iterator().next();
        entityManager.detach(personToUpdate);
        personToUpdate.setLastName(DUPONT);
        personDAO.updateLastName(personToUpdate);
        smiths = personDAO.findAllWithPrefixLastName(SMITH);
        assertTrue(smiths.isEmpty());
        assertEquals(3, personDAO.getAllPersons().size());
    }
    
    @Test 
    public void testDelete() throws DAOException {
        deleteAll();
        createPersons();
        List<Person> durands = personDAO.findAllWithPrefixLastName(DURAND);
        assertEquals(1, durands.size());
        Person personToDelete = durands.iterator().next();
        personDAO.delete(personToDelete);
        durands = personDAO.findAllWithPrefixLastName(DURAND);
        assertTrue(durands.isEmpty());
        assertEquals(2, personDAO.getAllPersons().size());
    }

    static void createPersons() throws DAOException {
        personDAO.create(PIERRE, DUPONT);
        personDAO.create(PAUL, DURAND);
        personDAO.create(JACQUES, SMITH);
    }

    static void deleteAll() throws DAOException {
        List<Person> persons = personDAO.getAllPersons();
        for (Person person : persons) {
            personDAO.delete(person);
        }
    }
}
