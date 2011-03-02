package com.ingesup.jee4.tp8;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author lforet
 */
@Entity
@DiscriminatorValue("B")
@NamedQuery(name="allBooks", query="select b from Book b")
public class Book extends Media implements Serializable {

    public Book() {
    }

    public Book(String title) {
        super(title);
    }

    
       
}
