package com.javatechie.springboot.rediscache.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javatechie.springboot.rediscache.dto.Book;
import com.javatechie.springboot.rediscache.repository.BookRepository;

@Service
public class BookServiceImpl {
	
	private static final Logger logger=LoggerFactory.getLogger(BookServiceImpl.class);
	
	 @Autowired
	    private BookRepository bookRepository;
	 
	 public Book addBook(Book book) {
	        logger.info("adding book with id - {}", book.getId());
	        return bookRepository.save(book);
	    }
	 
	 @CachePut(cacheNames = "books",key = "#book.id")
	 public Book updateBook(Book book) {
	        bookRepository.updateAddress(book.getId(), book.getName());
	        logger.info("book updated with new name");
	        return book;
	    }
	 @Cacheable(cacheNames = "books",key="#id")
	 public Book getBook(long id) {
	        logger.info("fetching book from db");
	        Optional<Book> book = bookRepository.findById(id);
	        if (book.isPresent()) {
	            return book.get();
	        } else {
	            return new Book();
	        }
	    }
	 @CacheEvict(cacheNames = "books", key = "#id")
	 public String deleteBook(long id) {
	        bookRepository.deleteById(id);
	        return "Book deleted";
	    }
}
