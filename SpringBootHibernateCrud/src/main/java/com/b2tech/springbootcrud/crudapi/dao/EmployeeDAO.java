package com.b2tech.springbootcrud.crudapi.dao;

import java.util.List;

import com.b2tech.springbootcrud.crudapi.model.Employee;

public interface EmployeeDAO {

	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id); 

}
