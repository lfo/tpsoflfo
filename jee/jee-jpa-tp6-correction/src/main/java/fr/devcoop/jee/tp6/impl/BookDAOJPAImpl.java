package fr.devcoop.jee.tp6.impl;


import fr.devcoop.jee.tp6.Book;
import fr.devcoop.jee.tp6.MediaDAO;
import fr.devcoop.jee.tp6.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lforet
 */
public class BookDAOJPAImpl extends MediaDAOJPAAbstract<Book> implements MediaDAO<Book> {

    public BookDAOJPAImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Book> getAll() throws DAOException {
        Query query = entityManager.createNamedQuery("allBooks");
        List<Book> toReturn = query.getResultList();
        return toReturn;
    }

    @Override
    public List<Book> findByTitle(String titlePrefix) {
        Query query = entityManager.createQuery("select b from Book b where b.title like :title");
        query.setParameter("title", titlePrefix + "%");
        List<Book> books = query.getResultList();
        return books;
    }

  
}
