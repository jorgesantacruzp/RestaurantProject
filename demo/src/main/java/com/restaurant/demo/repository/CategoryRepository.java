package com.restaurant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
