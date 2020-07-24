package com.javatechie.springboot.kafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootKafkaConsumerApplication {

	List<String> messages = new ArrayList<>();
	
	User userFromTopic = null;
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}

	@GetMapping("/consumeJsonMessage")
	public User consumeJsonMessage() {
		return userFromTopic;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaConsumerApplication.class, args);
	}
	
	@KafkaListener(groupId = "javatechie-1", topics = "javatechie",containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data)
	{
		messages.add(data);
		return messages;
	}
	
	@KafkaListener(groupId = "javatechie-2",topics="javatechie",containerFactory = "userKafkaListenerContainerFactory")
	public User getJsonMsgFromTopic(User user) {
		userFromTopic = user;
		return userFromTopic;
	}

}
