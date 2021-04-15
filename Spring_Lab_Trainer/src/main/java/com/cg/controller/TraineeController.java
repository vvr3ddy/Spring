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

import com.cg.entity.Trainee;
import com.cg.exception.IdAlreadyExistsException;
import com.cg.exception.IdNotFoundException;
import com.cg.service.ITraineeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Trainee Controller")
@RestController
@RequestMapping("/trainee")
public class TraineeController {

	@Autowired
	ITraineeService traineeService;

	@ApiOperation(value = "Get all trainees")
	@GetMapping("/getAll")
	public List<Trainee> listAllTrainees() {
		return traineeService.listAllTrainees();
	}

	@ApiOperation(value = "Get All Trainees by Name")
	@GetMapping("/getAllByName/{traineeName}")
	public List<Trainee> listTraineesByName(@PathVariable String traineeName) {
		return traineeService.listTraineesByName(traineeName);
	}

	@GetMapping("/getAllById")
	public List<Trainee> listTraineesById() {
		return traineeService.listTraineesById();
	}

	@DeleteMapping(value = "/deleteById/{traineeId}")
	public ResponseEntity<Object> deleteTraineeById(@PathVariable int traineeId) {
		try {
			traineeService.deleteTraineeById(traineeId);
			return new ResponseEntity<>("Deleted trainee Successfully.", HttpStatus.OK);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException("Cannot find trainee with given id.");
		}
	}

	@PostMapping("/updateTrainee/{traineeId}")
	public ResponseEntity<Object> updateTrainee(@PathVariable int traineeId, @RequestBody Trainee trainee) {
		try {
			traineeService.updateTrainee(traineeId, trainee);
			return new ResponseEntity<>("Updated records successfully", HttpStatus.OK);
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException("Cannot find trainee with given id");
		}
	}

	@PostMapping("/insertTrainee")
	public ResponseEntity<Object> insertTrainee(@RequestBody Trainee trainee) {
		try {
			traineeService.insertTrainee(trainee);
			return new ResponseEntity<>("Trainee added successfully.", HttpStatus.OK);
		} catch (IdAlreadyExistsException e) {
			throw new IdAlreadyExistsException("Trainee already exists in database");
		}
	}
}
