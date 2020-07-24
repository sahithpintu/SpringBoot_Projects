package com.javatechie.springboot.kafka.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.springboot.kafka.publisher.config.User;

@SpringBootApplication
@RestController
public class SpringBootKafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	private String topic="javatechie";
	
	@GetMapping("/publish/{name}")
	public String  publishMessage(@PathVariable String name)
	{
		kafkaTemplate.send(topic,  "Hi " + name + " Welcome to java techie");
		
		return "Data published";
		
	}
	
	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(2532, "User88", new String[] { "Bangalore", "BTM", "house 90" });
		kafkaTemplate.send(topic, user);
		return "Json Data published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaPublisherApplication.class, args);
	}

}
