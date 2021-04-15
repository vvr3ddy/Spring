package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TraineeExceptionController {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = IdAlreadyExistsException.class)
	public ResponseEntity<Object> handleException(IdAlreadyExistsException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = TraineeValidationException.class)
	public ResponseEntity<Object> handleException(TraineeValidationException exception) {
		return new ResponseEntity<>(exception.getMessages(), HttpStatus.BAD_REQUEST);
	}
}
