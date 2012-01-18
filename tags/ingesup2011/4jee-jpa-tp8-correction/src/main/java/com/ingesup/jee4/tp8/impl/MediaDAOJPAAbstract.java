package com.ingesup.jee4.tp8.impl;

import com.ingesup.jee4.tp8.Media;
import com.ingesup.jee4.tp8.MediaDAO;
import com.ingesup.jee4.tp8.Media_;
import com.ingesup.jee4.tp8.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public List<M> findMediaWithAtLeast2Authors() {
        Query query = entityManager.createQuery(
                "Select m from Media m where (SELECT count(p) FROM m.authors p) > 1");
        return query.getResultList();        
    }

    @Override
    public List<Media> findBy(String titlePrefix, List<Person> authors) {
        CriteriaBuilder bldr = entityManager.getCriteriaBuilder();
        CriteriaQuery<Media> query = bldr.createQuery(Media.class);
        Root<Media> p = query.from(Media.class);

        Predicate authorPredicate = null;
        Predicate titlePredicate = null;
        Predicate andPredicate = null;
        if (authors != null && !authors.isEmpty()) {
            authorPredicate = p.get(Media_.authors).in(authors);
            andPredicate = authorPredicate;
        }
        if (titlePrefix != null && !titlePrefix.isEmpty()) {
            titlePredicate = bldr.like(p.get(Media_.title), titlePrefix + "%");
            andPredicate = (authorPredicate != null) 
                    ? bldr.and(authorPredicate, titlePredicate)
                    : titlePredicate;

        }
        query = (andPredicate != null) 
                ? query.select(p).where(andPredicate) 
                : query.select(p);
        TypedQuery<Media> q = entityManager.createQuery(query);
        return (List<Media>) q.getResultList();

    }
}
