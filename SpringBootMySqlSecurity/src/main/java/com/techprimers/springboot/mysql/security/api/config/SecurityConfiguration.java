package com.techprimers.springboot.mysql.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.techprimers.springboot.mysql.security.api.repository.UsersRepository;
import com.techprimers.springboot.mysql.security.api.service.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private CustomUserDetailsService userDetailsService;
	
	protected  void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
		
	}
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("**/secured/**").authenticated()
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().permitAll();
	    }
	

	private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
}
	
	
}
