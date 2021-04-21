package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Long>{

}
