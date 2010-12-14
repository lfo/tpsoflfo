package com.ingesup.jee4.tp5;

import com.ingesup.jee4.tp5.impl.BookDAOJPAImpl;
import org.junit.Test;

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
    private BookDAOJPAImpl bookDAO;

    @Test
    public void findByPrefix() throws DAOException {
        insertData();
        throw new UnsupportedOperationException("TODO");
    }

    @Test
    public void getOwner() throws DAOException {
        insertData();
        throw new UnsupportedOperationException("TODO");
    }

    @Test
    public void getAuthors() throws DAOException {
        insertData();
        throw new UnsupportedOperationException("TODO");
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


    }
}
