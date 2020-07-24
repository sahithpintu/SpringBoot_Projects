package com.ikhiloya.springbootonetomanymapping.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ikhiloya.springbootonetomanymapping.api.dao.AuthorRepository;
import com.ikhiloya.springbootonetomanymapping.api.entity.Author;
import com.ikhiloya.springbootonetomanymapping.api.exception.ResourceNotFoundException;


@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository repository;
	
	
	public List<Author> getAllAuthors()
	{
		return repository.findAll();
	}

	public Optional<Author> getAuthorById(long id) throws ResourceNotFoundException
	{
		             if(!repository.existsById(id)) {
		            	 throw new ResourceNotFoundException("Author with id" + id + " not found");
		             }
		            	 return repository.findById(id);
	}
	
	 public Author createAuthor(Author author) {
	        return repository.save(author);

	    }
	
	 public Author updateAuthorById(Long authorId, Author authorRequest) throws ResourceNotFoundException {
		 
		 if (!repository.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
		 
		 Optional<Author> author=repository.findById(authorId);
		 
		 Author au=author.get();
		 au.setFirstName(authorRequest.getFirstName());
		 au.setLastName(authorRequest.getLastName());
		// repository.save(au);
		 
		return  repository.save(au); 
	 }
	 
	 public ResponseEntity<Object>  deleteAuthorById(long authorId) throws ResourceNotFoundException
	 {
		 if (!repository.existsById(authorId)) {
	            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
		 repository.deleteById(authorId);
		 
		 return ResponseEntity.ok().build();
	 }
}
