package com.bissy.distrib.httpserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class HTTPProtocol {

    public void process(String command, OutputStream out) throws IOException {
        if (command.startsWith("GET")) {
            StringTokenizer tokenize = new StringTokenizer(command, " ");
            tokenize.nextToken();
            String path = "workingDir" + tokenize.nextToken();
            InputStream contentStream = new FileInputStream(path);
            byte[] content = new byte[contentStream.available()];
            contentStream.read(content);
            out.write(content);
        }

    }
}
