package com.javatechie.springboot.rediscache.service;

import com.javatechie.springboot.rediscache.dto.Book;

public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);
}