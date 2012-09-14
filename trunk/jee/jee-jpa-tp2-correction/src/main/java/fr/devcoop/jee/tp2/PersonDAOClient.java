package fr.devcoop.jee.tp2;

import java.util.List;


/**
 *
 * @author lfo
 */
public class PersonDAOClient {

    public static PersonDAO getPersonDAO() throws DAOException {
        return new PersonDAOImpl();
    }

    public static void main(String ... args) throws DAOException {
        PersonDAO personDAO = getPersonDAO();
        personDAO.create("Pierre", "Dupont");
        personDAO.create("Paul", "Durand");
        personDAO.create("Jacques", "Smith");
        List<Person> persons = personDAO.getAllPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        personDAO.close();
        
        persons = personDAO.findAllWithPrefixLastName("Du");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        
        persons = personDAO.getAllPersons();
        for (Person person : persons) {
            if (person.getFirstName().equals("Jacques") && person.getLastName().equals("Smith")) {
                person.setLastName("Dupont");
                personDAO.updateLastName(person);
            }
            if (person.getFirstName().equals("Paul") && person.getLastName().equals("Durand")) {
                personDAO.delete(person);
            }
        }

        persons = personDAO.findAllWithPrefixLastName("Du");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        personDAO.close();
    }

}
