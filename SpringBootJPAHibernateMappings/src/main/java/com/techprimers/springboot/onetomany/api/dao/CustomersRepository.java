package com.techprimers.springboot.onetomany.api.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.springboot.onetomany.api.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers,Integer>{

}
