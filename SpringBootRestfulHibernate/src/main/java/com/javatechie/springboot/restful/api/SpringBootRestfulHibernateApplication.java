package com.javatechie.springboot.restful.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringBootRestfulHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulHibernateApplication.class, args);
	}

}
