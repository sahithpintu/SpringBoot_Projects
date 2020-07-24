package com.javatechie.springboot.rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatechie.springboot.rediscache.dto.Book;
import com.javatechie.springboot.rediscache.service.BookServiceImpl;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }
}