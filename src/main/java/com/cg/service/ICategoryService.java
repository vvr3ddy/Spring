package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entities.Category;

@Service
public interface ICategoryService {
	void addCategory(Category category);
	
	List<Category> showAllCategories();
}
