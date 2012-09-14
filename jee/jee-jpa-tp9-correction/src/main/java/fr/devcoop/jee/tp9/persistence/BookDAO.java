package fr.devcoop.jee.tp9.persistence;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface BookDAO {

    public List<Book> getAllBooks();
    
    public Book persistBook(Book book);

    public Book updateBook(Book book);
    
    public void removeBook(Book book);

    public List<Book> findBookByTitle(String titlePrefix);

    public Person getOwner(Book book);

    public List<Person> getAuthors(Book book);
    
}
