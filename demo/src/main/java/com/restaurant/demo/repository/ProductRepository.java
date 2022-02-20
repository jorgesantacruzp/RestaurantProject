package com.restaurant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
