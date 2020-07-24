package com.javatechie.springboot.restful.phonepay.client.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
	public class PhonePayConfig {
		@Bean
		public RestTemplate getTemplate() {
			RestTemplate template = new RestTemplate();
			return template;
		}

	
}
