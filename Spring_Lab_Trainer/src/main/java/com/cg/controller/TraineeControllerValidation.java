package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Trainee;
import com.cg.exception.IdAlreadyExistsException;
import com.cg.exception.TraineeValidationException;
import com.cg.service.ITraineeService;

import io.swagger.annotations.Api;

@Api("validation of trainee beans")
@RestController
@RequestMapping("/trainee")
public class TraineeControllerValidation {

	@Autowired
	ITraineeService traineeService;

	@PostMapping("/addNewTrainee")
	public ResponseEntity<Object> addNewTrainee(@Valid @RequestBody Trainee trainee, BindingResult bindingResult)
			throws MethodArgumentNotValidException {

		String error = "";
		if (bindingResult.hasErrors()) {
			System.out.println("Some errors exist");
			List<FieldError> errors = bindingResult.getFieldErrors();

			List<String> errorList = new ArrayList<String>();
			for (FieldError err : errors) {
				{
					errorList.add(err.getDefaultMessage());
				}
			}
			throw new TraineeValidationException(errorList);
		}

		try {
			traineeService.insertTrainee(trainee);
		} catch (IdAlreadyExistsException e) {
			throw new IdAlreadyExistsException("Trainee with given id already exists.");
		}
		return new ResponseEntity<>("Added Trainee successfully", HttpStatus.OK);
	}
}
