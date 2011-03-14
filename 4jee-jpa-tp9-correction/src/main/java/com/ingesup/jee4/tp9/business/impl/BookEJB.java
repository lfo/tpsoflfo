package com.ingesup.jee4.tp9.business.impl;

import com.ingesup.jee4.tp9.business.BookEJBLocal;
import com.ingesup.jee4.tp9.business.BookEJBRemote;
import com.ingesup.jee4.tp9.persistence.Book;
import com.ingesup.jee4.tp9.persistence.BookDAO;
import com.ingesup.jee4.tp9.persistence.Person;
import com.ingesup.jee4.tp9.persistence.impl.BookDAOJPAImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lforet
 */
@Stateless
public class BookEJB implements BookEJBRemote, BookEJBLocal {

    @PersistenceContext(unitName = "4jee-tp9-pu")
    private EntityManager em;
    private BookDAO bookDAO;

    @PostConstruct
    public void initDAO() {
        bookDAO = new BookDAOJPAImpl(em);
    }

    @Override
    public List<Book> findBookByTitle(String titlePrefix) {
        return bookDAO.findBookByTitle(titlePrefix);
    }

    @Override
    public List<Book> getAllBooks()  {
        return bookDAO.getAllBooks();
    }

    @Override
    public List<Person> getAuthors(Book book) {
        return bookDAO.getAuthors(book);
    }

    @Override
    public Person getOwner(Book book) {
        return bookDAO.getOwner(book);
    }

    @Override
    public Book persistBook(Book book) {
        return bookDAO.persistBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public void removeBook(Book book) {
        bookDAO.removeBook(book);
    }
    
}
