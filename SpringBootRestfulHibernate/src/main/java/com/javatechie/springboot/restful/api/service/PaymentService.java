package com.javatechie.springboot.restful.api.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.springboot.restful.api.dao.PaymentDao;
import com.javatechie.springboot.restful.api.dto.PaymentResponse;
import com.javatechie.springboot.restful.api.model.Payment;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentDao dao;
	
	public PaymentResponse pay(Payment payment) {
		PaymentResponse p=new PaymentResponse();
		payment.setPaymentDate(new Date());
		 String message= dao.payNow(payment);
		 p.setMessage(message);
		 p.setTxDate(new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a").format(new Date()));
		 return p;	                        
	}
	
	public PaymentResponse getTx(String vendor)
	{
		PaymentResponse response = new PaymentResponse();
		List<Payment> payments = dao.getTransactionInfo(vendor);
		response.setStatus("succes");
		response.setPayments(payments);
		return response;
	}

}
