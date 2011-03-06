package com.ingesup.jee4.tp9.business;

import com.ingesup.jee4.tp9.persistence.Person;
import com.ingesup.jee4.tp9.persistence.PersonDAOTest;
import java.util.List;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class PersonEJBTest extends BusinessTestAbs {

    @Test
    public void testInit() throws NamingException {
        PersonEJBRemote personEJB = (PersonEJBRemote) ctx.lookup("java:global/classes/PersonEJB");
        Assert.assertNotNull(personEJB);
        
        personEJB.create(PersonDAOTest.JACQUES, PersonDAOTest.SMITH);
        List<Person> persons = personEJB.getAllPersons();
        Assert.assertEquals(1, persons.size());
    }
    
}
