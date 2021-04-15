package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PriceException.class)
	public ResponseEntity<Object> handleException(PriceException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
}
