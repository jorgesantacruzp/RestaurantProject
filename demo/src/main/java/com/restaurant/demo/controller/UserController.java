package com.restaurant.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.entity.Bill;
import com.restaurant.demo.entity.User;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.service.BillService;
import com.restaurant.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BillService billService;
	
	@GetMapping(path = "/{id}")
	public Optional<User> findUser(@PathVariable("id") int id){
		return userService.findUserById(id);
	}
	
	@GetMapping("/{id}/bills")
	public List<Bill> listBillsByUser(@PathVariable("id") int id){
		return billService.listBillsByUser(id);
	}
	
	@GetMapping("/{idUser}/bills/{idBill}")
	public Optional<Bill> findBillByUser(@PathVariable("idUser") int idUser, @PathVariable("idBill") int idBill){
		return billService.findBillByUser(idUser,idBill);
	}
	
	@PostMapping("/registration")
	public User saveUser(@RequestBody User user) {
		return this.userService.signUpUser(user);
	}
}
