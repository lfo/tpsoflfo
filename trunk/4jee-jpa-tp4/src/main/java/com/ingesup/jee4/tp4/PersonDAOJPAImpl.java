package com.ingesup.jee4.tp4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author lforet
 */
public class PersonDAOJPAImpl implements PersonDAO {

    private EntityManager entityManager;

    public PersonDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(String firstName, String lastName) throws DAOException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Person person = new Person(firstName, lastName);
        entityManager.persist(person);
        tx.commit();
    }

    @Override
    public void delete(Person person) throws DAOException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Person personToDelete = entityManager.getReference(Person.class, person.getId());
        entityManager.remove(personToDelete);
        tx.commit();
    }

    @Override
    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
        String jpqlString = "SELECT p FROM Person p WHERE p.lastName like :prefix";
        Query query = entityManager.createQuery(jpqlString);
        query.setParameter("prefix", prefixLastName+"%");
        List<Person> toReturn = query.getResultList();
        return toReturn;
    }

    @Override
    public List<Person> getAllPersons() throws DAOException {
        Query query = entityManager.createNamedQuery("AllPersons");
        List<Person> toReturn = query.getResultList();
        return toReturn;
    }

    @Override
    public void updateLastName(Person person) throws DAOException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(person);
        tx.commit();
        
    }
}
