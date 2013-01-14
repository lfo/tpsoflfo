package fr.devcoop.jee.tp2;


import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON(ID IDENTITY PRIMARY KEY, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255));
INSERT INTO PERSON (firstName, lastName)  VALUES ('Paul', 'Dupont');
INSERT INTO PERSON (firstName, lastName)  VALUES('Jacques', 'Perrin');
SELECT * FROM PERSON ORDER BY ID;
 * @author lfo
 */
public class PersonDAOTest {
    public static final String DUPONT = "Dupont";
    public static final String DURAND = "Durand";
    public static final String JACQUES = "Jacques";
    public static final String PAUL = "Paul";
    public static final String PIERRE = "Pierre";
    public static final String SMITH = "Smith";

    private static PersonDAO personDAO = new PersonDAOImpl();

    @BeforeClass
    public static void initConnection() throws Exception {
        personDAO.initConnection();
    }

    @AfterClass
    public static void closeConnection() throws DAOException {
        personDAO.close();
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
        // TODO
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
