package com.restaurant.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.entity.Product;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ArrayList<Product> listProducts(){
		return productService.listProducts();
	}
	
	@GetMapping(path = "/category")
	public List<Product> listProductsByCategory(@RequestParam String desc){
		
		List<Product> listOfProducts = productService.listProductsByCategory(desc);
		if(listOfProducts == null || listOfProducts.size()==0) {
			throw new ApiRequestException("There are no products with this category");
		}else {
			return listOfProducts;
		}
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Product> findProduct(@PathVariable("id") int id){
		
		Optional<Product> product = productService.findProductById(id);
		if(!product.isPresent()) {
			throw new ApiRequestException("This ID does not exist");
		}else {
			return product;
		}
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