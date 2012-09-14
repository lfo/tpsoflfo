package fr.devcoop.jee.tp3;

import fr.devcoop.jee.tp3.PersonDAOImpl;
import fr.devcoop.jee.tp3.DAOException;
import java.sql.SQLException;
import org.junit.AfterClass;
import static junit.framework.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExempleTest  {

    @BeforeClass
    public static void initConnection() throws Exception {
        PersonDAOImpl.getInstance().initConnection();
    }

    @AfterClass
    public static void closeConnection() throws DAOException {
        PersonDAOImpl.getInstance().close();
    }

    @Test
    public void test() throws DAOException {
        System.out.println("mon premier test");
        assertTrue(1 == 1);
        System.out.println("passé avec succés");
    }

    @Test(expected = DAOException.class)
    public void testFailure() throws DAOException {
        System.out.println("va lancer une DAOException");
        throw new DAOException();
    }

   
}
