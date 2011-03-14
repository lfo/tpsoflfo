package com.ingesup.jee4.tp9.business;

import com.ingesup.jee4.tp9.persistence.Book;
import com.ingesup.jee4.tp9.persistence.DAOException;
import com.ingesup.jee4.tp9.persistence.Person;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author lforet
 */
@Remote
public interface BookEJBRemote {

    public List<Book> getAllBooks();

    public List<Book> findBookByTitle(String titlePrefix);

    public Person getOwner(Book book);

    public List<Person> getAuthors(Book book);
}
