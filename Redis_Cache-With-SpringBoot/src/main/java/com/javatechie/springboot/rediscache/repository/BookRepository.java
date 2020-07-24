package com.javatechie.springboot.rediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.springboot.rediscache.dto.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Transactional
    @Modifying
    @Query("update Book u set u.name=?2 where u.id=?1")
    int updateAddress(long id, String name);
	}

