package com.restaurant.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.entity.Bill;
import com.restaurant.demo.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping()
	public List<Bill> listBills(){
		return billService.listBills();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Bill> findBill(@PathVariable("id") int id){
		return billService.findBillById(id);
	}

}
