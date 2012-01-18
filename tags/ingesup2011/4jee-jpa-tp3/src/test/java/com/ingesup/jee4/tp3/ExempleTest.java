package com.ingesup.jee4.tp3;

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
        System.out.println("passé avec succès");
    }

    @Test(expected = DAOException.class)
    public void testFailure() throws DAOException {
        System.out.println("va lancer une DAOException");
        throw new DAOException();
    }

   
}
