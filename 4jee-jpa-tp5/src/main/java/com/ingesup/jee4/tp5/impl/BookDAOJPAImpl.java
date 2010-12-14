package com.ingesup.jee4.tp5.impl;

import com.ingesup.jee4.tp5.Book;
import com.ingesup.jee4.tp5.BookDAO;
import com.ingesup.jee4.tp5.Person;
import java.util.List;

/**
 *
 * @author lfo
 */
public class BookDAOJPAImpl implements BookDAO {

    @Override
    public List<Book> findBookByTitle(String titlePrefix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> getAuthors(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Person getOwner(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Book persistBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Book updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
