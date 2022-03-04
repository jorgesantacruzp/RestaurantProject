package com.restaurant.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.demo.entity.Bill;
import com.restaurant.demo.exception.ApiRequestException;
import com.restaurant.demo.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	public List<Bill> listBills(){
		return (List<Bill>) billRepository.findAll();
	}
	
	public Optional<Bill> findBillById(int id){
		Optional<Bill> bill = billRepository.findById(id);
		if(!bill.isPresent()) {
			throw new ApiRequestException("This ID does not exist");
		}else {
			return bill;
		}
	}
	
	public List<Bill> listBillsByUser(int idUser){
		List<Bill> listOfBills = (List<Bill>) billRepository.listBillsByUser(idUser);
		if(listOfBills.size()==0) {
			throw new ApiRequestException("This user has no bills");
		}else {
			return listOfBills;
		}
	}
	
	public Optional<Bill> findBillByUser(int idUser,int idBill){
		Optional<Bill> bill = billRepository.findBillByUser(idUser,idBill);
		if(!bill.isPresent()) {
			throw new ApiRequestException("The ID of this bill does not belong to this user");
		}else {
			return bill;
		}
	}
}
