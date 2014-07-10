package com.bissy.distrib.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes {

    public static void main(String[] args) throws IOException {
        
        System.out.println("t"+'c');
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("samples/input.txt");
            out = new FileOutputStream("results/output.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}