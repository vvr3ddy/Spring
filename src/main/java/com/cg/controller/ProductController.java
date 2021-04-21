package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Product;
import com.cg.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>("Added Product Successfully", HttpStatus.OK);
	}

	@GetMapping("/listAll")
	public List<Product> displayAll() {
		return productService.showAllProducts();
	}
}
