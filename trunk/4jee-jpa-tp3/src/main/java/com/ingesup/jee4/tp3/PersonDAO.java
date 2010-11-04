package com.ingesup.jee4.tp3;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lforet
 */
public interface PersonDAO {

    /**
     * 
     * 
     * @return
     * @throws DAOException
     */
    public List<Person> getAllPersons() throws DAOException;

    public List<Person> findAllWithPrefixLastName(String prefixLastName)  throws DAOException;
    
    public void create(String firstName, String lastName) throws DAOException;
    
    public void updateLastName(Person person) throws DAOException;
    
    public void delete(Person person) throws DAOException;
    
    public void close() throws DAOException;
}
