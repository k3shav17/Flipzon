package com.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.Order;
import com.commerce.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@PostMapping("/buy")
	private ResponseEntity<Object> createOrder(@RequestBody Order order) {
		return new ResponseEntity<>("Product ordered successfully ", new HttpHeaders(), HttpStatus.OK);
	}

}
