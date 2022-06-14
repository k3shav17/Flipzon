package com.commerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<Object> noProductFoundWithNameMentioned() {
		return new ResponseEntity<>("Category not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
