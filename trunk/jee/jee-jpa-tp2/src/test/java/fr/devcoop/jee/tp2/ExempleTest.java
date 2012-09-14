package fr.devcoop.jee.tp2;

import static junit.framework.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExempleTest {

    @BeforeClass
    public static void initConnection() {
        // lancer avant la classe de test
    }

    @AfterClass
    public static void closeConnection() {
        // lancer apres la classe de test
    }

    @Test
    public void test() {
        System.out.println("mon premier test");
        assertTrue(1 == 1);
        System.out.println("passé avec succés");
    }

    @Test(expected = Exception.class)
    public void testFailure() throws Exception {
        System.out.println("va lancer une Exception");
        throw new Exception();
    }
}
