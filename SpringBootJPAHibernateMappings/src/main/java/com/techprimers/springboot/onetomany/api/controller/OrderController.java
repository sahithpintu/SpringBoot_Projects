package com.techprimers.springboot.onetomany.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.springboot.onetomany.api.dao.CustomersRepository;
import com.techprimers.springboot.onetomany.api.dao.ProductsRepository;
import com.techprimers.springboot.onetomany.api.entity.CustomerRequest;
import com.techprimers.springboot.onetomany.api.model.Customers;

@RestController
public class OrderController {
	    @Autowired
	    private CustomersRepository customerRepository;
	    @Autowired
	    private ProductsRepository productRepository;
	    
	@PostMapping("/placeOrder")
	public Customers placeOrder(@RequestBody CustomerRequest request)
	{
		System.out.println("reached controller");
		System.out.println(request);
		return customerRepository.save(request.getCustomers());
	}

	    @GetMapping("/findAllOrders")
	    public List<Customers> findAllOrders(){
	        return customerRepository.findAll();
	    }

}
