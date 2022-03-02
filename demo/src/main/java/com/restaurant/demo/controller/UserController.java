package com.restaurant.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.entity.User;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{id}")
	public Optional<User> findUser(@PathVariable("id") int id){
		
		Optional<User> user = userService.findUserById(id);
		if(!user.isPresent()) {
			throw new ApiRequestException("This ID does not exist");
		}else {
			return user;
		}
	}
	
	@PostMapping()
	public User saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
}
