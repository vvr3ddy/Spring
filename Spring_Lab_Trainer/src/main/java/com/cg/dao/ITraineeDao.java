package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Trainee;

@Repository
public interface ITraineeDao extends JpaRepository<Trainee, Integer> {
	public List<Trainee> traineeNameStartsWith(String traineeName); 
}
