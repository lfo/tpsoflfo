package fr.devcoop.jee.tp9.persistence.impl;

import fr.devcoop.jee.tp9.persistence.DAOException;
import fr.devcoop.jee.tp9.persistence.Person;
import fr.devcoop.jee.tp9.persistence.PersonDAO;
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
    public Person create(String firstName, String lastName) throws DAOException {
        Person person = new Person(firstName, lastName);
        entityManager.persist(person);
        return person;
    }

    @Override
    public void delete(Person person) throws DAOException {
        Person personToDelete = entityManager.getReference(Person.class, person.getId());
        entityManager.remove(personToDelete);       
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
    public Person updatePerson(Person person) throws DAOException {
        entityManager.merge(person);
        return person;        
    }
}
