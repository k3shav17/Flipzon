package com.commerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoProductFoundWithName extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = NoProductFoundWithName.class)
	public ResponseEntity<Object> noProductFoundWithNameMentioned() {
		return new ResponseEntity<>("Product not found with name mentioned", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
