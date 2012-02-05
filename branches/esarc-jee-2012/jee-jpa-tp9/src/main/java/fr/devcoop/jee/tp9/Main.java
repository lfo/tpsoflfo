package fr.devcoop.jee.tp9;

import fr.devcoop.jee.tp9.business.PersonEJBRemote;
import fr.devcoop.jee.tp9.persistence.Person;
import java.util.List;
import javax.ejb.EJB;

public class Main {

    @EJB
    private static PersonEJBRemote personEJB;

     public static void main(String... args) {
        personEJB.create("Jacques", "Smith");
        List<Person> persons = personEJB.getAllPersons();
        
        for (Person person : persons) {
            System.out.println(String.format("Personne : %s %s", person.getFirstName(), person.getLastName()));
        }
     }
    
    
}
