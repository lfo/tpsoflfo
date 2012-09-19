package com.bissy.distrib.bookstore.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BookStoreServerMain {

    public static final int LISTENING_PORT = 4444;

    public static void main(String... args) throws Exception {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(LISTENING_PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + LISTENING_PORT);
            System.exit(-1);
        }
        System.out.println("BookStoreServer launched. Waiting for requests ...");
        while (listening) {
            Socket newSocket = serverSocket.accept();
            new BookStoreThread(newSocket).start();
        }
        serverSocket.close();
    }
}
