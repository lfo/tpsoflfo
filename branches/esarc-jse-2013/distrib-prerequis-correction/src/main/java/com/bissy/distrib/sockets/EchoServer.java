package com.bissy.distrib.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static final int LISTENING_PORT = 4444;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(LISTENING_PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+LISTENING_PORT);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        EchoProtocol echoProtocol = new EchoProtocol();
        System.out.println("EchoServer launched. Waiting for requests ...");
        while ((inputLine = in.readLine()) != null) {
            outputLine = echoProtocol.processInput(inputLine);
            out.println(outputLine);            
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
