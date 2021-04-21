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

import com.cg.entities.Category;
import com.cg.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCategory(@RequestBody Category category){
		categoryService.addCategory(category);
		return new ResponseEntity<>("Added Category", HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	public List<Category> showAll(){
		return categoryService.showAllCategories();
	}
}
