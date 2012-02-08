package fr.devcoop.jee.tp9.business;

import fr.devcoop.jee.tp9.persistence.Book;
import fr.devcoop.jee.tp9.persistence.DAOException;
import fr.devcoop.jee.tp9.persistence.Person;
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
