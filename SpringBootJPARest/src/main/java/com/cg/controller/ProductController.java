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
import com.cg.service.ProductServiceI;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductServiceI productService;

	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>("Added product successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/getById/{pId}")
	public Product getProductById(@PathVariable int pId) {
		return productService.getById(pId);
	}

	
	@DeleteMapping(value="/deleteById/{pId}")
	public String deleteProductById(@PathVariable int pId) {
		productService.deleteById(pId);
		return "Deleted successfully";
	}
}
