/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookrestservice.service;

import com.bookrestservice.entitys.Book;
import com.bookrestservice.model.BookEJB;
import com.bookrestservice.model.Books;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



/**
 *
 * @author up709998
 */
@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService {
    
    @Inject
    private BookEJB bookEJB;
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    public Response getBooks(){
        
        return Response.ok(bookEJB.getAllBooks()).build();
    }
    
    @POST
    public Response createBook(Book book){
        if(book == null) throw new BadRequestException();
            
            bookEJB.createBook(book);
            URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId()).build();
            return Response.created(bookUri).build();
        
    }
    
    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id){
        Book book = bookEJB.getBookById(id);
        if(book == null) throw new NotFoundException();
        
        return Response.ok(book).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") String id){
        Book book = bookEJB.getBookById(id);
        if(book == null){
            throw new NotFoundException();
        }else{
            bookEJB.deleteBook(book);
        } 
        return Response.noContent().build();
    }
    
    
    
    
}
