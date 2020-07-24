package com.javatechie.springboot.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.springboot.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}