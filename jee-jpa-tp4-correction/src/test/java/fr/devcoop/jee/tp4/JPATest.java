package fr.devcoop.jee.tp4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author lforet
 */
public class JPATest {

    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee-tp4-pu");
        EntityManager entityManager = emf.createEntityManager();
        Person person = new Person("Pie", "Dupont");
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
