package com.javatechie.springboot.restful.api.dao;

import java.util.List;

import com.javatechie.springboot.restful.api.model.Payment;

public interface PaymentDao {

    public String payNow(Payment payment);
	
	public List<Payment> getTransactionInfo(String vendor);
}
