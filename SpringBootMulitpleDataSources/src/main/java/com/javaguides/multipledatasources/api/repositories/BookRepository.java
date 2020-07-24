package com.javaguides.multipledatasources.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.multipledatasources.api.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}