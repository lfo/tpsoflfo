package com.ingesup.jee4.tp9.business;

import com.ingesup.jee4.tp9.persistence.Book;
import com.ingesup.jee4.tp9.persistence.DAOException;
import com.ingesup.jee4.tp9.persistence.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lforet
 */
@Local
public interface BookEJBLocal {

    public List<Book> getAllBooks();

    public Book persistBook(Book book);

    public Book updateBook(Book book);
    
    public void removeBook(Book book);

    public List<Book> findBookByTitle(String titlePrefix);

    public Person getOwner(Book book);

    public List<Person> getAuthors(Book book);
}
