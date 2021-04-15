package com.cg.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductDaoI;
import com.cg.entity.Product;
import com.cg.exception.IdNotFoundException;
import com.cg.exception.PriceException;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductDaoI productDao;

	@Override
	public Product addProduct(Product product) {
		if(product.getPrice()<=0) {
			throw new PriceException();
		}
		return productDao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {
		if (productDao.existsById(id))
			return productDao.findById(id).get();
		else
			throw new IdNotFoundException();
	}

	@Override
	public String deleteById(int id) {
		if (productDao.existsById(id)) {
			productDao.deleteById(id);
			return "Deleted product successfully";
		} else
			throw new IdNotFoundException();
	}

}
