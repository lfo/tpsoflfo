package fr.devcoop.jee.tp5;

import org.junit.Before;
import java.util.List;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lforet
 */
public class BookDAOTest extends TestAbs {

    public static final String LA_FOIRE_AUX_ASTICOTS = "La foire aux asticots";
    public static final String LA_PELOUSE = "La Pelouse";
    public static final String LE_MONTECHARGE = "Le Monte-charge";
    public static final String LHORRIBLE_MONSIEUR_SMITH = "L'horrible Monsieur Smith";
    public static final String PUISQUE_LES_OISEAUX_MEURENT = "Puisque les oiseaux meurent";

    @Before
    public void cleanInsert() throws DAOException {
        cleanData();
        insertData();        
    }

//    @Test
    public void findByPrefix() throws DAOException {
        assertNotNull(bookDAO.findBookByTitle(LA_PELOUSE));
    }

    @Test
    public void validScenario1() throws DAOException {
        Book laFoire = bookDAO.findBookByTitle(LA_FOIRE_AUX_ASTICOTS).iterator().next();
        List<Person> authors = bookDAO.getAuthors(laFoire);
        assertEquals(2, authors.size());
        for (Person author : authors) {
            assertTrue(author.getFirstName().equals(PersonDAOTest.PAUL) || author.getFirstName().equals(PersonDAOTest.PIERRE));
        }
    }

//    @Test
    public void validScenario2() throws DAOException {
        Person person = personDAO.findAllWithPrefixLastName(PersonDAOTest.SMITH).iterator().next();
        assertEquals(3, bookDAO.getOwned(person).size());
    }

//    @Test
    public void validScenario3() throws DAOException {
        Person pierre = personDAO.findAllWithPrefixLastName(PersonDAOTest.DUPONT).iterator().next();
        List<Book> books = pierre.getWrittenBooks();
        assertEquals(3, books.size());
    }

    private void insertData() throws DAOException {
        final Person pierre = personDAO.create(PersonDAOTest.PIERRE, PersonDAOTest.DUPONT);
        final Person paul = personDAO.create(PersonDAOTest.PAUL, PersonDAOTest.DURAND);
        final Person jacques = personDAO.create(PersonDAOTest.JACQUES, PersonDAOTest.SMITH);
        final Book foire = bookDAO.persistBook(new Book(LA_FOIRE_AUX_ASTICOTS));
        final Book pelouse = bookDAO.persistBook(new Book(LA_PELOUSE));
        final Book oiseaux = bookDAO.persistBook(new Book(PUISQUE_LES_OISEAUX_MEURENT));
        final Book monteCharge = bookDAO.persistBook(new Book(LE_MONTECHARGE));
        final Book horrible = bookDAO.persistBook(new Book(LHORRIBLE_MONSIEUR_SMITH));

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        foire.getAuthors().add(pierre);
        pierre.getWrittenBooks().add(foire);

        foire.getAuthors().add(paul);
        paul.getWrittenBooks().add(foire);

        foire.setOwner(jacques);
        pelouse.setOwner(jacques);
        oiseaux.setOwner(jacques);

        monteCharge.getAuthors().add(pierre);
        pierre.getWrittenBooks().add(monteCharge);
        horrible.getAuthors().add(pierre);
        pierre.getWrittenBooks().add(horrible);
        tx.commit();
    }

    private void cleanData() throws DAOException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        for (Book book : bookDAO.getAllBooks()) {
            entityManager.remove(book);
        }

        for (Person person : personDAO.getAllPersons()) {
            entityManager.remove(person);
        }
        tx.commit();
    }
}
