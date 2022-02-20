package com.restaurant.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ArrayList<Product> obtenerProductos(){
		return productService.obtenerProductos();
	}

}