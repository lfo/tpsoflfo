package com.bissy.distrib.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BookSerializer {

    public File serialize(Book book) throws IOException {
    	 File file = new File("results/book.ser");
         FileOutputStream fos = new FileOutputStream(file);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(book);
         oos.flush();
         oos.close();
         return file;
    }

    public Book deserialize(File file) throws IOException, ClassNotFoundException {
    	FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Book book = (Book)ois.readObject();
        ois.close();
        return book;
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
