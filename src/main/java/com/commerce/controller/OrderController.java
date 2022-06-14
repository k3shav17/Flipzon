package com.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
}
