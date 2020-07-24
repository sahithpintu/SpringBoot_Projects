package com.b2tech.springbootcrud.crudapi.service;

import java.util.List;

import com.b2tech.springbootcrud.crudapi.model.Employee;

public interface EmployeeService {

    List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
