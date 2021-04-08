package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductDaoI;
import com.cg.entity.Product;


@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductDaoI productDao;

	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {

		return productDao.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		productDao.deleteById(id);
	}
	
	

}
