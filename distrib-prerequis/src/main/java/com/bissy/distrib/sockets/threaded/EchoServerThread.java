package com.bissy.distrib.sockets.threaded;

import com.bissy.distrib.sockets.EchoProtocol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerThread extends Thread {

    private Socket socket = null;

    public EchoServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine, outputLine;
            EchoProtocol echoProtocol = new EchoProtocol();

            while ((inputLine = in.readLine()) != null) {
                outputLine = echoProtocol.processInput(inputLine);
                out.println(outputLine);
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
