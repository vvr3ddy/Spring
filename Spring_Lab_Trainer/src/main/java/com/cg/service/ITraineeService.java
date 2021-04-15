package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Trainee;

@Service
public interface ITraineeService {
	public List<Trainee> listAllTrainees();
	
	public List<Trainee> listTraineesByName(String traineeName);
	
	public List<Trainee> listTraineesById();
	
	public void deleteTraineeById(int traineeId);
	
	public void updateTrainee(int traineeId, Trainee trainee);
	
	public void insertTrainee(Trainee trainee);
}
