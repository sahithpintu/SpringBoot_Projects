package com.greenlearner.springboot.profiles.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

	@Autowired
	EnvDetails env;
	
	@Bean
	@Profile("dev")
	public EnvDetails devEnv()
	{
		 System.out.println("Dev environment stuff");
	        System.out.println(env);
	        return env;
	}
	
	@Bean
	@Profile("test")
	public EnvDetails testEnv()
	{
		 System.out.println("Test environment stuff");
	        System.out.println(env);
	        return env;
	}
}
