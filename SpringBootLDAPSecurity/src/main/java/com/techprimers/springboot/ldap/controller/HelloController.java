package com.techprimers.springboot.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {

	@GetMapping("/secure")
	public String secureMethod() {
		return "secure rest endpoint";
	}

}