package com.ikhiloya.springbootonetomanymapping.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikhiloya.springbootonetomanymapping.api.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>  {

}
