package com.cg.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DynamicUpdate
public class Category {

	@Id
	private Long catid;
	@Column(updatable = false)
	private String catname;

	@OneToMany(mappedBy = "prodcategory", fetch = FetchType.LAZY)
	@JsonManagedReference
	List<Product> products;

	public Category() {
		super();
	}

	public Category(Long id, String catName, List<Product> products) {
		super();
		this.catid = id;
		this.catname = catName;
		this.products = products;
	}

	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
