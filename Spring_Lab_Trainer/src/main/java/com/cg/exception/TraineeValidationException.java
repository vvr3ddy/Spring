package com.cg.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class TraineeValidationException extends RuntimeException {

	List<String> messages = new ArrayList<>();

	public TraineeValidationException() {
		super();
	}

	public TraineeValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
