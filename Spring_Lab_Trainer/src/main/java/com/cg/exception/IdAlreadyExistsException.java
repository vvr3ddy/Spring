package com.cg.exception;

public class IdAlreadyExistsException extends RuntimeException {

	public IdAlreadyExistsException() {
		super();
	}

	public IdAlreadyExistsException(String message) {
		super(message);
	}

}
