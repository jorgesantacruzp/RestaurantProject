package com.restaurant.demo.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_category")
public class Category {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int id;
	@Column(name="description")
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> listProducts;

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

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
