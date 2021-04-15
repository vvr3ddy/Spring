package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Domain;

@Repository
public interface IDomainDao extends JpaRepository<Domain, Integer> {

}
