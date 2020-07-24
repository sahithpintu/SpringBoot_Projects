package com.javatechie.springboot.clouddata.flow.kafka.courierservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringBootCloudDataFlowKafkaCourierServiceApplication {

	Logger logger = LoggerFactory.getLogger(SpringBootCloudDataFlowKafkaCourierServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudDataFlowKafkaCourierServiceApplication.class, args);
		  
           
	}
	
	@StreamListener(Sink.INPUT)
	public void orderDispatched(List<Product> products) {
		
		products.forEach(product->System.out.print(product));
		products.forEach(System.out::println);
		products.forEach( product->{
            logger.info("Order dispatched to your mailing address : " + product);
        });

		
	}
	

}
