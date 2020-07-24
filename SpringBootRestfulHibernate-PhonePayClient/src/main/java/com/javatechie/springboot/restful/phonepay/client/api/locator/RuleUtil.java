package com.javatechie.springboot.restful.phonepay.client.api.locator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.springboot.restful.phonepay.client.api.dto.Payment;
import com.javatechie.springboot.restful.phonepay.client.api.dto.PaymentResponse;

@PropertySource(value = "classpath:application.properties")
@Component
public class RuleUtil {
	@Autowired
	private RestTemplate template;
	@Autowired
	private Environment env;

	
	public ResponseEntity<PaymentResponse> processPayment(Payment payment) {
		
		String URL = "";
		
		
			URL = env.getProperty("payment.url");
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Payment> entity=new HttpEntity<>(payment,headers);
			ResponseEntity<PaymentResponse> p=template.exchange(URL, HttpMethod.POST, entity, PaymentResponse.class);

		return p;

	}
	
	public ResponseEntity<PaymentResponse> getTransaction(String vendor) {
		
		String URL = "";
	
			URL = env.getProperty("transaction.url");
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> entity=new HttpEntity<>(headers);
			Map<String,String> m=new HashMap<String,String>();
			m.put("vendor", "PhonePay");
			
			ResponseEntity<PaymentResponse> p=template.exchange(URL, HttpMethod.GET, entity, PaymentResponse.class,m);


		return p;

	}
}
