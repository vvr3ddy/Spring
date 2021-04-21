package com.cg.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ICategoryDao;
import com.cg.entities.Category;
import com.cg.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;

	@Override
	public void addCategory(Category category) {
		categoryDao.save(category);

	}

	@Override
	public List<Category> showAllCategories() {
		return categoryDao.findAll();
	}

}
