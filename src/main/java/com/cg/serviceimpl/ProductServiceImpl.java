package com.cg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IProductDao;
import com.cg.entities.Product;
import com.cg.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductDao productDao;
	
	@Override
	public void addProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> showAllProducts() {
		return productDao.findAll();
	}

}
