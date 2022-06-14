package com.commerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ResponseStatus(HttpStatus.NOT_FOUND)
@ControllerAdvice
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> handlingProductNotFoundException() {
		return new ResponseEntity<>("No product has found with ID mentioned",  new HttpHeaders(),
				HttpStatus.NOT_FOUND);
	}

}
