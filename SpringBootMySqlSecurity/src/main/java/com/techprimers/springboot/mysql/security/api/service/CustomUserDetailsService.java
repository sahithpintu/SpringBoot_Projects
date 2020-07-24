package com.techprimers.springboot.mysql.security.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techprimers.springboot.mysql.security.api.model.CustomUserDetails;
import com.techprimers.springboot.mysql.security.api.model.Users;
import com.techprimers.springboot.mysql.security.api.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
    private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		                    
		Optional<Users> user=usersRepository.findByName(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
		return user.map(CustomUserDetails::new).get();
	}

}
