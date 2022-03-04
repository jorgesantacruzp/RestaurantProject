package com.restaurant.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurant.demo.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	@Query("select b from Bill b where b.user.id=?1")
	List<Bill> listBillsByUser(int id);
	
}
