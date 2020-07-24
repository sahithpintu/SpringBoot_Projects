package com.ikhiloya.springbootonetomanymapping.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ikhiloya.springbootonetomanymapping.api.entity.Author;
import com.ikhiloya.springbootonetomanymapping.api.entity.Book;
import com.ikhiloya.springbootonetomanymapping.api.exception.ResourceNotFoundException;
import com.ikhiloya.springbootonetomanymapping.api.service.AuthorService;
import com.ikhiloya.springbootonetomanymapping.api.service.BookService;


@RestController
public class AuthorBookController {
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

	 @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Author createAuthor(@RequestBody Author author) {
	        return authorService.createAuthor(author);
	    }
	 
	 @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
	    public Optional<Author> getAuthorById(@PathVariable(value = "authorId") Long authorId) throws ResourceNotFoundException {
	        return authorService.getAuthorById(authorId);
	    }
	 
	 @RequestMapping(value = "/author", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Author updateAuthor(@PathVariable(value = "authorId") Long authorId, @RequestBody Author author) throws ResourceNotFoundException {
	        return authorService.updateAuthorById(authorId, author);
	    }

	    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteAuthorById(@PathVariable(value = "authorId") long authorId) throws ResourceNotFoundException {
	        return authorService.deleteAuthorById(authorId);
	    }
	    
	    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	    public List<Book> getBooks() {
	        return bookService.getAllBooks();
	    }
	    
	    @RequestMapping(value = "/{authorId}/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) throws ResourceNotFoundException {
	        return bookService.createBook(authorId, book);
	    }
	    
	    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
	    public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) throws ResourceNotFoundException {
	        return bookService.getBookById(bookId);
	    }


	    @RequestMapping(value = "/book", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Book updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody Book book) throws ResourceNotFoundException {
	        return bookService.updateBook(bookId, book);
	    }

	    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteBookById(@PathVariable(value = "bookId") long bookId) throws ResourceNotFoundException {
	        return bookService.deleteBookById(bookId);
	    }
}
