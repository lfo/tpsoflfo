package fr.devcoop.jee.tp6.impl;

import fr.devcoop.jee.tp6.DAOException;
import fr.devcoop.jee.tp6.DVD;
import fr.devcoop.jee.tp6.MediaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lforet
 */
public class DVDDAOJPAImpl extends MediaDAOJPAAbstract<DVD> implements MediaDAO<DVD> {

     public DVDDAOJPAImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<DVD> getAll() throws DAOException {
        Query query = entityManager.createNamedQuery("allDVDs");
        List<DVD> toReturn = query.getResultList();
        return toReturn;
    }

    @Override
    public List<DVD> findByTitle(String titlePrefix) {
        Query query = entityManager.createQuery("select d from DVD d where d.title like :title");
        query.setParameter("title", titlePrefix + "%");
        List<DVD> books = query.getResultList();
        return books;
    }

  
    
}
