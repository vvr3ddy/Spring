package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.dao.ITraineeDao;
import com.cg.entity.Trainee;
import com.cg.exception.IdAlreadyExistsException;
import com.cg.exception.IdNotFoundException;

@Service
public class TraineeServiceImpl implements ITraineeService {

	@Autowired
	ITraineeDao traineeDao;

	@Override
	public List<Trainee> listAllTrainees() {

		return traineeDao.findAll();
	}

	@Override
	public List<Trainee> listTraineesByName(String traineeName) {
		return traineeDao.traineeNameStartsWith(traineeName);
	}

	@Override
	public List<Trainee> listTraineesById() {
		return traineeDao.findAll(Sort.by(Sort.Direction.ASC, "traineeId"));
	}

	@Override
	public void deleteTraineeById(int traineeId) {
		if (traineeDao.existsById(traineeId)) {
			traineeDao.deleteById(traineeId);
		} else {
			throw new IdNotFoundException();
		}

	}

	@Override
	public void updateTrainee(int traineeId, Trainee trainee) {
		if (traineeDao.existsById(traineeId)) {

			traineeDao.save(trainee);
		} else {
			throw new IdNotFoundException();
		}

	}

	@Override
	public void insertTrainee(Trainee trainee) {
		if (!traineeDao.existsById(trainee.getTraineeId())) {
			traineeDao.save(trainee);
		} else {
			throw new IdAlreadyExistsException();
		}

	}

}
