package net.javaguides.springrestcrud.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.javaguides.springrestcrud.api.dao.EmployeeRepository;
import net.javaguides.springrestcrud.api.exception.ResourceNotFoundException;
import net.javaguides.springrestcrud.api.model.Employee;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	private static final int PAGE_SIZE = 3;
	
	@ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/getAllEmployees/page/{pageNo}/sort/{firstName}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable Integer pageNo,@PathVariable String firstName)
	{
		          Pageable page=PageRequest.of(pageNo, PAGE_SIZE, Sort.by(firstName));
		          Page<Employee> p=repository.findAll(page);
		                     List<Employee> em= p.getContent();
		return ResponseEntity.ok().body(em);
		
	}
	
	 @ApiOperation(value = "Get an employee by Id")
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException
	{
		                     Employee e= repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
		
	}
	
	 @ApiOperation(value = "Add an employee")
	 @PostMapping("/employees")
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	        Employee e= repository.save(employee);
	        return new ResponseEntity<Employee>(e, HttpStatus.ACCEPTED);
	    }
	 
	 @PutMapping("/updateEmployee/{id}")
	 public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Integer employeeId,
		        @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException
	 {
		 Employee e= repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		             e.setEmailId(employeeDetails.getEmailId());
		             e.setFirstName(employeeDetails.getFirstName());
		             e.setLastName(employeeDetails.getLastName());
		           Employee emp=repository.save(e);
		           return ResponseEntity.ok(emp);
	 }
	 
	 @DeleteMapping("/employees/{id}")
	    public ResponseEntity<Map < String, Boolean >> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
	    throws ResourceNotFoundException {
	        Employee employee = repository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	                repository.delete(employee);
	        Map<String,Boolean> reponse =new HashMap<String,Boolean>();
	        reponse.put("deleted",Boolean.TRUE);
	        
	        return new ResponseEntity<Map<String,Boolean>>(reponse,HttpStatus.OK);
}
}
