package com.ingesup.jee4.tp5;

import java.util.List;

/**
 *
 * @author lforet
 */
public interface BookDAO {

    public Book persistBook(Book book);

    public Book updateBook(Book book);

    public List<Book> findBookByTitle(String titlePrefix);

    public Person getOwner(Book book);

    public List<Person> getAuthors(Book book);
}
