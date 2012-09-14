package com.bissy.distrib.streams.editor;

import java.io.File;
import java.io.IOException;

public class FileEditor {

    private File file;

    public FileEditor(File file) {
        this.file = file;
    }

    public String getContent() throws IOException {
       throw new UnsupportedOperationException("TODO");
    }

    public void save(String content) throws IOException {
        throw new UnsupportedOperationException("TODO");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
