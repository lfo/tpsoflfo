package com.ingesup.jee4.tp9;

import com.ingesup.jee4.tp9.business.PersonEJBRemote;
import com.ingesup.jee4.tp9.persistence.Person;
import java.util.List;
import javax.ejb.EJB;

public class Main {

    @EJB
    private static PersonEJBRemote personEJB;

     public static void main(String... args) {
        personEJB.create("Jacques", "Smith");
        System.out.println("personne crée.");
        List<Person> persons = personEJB.getAllPersons();
        
        for (Person person : persons) {
            System.out.println(String.format("Personne : %s %s", person.getFirstName(), person.getLastName()));
        }
     }
    
    
}
