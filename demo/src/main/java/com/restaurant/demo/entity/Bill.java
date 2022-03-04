package com.restaurant.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_bill")
public class Bill {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bill")
	private int id;
	@Column(name="bill_number")
	private String number;
	@Column(name="issue_date")
	private Date issueDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="bill")
	private List<BillDetails> listBillDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BillDetails> getListBillDetails() {
		return listBillDetails;
	}

	public void setListBillDetails(List<BillDetails> listBillDetails) {
		this.listBillDetails = listBillDetails;
	}

}
