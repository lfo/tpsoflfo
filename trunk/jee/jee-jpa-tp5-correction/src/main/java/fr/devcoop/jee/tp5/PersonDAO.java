package fr.devcoop.jee.tp5;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface PersonDAO {

   
    public List<Person> getAllPersons() throws DAOException;

    public List<Person> findAllWithPrefixLastName(String prefixLastName) throws DAOException;

    public Person create(String firstName, String lastName) throws DAOException;

    public Person updatePerson(Person person) throws DAOException;

    public void delete(Person person) throws DAOException;

}
