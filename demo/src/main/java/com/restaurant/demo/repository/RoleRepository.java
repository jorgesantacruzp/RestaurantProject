package com.restaurant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
