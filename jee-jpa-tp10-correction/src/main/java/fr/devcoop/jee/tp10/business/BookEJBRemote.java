package fr.devcoop.jee.tp10.business;

import fr.devcoop.jee.tp10.persistence.Book;
import fr.devcoop.jee.tp10.persistence.DAOException;
import fr.devcoop.jee.tp10.persistence.Person;
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
