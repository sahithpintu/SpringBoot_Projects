package com.javatechie.springboot.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.springboot.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}