package com.bissy.distrib.sockets.threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer {

    public static final int LISTENING_PORT = 4444;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(LISTENING_PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+LISTENING_PORT);
            System.exit(-1);
        }
        System.out.println("ThreadedEchoServer launched. Waiting for requests ...");
        while (listening) {
            Socket newSocket = serverSocket.accept();
	    new EchoServerThread(newSocket).start();
        }
        serverSocket.close();
    }

}
