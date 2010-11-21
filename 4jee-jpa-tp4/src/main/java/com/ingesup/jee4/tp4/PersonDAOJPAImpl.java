package com.ingesup.jee4.tp4;

import java.util.List;

/**
 *
 * @author lforet
 */
public class PersonDAOJPAImpl implements PersonDAO {

   
    @Override
    public void create(String firstName, String lastName) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Person person) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getAllPersons() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateLastName(Person person) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

   
}
