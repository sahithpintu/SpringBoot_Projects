package com.techprimers.springboot.onetomany.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.springboot.onetomany.api.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer>{

}
