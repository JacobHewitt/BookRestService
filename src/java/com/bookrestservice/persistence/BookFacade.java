/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookrestservice.persistence;

import com.bookrestservice.entitys.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author up709998
 */
public class BookFacade extends AbstractFacade{

    @PersistenceContext(unitName = "BookRestServicePU")
    private EntityManager em;

    public BookFacade(Class entityClass) {
        super(entityClass);
    }

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Book> getAllBooks(){
        List<Book> toReturn = null;
        toReturn = em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
        return toReturn;
    }
    
    public void createBook(Book book){
        em.persist(book);
    }
    
    public Book getBookById(String id){
        List<Book> toReturn = null;
        toReturn = em.createNamedQuery(Book.FIND_BY_ID, Book.class).setParameter("id", id).getResultList();
        if(!toReturn.isEmpty()){
            return toReturn.get(0);
        }else{
            return null;
        }
    }
    
    public void deleteBook(Book book){
        em.detach(book);
    }
    
}
