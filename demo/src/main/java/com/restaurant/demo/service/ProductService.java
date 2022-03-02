package com.restaurant.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.Product;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listProducts(String category){
		if(category == null) {
			return (List<Product>) productRepository.findAll();
		}else {
			List<Product> listOfProducts = (List<Product>) productRepository.listProductsByCategory(category);
			if(listOfProducts == null || listOfProducts.size()==0) {
				throw new ApiRequestException("There are no products with this category");
			}else {
				return listOfProducts;
			}
		}
	}
	
	public Optional<Product> findProductById(int id){
		Optional<Product> product = productRepository.findById(id);
		if(!product.isPresent()) {
			throw new ApiRequestException("This ID does not exist");
		}else {
			return product;
		}
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(int id){
		productRepository.deleteById(id);
	}
}
