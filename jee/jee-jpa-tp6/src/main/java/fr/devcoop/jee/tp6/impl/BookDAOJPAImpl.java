package fr.devcoop.jee.tp6.impl;

import fr.devcoop.jee.tp6.Book;
import fr.devcoop.jee.tp6.BookDAO;
import fr.devcoop.jee.tp6.DAOException;
import fr.devcoop.jee.tp6.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author lforet
 */
public class BookDAOJPAImpl implements BookDAO {

    private EntityManager entityManager;

    public BookDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> getAllBooks() throws DAOException {
        Query query = entityManager.createNamedQuery("allBooks");
        List<Book> toReturn = query.getResultList();
        return toReturn;
    }

    @Override
    public List<Book> findBookByTitle(String titlePrefix) {
        Query query = entityManager.createQuery("select b from Book b where b.title like :title");
        query.setParameter("title", titlePrefix + "%");
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    public List<Person> getAuthors(Book book) {
        Query query = entityManager.createQuery("select p from Person p where p.writtenBooks = :book");
        query.setParameter("book", book);
        List<Person> persons = query.getResultList();
        return persons;
//        return book.getAuthors();
    }

    @Override
    public Person getOwner(Book book) {
        Query query = entityManager.createQuery("select p from Person p where p.owned = :book");
        query.setParameter("book", book);
        List<Person> persons = query.getResultList();
        return persons.iterator().next();
//        return book.getOwner();
    }

    public List<Book> getOwned(Person person) {
        Query query = entityManager.createQuery("select b from Book b where b.owner = :person");
        query.setParameter("person", person);
        List<Book> books = query.getResultList();
        return books;
//        return p.getOwnedBooks();
    }

    @Override
    public Book persistBook(Book book) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        return book;
    }
}
