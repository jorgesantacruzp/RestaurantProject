package com.restaurant.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.Product;
import com.restaurant.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ArrayList<Product> obtenerProductos(){
		return (ArrayList<Product>) productRepository.findAll();
	}

}
