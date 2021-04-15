package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exception.IdNotFoundException;
import com.cg.exception.PriceException;
import com.cg.service.ProductServiceI;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductServiceI productService;

	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		try {
			productService.addProduct(product);
			return new ResponseEntity<>("Added product successfully", HttpStatus.OK);
		} catch (PriceException e) {
			throw new PriceException("Invalid Price entered");
		}
	}

	@GetMapping(value = "/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/getById/{pId}")
	public ResponseEntity<Product> getProductById(@PathVariable int pId) {
		try {
			return new ResponseEntity<>(productService.getById(pId), HttpStatus.OK);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException("No product with given Id");
		}
	}

	@DeleteMapping(value = "/deleteById/{pId}")
	public ResponseEntity<Object> deleteProductById(@PathVariable int pId) {
		try {
			return new ResponseEntity<>(productService.deleteById(pId), HttpStatus.OK);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException("No product with given Id");
		}
	}
}
