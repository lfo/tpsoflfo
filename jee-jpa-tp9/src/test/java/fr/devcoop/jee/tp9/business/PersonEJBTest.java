package fr.devcoop.jee.tp9.business;

import fr.devcoop.jee.tp9.business.PersonEJBRemote;
import fr.devcoop.jee.tp9.persistence.Person;

import java.util.List;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class PersonEJBTest extends BusinessTestAbs {

    public final static String JACQUES = "Jacques";
    public final static String SMITH = "Smith";
    
    @Test
    public void testInit() throws NamingException {
        PersonEJBRemote personEJB = (PersonEJBRemote) ctx.lookup("java:global/classes/PersonEJB");
        Assert.assertNotNull(personEJB);
        
        personEJB.create(JACQUES, SMITH);
        List<Person> persons = personEJB.getAllPersons();
        int size = persons.size();
        Assert.assertTrue(size > 0);
                
    }
    
}
