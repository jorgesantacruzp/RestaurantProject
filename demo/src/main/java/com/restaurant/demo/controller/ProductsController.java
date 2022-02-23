package com.restaurant.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.entity.Product;
import com.restaurant.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public ArrayList<Product> listProducts(){
		return productService.listProducts();
	}
	
	@GetMapping(path = "/{id}")
	public ArrayList<Product> listProductsByCategory(@PathVariable("id") int id){
		return productService.listProductsByCategory(id);
	}
	
	@PostMapping()
	public Product saveProdcut(@RequestBody Product product) {
		return this.productService.saveProduct(product);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "Se eliminó el usuario con id " + id;
	}

}