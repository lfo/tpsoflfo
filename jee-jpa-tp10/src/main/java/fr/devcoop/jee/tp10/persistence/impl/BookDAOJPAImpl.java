package fr.devcoop.jee.tp10.persistence.impl;

import fr.devcoop.jee.tp10.persistence.Book;
import fr.devcoop.jee.tp10.persistence.BookDAO;
import fr.devcoop.jee.tp10.persistence.DAOException;
import fr.devcoop.jee.tp10.persistence.Person;
import java.util.List;
import javax.persistence.EntityManager;
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
    public List<Book> getAllBooks() {
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
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public void removeBook(Book book) {
        Book managedBook = entityManager.find(Book.class , book.getId());     
        entityManager.remove(managedBook);
    }
    
    
}
