/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookrestservice.model;

import com.bookrestservice.entitys.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author up709998
 */
@XmlRootElement
@XmlSeeAlso(Book.class)
public class Books extends ArrayList<Book>{
    
    public Books(){
        super();
    }
    
    public Books(Collection<? extends Book> in){
        super(in);
    }
    
    @XmlElement(name = "book")
    public List<Book> getBooks(){
        return this;
    }
    
    public void setBooks(List<Book> books){
        this.addAll(books);
    }
    
    
}
