package com.restaurant.demo.entity;

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
@Table(name="tb_product")
public class Product {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prod")
	private int id;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private double price;
	@Column(name="stock")
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="id_cat")
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<BillDetails> listTicketDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<BillDetails> getListTicketDetails() {
		return listTicketDetails;
	}

	public void setListTicketDetails(List<BillDetails> listTicketDetails) {
		this.listTicketDetails = listTicketDetails;
	}
		
}
