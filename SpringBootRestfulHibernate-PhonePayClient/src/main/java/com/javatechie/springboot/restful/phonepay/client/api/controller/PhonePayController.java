package com.javatechie.springboot.restful.phonepay.client.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.springboot.restful.phonepay.client.api.dto.Payment;
import com.javatechie.springboot.restful.phonepay.client.api.dto.PaymentResponse;
import com.javatechie.springboot.restful.phonepay.client.api.service.PhonePayService;

@RestController
@RequestMapping("/PhonePe")
public class PhonePayController {
	@Autowired
	private PhonePayService service;
	
	@PostMapping("/payment")
	public ResponseEntity<PaymentResponse> pay(@RequestBody Payment payment){
		return service.quickPay(payment);
	}
	
	  @GetMapping("/findTransactions/{vendor}") 
	  public ResponseEntity<PaymentResponse>  getPayments(@PathVariable String vendor)
	  { 
		  return service.getPaymentsByVendor(vendor);
	  }
	 

}

