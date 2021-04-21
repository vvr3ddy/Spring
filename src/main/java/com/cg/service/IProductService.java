package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entities.Product;

@Service
public interface IProductService {
	void addProduct(Product product);
	
	List<Product> showAllProducts();
}
