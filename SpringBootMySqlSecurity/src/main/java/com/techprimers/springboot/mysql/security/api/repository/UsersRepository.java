package com.techprimers.springboot.mysql.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.springboot.mysql.security.api.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}