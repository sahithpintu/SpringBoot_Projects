package com.javainuse.springboot.rabbitmq.publisher.service;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.springboot.rabbitmq.publisher.model.Employee;



@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Employee company) {
		rabbitTemplate.convertAndSend(exchange, routingKey, company);
	}
}
