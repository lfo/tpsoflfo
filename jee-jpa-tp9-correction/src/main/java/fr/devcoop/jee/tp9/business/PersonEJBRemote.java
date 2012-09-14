package fr.devcoop.jee.tp9.business;

import fr.devcoop.jee.tp9.persistence.Person;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PersonEJBRemote {

    public List<Person> getAllPersons();

    public Person create(String firstName, String lastName);
}
