package com.javaguides.multipledatasources.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.multipledatasources.api.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}