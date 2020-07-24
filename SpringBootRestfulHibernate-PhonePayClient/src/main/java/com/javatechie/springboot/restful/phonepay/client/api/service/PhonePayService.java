package com.javatechie.springboot.restful.phonepay.client.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javatechie.springboot.restful.phonepay.client.api.dto.Payment;
import com.javatechie.springboot.restful.phonepay.client.api.dto.PaymentResponse;
import com.javatechie.springboot.restful.phonepay.client.api.locator.RuleUtil;

@Service
public class PhonePayService {
	@Autowired
	private RuleUtil util;

	public ResponseEntity<PaymentResponse> quickPay(Payment payment) {
		return util.processPayment(payment);
	}

	
	  public ResponseEntity<PaymentResponse> getPaymentsByVendor(String vendor) { return
	  util.getTransaction(vendor); }
	 
}