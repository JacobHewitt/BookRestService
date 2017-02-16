/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookrestservice.entitys;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author up709998
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Book.FIND_ALL, query = "SELECT b FROM Book b"),
    @NamedQuery(name = Book.FIND_BY_ID, query = "SELECT b FROM Book b WHERE b.id = :id")
})

public class Book {
    
    public static final String FIND_ALL = "Book.findAll";
    public static final String FIND_BY_ID = "Book.findById";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    private String author;
    
    private String title;
    
    private int numberOfPages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    
    
}
