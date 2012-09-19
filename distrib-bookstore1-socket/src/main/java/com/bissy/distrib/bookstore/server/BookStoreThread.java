package com.bissy.distrib.bookstore.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;

import com.bissy.distrib.bookstore.Book;

public class BookStoreThread extends Thread {

    private Socket socket = null;

    public BookStoreThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BookStoreProtocol protocol = new BookStoreProtocol();
            String inputLine;
            if ((inputLine = in.readLine()) != null) {
                Collection<Book> books = protocol.processInput(inputLine);
                out.writeObject(books);
            }
            out.close();
            in.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
