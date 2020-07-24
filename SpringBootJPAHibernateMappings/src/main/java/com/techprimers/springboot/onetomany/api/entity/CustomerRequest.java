package com.techprimers.springboot.onetomany.api.entity;

import com.techprimers.springboot.onetomany.api.model.Customers;

public class CustomerRequest {
	
	private Customers customers;

	
	public CustomerRequest(Customers customers) {
		super();
		this.customers = customers;
	}

	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerRequest [customers=" + customers + "]";
	}

	

}
