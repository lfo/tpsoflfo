package com.ingesup.jee4.tp9.business.impl;

import com.ingesup.jee4.tp9.business.PersonEJBRemote;
import com.ingesup.jee4.tp9.persistence.DAOException;
import com.ingesup.jee4.tp9.persistence.Person;
import com.ingesup.jee4.tp9.persistence.PersonDAO;
import com.ingesup.jee4.tp9.persistence.impl.PersonDAOJPAImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEJB implements PersonEJBRemote {

    @PersistenceContext(unitName = "4jee-tp9-pu")
    private EntityManager em;
    private PersonDAO personDAO;

    @PostConstruct
    public void initDAO() {
        personDAO = new PersonDAOJPAImpl(em);
    }

    @Override
    public Person create(String firstName, String lastName) {
        try {
            return personDAO.create(firstName, lastName);
        } catch (DAOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        try {
            return personDAO.getAllPersons();
        } catch (DAOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
