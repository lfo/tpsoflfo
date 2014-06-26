package com.bissy.distrib.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {
       try (FileReader reader = new FileReader("samples/readerInput.txt"); 
             FileWriter writer = new FileWriter("results/writerOutput.txt"))   {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        }
    }
}
