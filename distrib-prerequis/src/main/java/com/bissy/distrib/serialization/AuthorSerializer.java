package com.bissy.distrib.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AuthorSerializer {

    public File serialize(Author author) throws IOException {
        File file = new File("results/author.ser");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(author);
        oos.flush();
        oos.close();
        return file;
    }

    public Author deserialize(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Author author = (Author)ois.readObject();
        ois.close();
        return author;
    }


    public static void main(String... args) throws Exception {
        Author author = new Author(123L, "William", "Grosso");
        AuthorSerializer serializer = new AuthorSerializer();
        File file = serializer.serialize(author);
        Author readAuthor = serializer.deserialize(file);
        System.out.println(readAuthor.getId());
        System.out.println(readAuthor.getFirstName());
        System.out.println(readAuthor.getLastName());
    }
}
