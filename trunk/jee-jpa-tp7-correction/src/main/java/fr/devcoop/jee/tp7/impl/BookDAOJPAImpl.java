package fr.devcoop.jee.tp7.impl;

import fr.devcoop.jee.tp7.Book;
import fr.devcoop.jee.tp7.BookDAO;
import fr.devcoop.jee.tp7.DAOException;
import fr.devcoop.jee.tp7.Person;
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
        Book managedBook = entityManager.find(Book.class , book.getId());   
        return managedBook.getAuthors();
    }

    @Override
    public Person getOwner(Book book) {
        Book managedBook = entityManager.find(Book.class , book.getId());        
        return managedBook.getOwner();
    }

    public List<Book> getOwned(Person person) {
        Person managedPerson = entityManager.find(Person.class , person.getId());  
//        entityManager.refresh(managedPerson);
        return managedPerson.getOwnedBooks();
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
        Book mergedBook = entityManager.merge(book);
        tx.commit();
        return mergedBook;
    }
}
