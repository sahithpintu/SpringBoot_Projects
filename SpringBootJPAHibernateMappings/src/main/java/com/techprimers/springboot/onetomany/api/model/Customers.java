package com.techprimers.springboot.onetomany.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;
	@Column(name="customer_name")
	private String customerName;
	
	
	
	public Customers(Integer customerId, String customerName, List<Products> products) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.products = products;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", products=" + products
				+ "]";
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return customerName;
	}
	public void setName(String name) {
		this.customerName = name;
	}
	
	@OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private List<Products> products;

}
