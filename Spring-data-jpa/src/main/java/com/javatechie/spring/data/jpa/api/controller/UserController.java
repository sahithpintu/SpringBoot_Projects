package com.javatechie.spring.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.data.jpa.api.model.User;
import com.javatechie.spring.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers()
	{
		return userService.getUsers();
	}
	
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> findByProfession(@PathVariable String profession){
		return userService.findByProfession(profession);
	}
	
	@GetMapping("/getCountByAge/{age}")
	public String getCountByAge(@PathVariable int age){
		long count= userService.getCounts(age);
		 return "total no of records : " + count;
	}
	
	@DeleteMapping("/deleteUser/{name}")
	public List<User> deleteUser(@PathVariable String name){
		return userService.deleteUser(name);
	}
	@GetMapping("/getSort/{field}")
	public List<User> getSortedUsers(@PathVariable String field) {
		return userService.getUserSort(field);
	}

	@GetMapping("/getPaginatedData")
	public Page<User> getPaginatedRecords() {
		return userService.getPaginatedUser();
	}

	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersByCustomQuery() {
		return userService.getUsersCustomQuery();
	}

}
