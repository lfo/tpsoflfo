package fr.devcoop.jee.tp6;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface BookDAO {

    public List<Book> getAllBooks() throws DAOException;
    
    public Book persistBook(Book book);

    public Book updateBook(Book book);

    public List<Book> findBookByTitle(String titlePrefix);

    public Person getOwner(Book book);

    public List<Person> getAuthors(Book book);
    
}
