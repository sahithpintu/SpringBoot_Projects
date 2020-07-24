package com.javatechie.spring.data.jpa.api.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.spring.data.jpa.api.model.User;

import javafx.scene.control.Pagination;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	public List<User> findByProfession(String profession);
	
	public long  countByAge(int age);

	public List<User> deleteByName(String name);


	@Query("select u from User u")
	public List<User> getUsersCustomQuery();
	
	

}
