package fr.devcoop.jee.tp10.business.impl;

import fr.devcoop.jee.tp10.business.PersonEJBRemote;
import fr.devcoop.jee.tp10.persistence.DAOException;
import fr.devcoop.jee.tp10.persistence.Person;
import fr.devcoop.jee.tp10.persistence.PersonDAO;
import fr.devcoop.jee.tp10.persistence.impl.PersonDAOJPAImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEJB implements PersonEJBRemote {

    @PersistenceContext(unitName = "jee-tp9-pu")
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
