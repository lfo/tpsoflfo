package com.bissy.distrib.httpserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPServerThread extends Thread {

    private Socket socket = null;

    public HTTPServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {

        try {
            OutputStream out = socket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            socket.setKeepAlive(true);
            HTTPProtocol protocol = new HTTPProtocol();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                try {
                    protocol.process(inputLine, out);
                } catch (IOException ioex) {
                    System.err.println(ioex.getMessage());
                }
                break;
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
