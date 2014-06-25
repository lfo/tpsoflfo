package com.bissy.distrib.serialization;

import java.io.File;
import java.io.IOException;

public class BookSerializer {

    public File serialize(Book book) throws IOException {
        throw new UnsupportedOperationException("TODO");
    }

    public Book deserialize(File file) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String... args) throws Exception {
        Author author = new Author(123L, "William", "Grosso");
        Book book = new Book("1-56592-452-5", "Java RMI", "ref-123");
        book.setAuthor(author);
        BookSerializer serializer = new BookSerializer();
        File file = serializer.serialize(book);
        Book readBook = serializer.deserialize(file);
        System.out.println(readBook.getIsbn());
        System.out.println(readBook.getTitle());
        System.out.println(readBook.getAuthor().getFirstName());
        System.out.println(readBook.getAuthor().getLastName());
        System.out.println(readBook.getInternalReference());
    }
}
