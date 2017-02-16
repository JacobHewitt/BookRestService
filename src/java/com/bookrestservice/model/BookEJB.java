/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookrestservice.model;

import com.bookrestservice.entitys.Book;
import com.bookrestservice.persistence.BookFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author up709998
 */
@Stateless
public class BookEJB {
    
    @Inject
    private BookFacade bookFacade;
    
    public List<Book> getAllBooks(){
        return bookFacade.getAllBooks();
    }
    
    public Book getBookById(long id){
        return bookFacade.getBookById(id);
    }
    
    public void createBook(Book book){
        bookFacade.createBook(book);
    }
    
    
}
