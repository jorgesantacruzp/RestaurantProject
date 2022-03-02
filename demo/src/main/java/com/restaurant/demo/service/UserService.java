package com.restaurant.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.User;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findUserById(int id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new ApiRequestException("This ID does not exist");
		}else {
			return user;
		}
	}
}
