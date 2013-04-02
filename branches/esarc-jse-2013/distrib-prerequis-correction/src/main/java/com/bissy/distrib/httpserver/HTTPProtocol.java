package com.bissy.distrib.httpserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HTTPProtocol {

    public void process(String command, OutputStream out) throws IOException {
        if (command.startsWith("GET")) {
            StringTokenizer tokenize = new StringTokenizer(command, " ");
            tokenize.nextToken();
            String path = "workingDir" + tokenize.nextToken();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String l;
            PrintWriter writer = new PrintWriter(out, true);
            while ((l = reader.readLine()) != null) {
                writer.println(l);
            }
        }

    }
}
