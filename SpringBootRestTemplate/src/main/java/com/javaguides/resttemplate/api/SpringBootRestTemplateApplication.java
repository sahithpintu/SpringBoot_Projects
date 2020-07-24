package com.javaguides.resttemplate.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestTemplateApplication {
	
	private static RestTemplate restTemplate =new RestTemplate();
	 private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8888/api/v1/getAllEmployees/page/{pageNo}/sort/{firstName}";
	    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8888/api/v1/getEmployee/{id}";
	    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8888/api/v1/employees";
	    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8888/api/v1/updateEmployee/{id}";
	    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8888/api/v1/employees/{id}";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestTemplateApplication.class, args);
		
		createEmployee();
		getEmployeeById();
		getEmployees();
		updateEmployee();
		deleteEmployee();
		
	}

	private static void deleteEmployee() {
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(headers); 
		ResponseEntity<Map<String,Object>> responseEntity =restTemplate.exchange(DELETE_EMPLOYEE_ENDPOINT_URL, HttpMethod.DELETE, entity, new ParameterizedTypeReference<Map<String,Object>>(){},9);
		HttpStatus statusCode = responseEntity.getStatusCode();
		  System.out.println("status code - " + statusCode);
		  Map<String,Object> empDetails=responseEntity.getBody();
		 System.out.println("response body - "+empDetails);
		 HttpHeaders  responseHeaders = responseEntity.getHeaders();
		  System.out.println("response Headers - " + responseHeaders);
		
		
	}

	
	  private static void updateEmployee() 
	  { 
		  
	  HttpHeaders headers=new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON); 
	  Employee updatedEmployee= new Employee("admin123", "admin123", "admin123@gmail.com");
	  HttpEntity<Object> entity = new HttpEntity<>(updatedEmployee,headers);
	  Map<String,String> params = new HashMap <String, String>(); 
	  params.put("id", "9");
	  ResponseEntity<Employee> responseEntity=restTemplate.exchange(UPDATE_EMPLOYEE_ENDPOINT_URL,HttpMethod.PUT,entity,Employee.class,params);
	  HttpStatus statusCode = responseEntity.getStatusCode();
	  System.out.println("status code - " +statusCode);
	  Employee empDetails =responseEntity.getBody();
	  System.out.println("response body - " +empDetails);
	  HttpHeaders responseHeaders = responseEntity.getHeaders();
	  System.out.println("response Headers - " + responseHeaders);
	  }
	 

	
	  private static void getEmployees()
	  { 
		  
	  HttpHeaders headers=new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity<Object> entity= new HttpEntity<>(headers);
	  ResponseEntity<List<Employee>> responseEntity =restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>(){},3,"firstName"); 
	  HttpStatus statusCode = responseEntity.getStatusCode();
	  System.out.println("status code - " + statusCode);
	  List<Employee> empDetails=responseEntity.getBody();
	  System.out.println("response body - "+empDetails); HttpHeaders
	  responseHeaders = responseEntity.getHeaders();
	  System.out.println("response Headers - " + responseHeaders);
	  
	  }
	 

	
	
	  private static void getEmployeeById() 
	  { 
		  
	  HttpHeaders headers=new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity<Object> entity  = new HttpEntity<>(headers);
	  ResponseEntity<Employee> responseEntity = restTemplate.exchange(GET_EMPLOYEE_ENDPOINT_URL, HttpMethod.GET, entity,Employee.class, 11);
	  HttpStatus statusCode = responseEntity.getStatusCode();
	  System.out.println("status code - " + statusCode); 
	  Employee empDetails =responseEntity.getBody(); 
	  System.out.println("response body - " +empDetails);
	  HttpHeaders responseHeaders = responseEntity.getHeaders();
	  System.out.println("response Headers - " + responseHeaders);
	  
	  }
	 
	 

	
	  private static void createEmployee() { 
	  HttpHeaders headers=new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  Employee e=new Employee("admin","pass","admin@gmail.com"); HttpEntity<Employee>
	  requestEntity = new HttpEntity<>(e,headers); 
	  ResponseEntity<Employee> responseEntity=restTemplate.exchange(CREATE_EMPLOYEE_ENDPOINT_URL, HttpMethod.POST, requestEntity, Employee.class);
	  HttpStatus statusCode = responseEntity.getStatusCode();
	  System.out.println("status code - " + statusCode);
	  Employee empDetails = responseEntity.getBody(); 
	  System.out.println("response body - " + empDetails); 
	  HttpHeaders responseHeaders = responseEntity.getHeaders();
	  System.out.println("response Headers - " + responseHeaders);
	  }
	 

	

	

}
