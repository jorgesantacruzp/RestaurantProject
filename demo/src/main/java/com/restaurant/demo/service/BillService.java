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
		//String id = Integer.toString(idUser);
		//if(id==null) {
		//	return (List<Bill>) billRepository.findAll();
		//}else {
			List<Bill> listOfBills = (List<Bill>) billRepository.listBillsByUser(idUser);
			if(listOfBills.size()==0) {
				throw new ApiRequestException("This user have no bills");
			}else {
				return listOfBills;
			}
		//}
	}
}
