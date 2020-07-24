package com.ikhiloya.springbootonetomanymapping.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ikhiloya.springbootonetomanymapping.api.dao.AuthorRepository;
import com.ikhiloya.springbootonetomanymapping.api.dao.BookRepository;
import com.ikhiloya.springbootonetomanymapping.api.entity.Author;
import com.ikhiloya.springbootonetomanymapping.api.entity.Book;
import com.ikhiloya.springbootonetomanymapping.api.exception.ResourceNotFoundException;


@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	@Autowired
	AuthorRepository repository1;
	
	public List<Book> getAllBooks()
	{
		return repository.findAll();
	}

	public Optional<Book> getBookById(long id) throws ResourceNotFoundException
	{
		             if(!repository.existsById(id)) {
		            	 throw new ResourceNotFoundException("Book with id" + id + " not found");
		             }
		            	 return repository.findById(id);
	}
	
	public Book createBook(Long authorId,Book book) throws ResourceNotFoundException {
		
		 Set<Book> books=new HashSet<Book>();
		 Author aut=new Author();
		Optional<Author> author=repository1.findById(authorId);
		 if (!author.isPresent()) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
	        }            
		     Author au=author.get();
		   //tie Author to Book           
		       book.setAuthor(au);
		       
		      Book b= repository.save(book);
		    //tie Book to Author 
		      books.add(b);
		      aut.setBooks(books);
		                  
		                 
		                  
		return b;

    }
	
	public Book updateBook(Long bookId,Book book) throws ResourceNotFoundException
	{
		if (!repository.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
                                 Optional<Book>bk= repository.findById(bookId);
                                 
                                Book b2= bk.get();
                                b2.setGenre(book.getGenre());
                                b2.setTitle(book.getTitle());
                             return   repository.save(b2);
		
		
		
	}
	
	public ResponseEntity<Object> deleteBookById(long bookId) throws ResourceNotFoundException {
        if (!repository.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        repository.deleteById(bookId);

        return ResponseEntity.ok().build();

    }
}
