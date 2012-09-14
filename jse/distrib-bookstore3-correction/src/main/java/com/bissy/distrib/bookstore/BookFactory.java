package com.bissy.distrib.bookstore;

import java.util.List;
import java.util.ArrayList;

public class BookFactory {

    public static List<Book> createBooks() {
        List<Book> books = new ArrayList<Book>();
        Author author = new Author("William", "Grosso");
        Book book = new Book(author, "1-56592-452-5", "Java RMI", "ref-1");
        books.add(book);

        author = new Author("Kathy", "Sierra");
        book = new Book(author, "978-0-07-225361-0", "SCJP Study Guide", "ref-2");
        books.add(book);

        author = new Author("A", "Shalloway");
        book = new Book(author, "2-212-11139-8", "Design patterns par la pratique", "ref-3");
        books.add(book);

        author = new Author("Joshua", "Bloch");
        book = new Book(author, "0-201-31005-8", "Effective Java", "ref-4");
        books.add(book);

        return books;
    }
}
