package fr.devcoop.jee.tp6.impl;

import fr.devcoop.jee.tp6.MediaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lforet
 */
public abstract class MediaDAOJPAAbstract<M> implements MediaDAO<M> {

    protected EntityManager entityManager;

    public MediaDAOJPAAbstract(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public M persist(M media) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(media);
        tx.commit();
        return media;
    }

    @Override
    public M update(M media) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(media);
        tx.commit();
        return media;
    }
}
