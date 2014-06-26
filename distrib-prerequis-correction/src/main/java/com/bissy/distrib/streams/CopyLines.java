package com.bissy.distrib.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {

    public static void main(String[] args) throws IOException {
       try (BufferedReader reader = new BufferedReader(new FileReader("samples/bufferedInput.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("results/bufferedOutput.txt"))){

            String l;
            while ((l = reader.readLine()) != null) {
                writer.println(l);
            }
        }
    }
}
