package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DynamicUpdate
public class Product {

	@Id
	private Long id;

	private String prodname;
	
	private int price;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	@JoinColumn(name="catid")
	@JsonBackReference
	private Category prodcategory;

	public Product() {
		super();
	}

	public Product(Long id, String prodname, int price, Category prodcategory) {
		super();
		this.id = id;
		this.prodname = prodname;
		this.price = price;
		this.prodcategory = prodcategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getProdcategory() {
		return prodcategory;
	}

	public void setProdcategory(Category prodcategory) {
		this.prodcategory = prodcategory;
	}
	
	
}
