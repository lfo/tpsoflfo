package com.bissy.distrib.bookstore;

import java.io.Serializable;

public class Book implements Serializable{

   
	private static final long serialVersionUID = 1L;
	
	private String isbn;
    private Author author;
    private String title;
    private transient String internalReference;

    public Book(String isbn, String title, String internalReference) {
        this.isbn = isbn;
        this.title = title;
        this.internalReference = internalReference;
    }

    public Book(Author author, String isbn, String title, String internalReference) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.internalReference = internalReference;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getInternalReference() {
        return internalReference;
    }

    public void setInternalReference(String internalReference) {
        this.internalReference = internalReference;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
