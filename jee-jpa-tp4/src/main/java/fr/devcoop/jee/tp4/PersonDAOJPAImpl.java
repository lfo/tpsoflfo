package fr.devcoop.jee.tp4;

import java.util.List;
import javax.persistence.EntityManager;

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
       throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void delete(Person person) throws DAOException {
       throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
       throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<Person> getAllPersons() throws DAOException {
       throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void updateLastName(Person person) throws DAOException {
        throw new UnsupportedOperationException("TODO");
        
    }
}
