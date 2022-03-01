package com.restaurant.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.Product;
import com.restaurant.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ArrayList<Product> listProducts(){
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	public ArrayList<Product> listProductsByCategory(String desc){
		return (ArrayList<Product>) productRepository.listProductsByCategory(desc);
	}
	
	public Optional<Product> findProductById(int id){
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(int id){
		productRepository.deleteById(id);
	}
}
