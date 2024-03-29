package fr.devcoop.jee.tp6;

//import fr.devcoop.jee.tp6.Media;
import fr.devcoop.jee.tp6.Book;
import fr.devcoop.jee.tp6.Person;
//import fr.devcoop.jee.tp6.DVD;
import fr.devcoop.jee.tp6.DAOException;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lforet
 */
public class MediaDAOTest extends TestAbs {

    public static final String LA_FOIRE_AUX_ASTICOTS = "La foire aux asticots";
    public static final String LA_PELOUSE = "La Pelouse";
    public static final String LES_PETITS_MOUCHOIRS = "Les petits mouchoirs";
    public static final String LE_MONTECHARGE = "Le Monte-charge";
    public static final String LHORRIBLE_MONSIEUR_SMITH = "L'horrible Monsieur Smith";
    public static final String MEGAMIND = "Megamind";
    public static final long MEGAMIND_DURATION = 110l;
    public static final long MOUCHOIRS_DURATION = 120l;
    public static final String PUISQUE_LES_OISEAUX_MEURENT = "Puisque les oiseaux meurent";

    @BeforeClass
    public static void cleanInsert() throws DAOException {
        cleanData();
        insertData();
    }

    @Test
    public void checkDuration() {
//        DVD dvd = dvdDAO.findByTitle(MEGAMIND).iterator().next();
//        assertEquals(MEGAMIND_DURATION, dvd.getDuration());
    }

    @Test
    public void checkAuthors() {
//        Book foire = bookDAO.findByTitle(LA_FOIRE_AUX_ASTICOTS).iterator().next();
//        assertEquals(2, foire.getAuthors().size());
    }

    @Test
    public void checkOwned() throws DAOException{
//        Person jacques = personDAO.findAllWithPrefixLastName(PersonDAOTest.SMITH).iterator().next();
//        assertEquals(4, jacques.getOwnedMedia().size());
    }

    private static void insertData() throws DAOException {
//        final Person pierre = personDAO.create(PersonDAOTest.PIERRE, PersonDAOTest.DUPONT);
//        final Person paul = personDAO.create(PersonDAOTest.PAUL, PersonDAOTest.DURAND);
//        final Person jacques = personDAO.create(PersonDAOTest.JACQUES, PersonDAOTest.SMITH);
//        final Book foire = bookDAO.persist(new Book(LA_FOIRE_AUX_ASTICOTS));
//        final Book pelouse = bookDAO.persist(new Book(LA_PELOUSE));
//        final Book oiseaux = bookDAO.persist(new Book(PUISQUE_LES_OISEAUX_MEURENT));
//        final Book monteCharge = bookDAO.persist(new Book(LE_MONTECHARGE));
//        final Book horrible = bookDAO.persist(new Book(LHORRIBLE_MONSIEUR_SMITH));
//        final DVD mouchoirs = dvdDAO.persist(new DVD(LES_PETITS_MOUCHOIRS, MOUCHOIRS_DURATION));
//        final DVD megamind = dvdDAO.persist(new DVD(MEGAMIND, MEGAMIND_DURATION));
//
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        foire.getAuthors().add(pierre);
//        pierre.getWrittenBooks().add(foire);
//
//        foire.getAuthors().add(paul);
//        paul.getWrittenBooks().add(foire);
//
//        foire.setOwner(jacques);
//        jacques.getOwnedMedia().add(foire);
//        pelouse.setOwner(jacques);
//        jacques.getOwnedMedia().add(pelouse);
//        oiseaux.setOwner(jacques);
//        jacques.getOwnedMedia().add(oiseaux);
//        mouchoirs.setOwner(jacques);
//        jacques.getOwnedMedia().add(mouchoirs);
//
//        monteCharge.getAuthors().add(pierre);
//        pierre.getWrittenBooks().add(monteCharge);
//        horrible.getAuthors().add(pierre);
//        pierre.getWrittenBooks().add(horrible);
//        tx.commit();

    }

    private static void cleanData() throws DAOException {
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        for (Media media : bookDAO.getAll()) {
//            entityManager.remove(media);
//        }
//
//        tx.commit();
//        tx = entityManager.getTransaction();
//        tx.begin();
//        for (Person person : personDAO.getAllPersons()) {
//            entityManager.remove(person);
//        }
//
//        tx.commit();
    }
}
