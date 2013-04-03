package com.bissy.distrib.streams.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileEditor {

    private File file;

    public FileEditor(File file) {
        this.file = file;
    }

    public String getContent() throws IOException {
        return doGetContentUsingReader();
//    	return doGetContentUsingStream();
    }

    public void save(String content) throws IOException {
//    	doSaveUsingWriter(content);
        doSaveUsingStream(content);
    }

    private String doGetContentUsingReader() throws IOException {
        BufferedReader reader = null;
        String toReturn = "";
        try {
            reader = new BufferedReader(new FileReader(file));

            String l;
            while ((l = reader.readLine()) != null) {
                toReturn += l + "\n";
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return toReturn;
    }

    private String doGetContentUsingStream() throws IOException {
        FileInputStream in = null;
        byte[] buffer = null;
        try {
            in = new FileInputStream(file);
            buffer = new byte[in.available()];
            in.read(buffer);
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return new String(buffer);
    }

    public void doSaveUsingWriter(String content) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file));
            writer.print(content);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public void doSaveUsingStream(String content) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(content.getBytes());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
