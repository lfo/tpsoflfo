package com.ingesup.jee4.tp5.impl;

import com.ingesup.jee4.tp5.Book;
import com.ingesup.jee4.tp5.BookDAO;
import com.ingesup.jee4.tp5.DAOException;
import com.ingesup.jee4.tp5.Person;
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
        return book.getAuthors();
    }

    @Override
    public Person getOwner(Book book) {
        Query query = entityManager.createQuery("select p from Person p INNER JOIN person.owned b where b.id = ");
        query.setParameter("bookId", book.getId());
        List<Person> persons = query.getResultList();
        return persons.iterator().next();
//        return book.getOwner();
    }

    public List<Book> getOwned(Person p) {
        Query query = entityManager.createQuery("select b from Book b INNER JOIN b.owner p where p.id = :personId");
        query.setParameter("personId", p.getId());
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
