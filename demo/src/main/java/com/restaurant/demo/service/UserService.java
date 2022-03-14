package com.restaurant.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.User;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	
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
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(
												String.format(USER_NOT_FOUND_MSG, email)));
	}
	
	public User signUpUser(User user) {
		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
		
		if(userExists) {
			throw new IllegalStateException("email already taken");	
		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
}
