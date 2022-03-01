package com.restaurant.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurant.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.category.description=?1")
	List<Product> listProductsByCategory(String name);
}
