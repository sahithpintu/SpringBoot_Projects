package com.javainuse.springboot.stream.rabbitmq.controller;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.springboot.stream.rabbitmq.model.Employee;
import com.javainuse.springboot.stream.rabbitmq.source.EmployeeRegistrationSource;

@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {
	@Autowired
	EmployeeRegistrationSource employeeRegistrationSource;
	
	@RequestMapping("/register")
	@ResponseBody
	public String orderFood(@RequestBody Employee employee) {
		
		employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
		System.out.println(employee.toString());
		return "Employee Registered";
	}
}
