package com.bissy.distrib.bookstore.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;

public class BookStoreClient implements BookStoreService {

    public static final String HOST_NAME = "localhost";
    public static final int SERVER_PORT = 4444;
    private PrintWriter out;
    private ObjectInputStream in;
    private Socket socket;

    public Collection<Book> findAllBooks() throws Exception {
        return executeQuery("findAllBooks");
    }

    public Collection<Book> findBooks(String title) throws Exception {
        return executeQuery("findBooks#" + title);
    }

    private Collection<Book> executeQuery(String query) throws Exception {
        connect();
        out.println(query);
        Collection<Book> books = (Collection<Book>) in.readObject();
        disconnect();
        return books;
    }

    private void connect() throws Exception {
        try {
            socket = new Socket(HOST_NAME, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("BookStoreClient launched.");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + HOST_NAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: "
                    + HOST_NAME);
            System.exit(1);
        }
    }

    private void disconnect() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
