package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Long>{
	
}
