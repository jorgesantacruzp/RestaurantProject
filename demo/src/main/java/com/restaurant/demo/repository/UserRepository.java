package com.restaurant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
