package com.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.Product;
import com.commerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;

	@PostMapping("/addProduct")
	private ResponseEntity<Object> productAddition(@RequestBody Product product) {
		Product productAdded = productRepository.save(product);
		return new ResponseEntity<>(productAdded, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getProduct/{name}")
	private ResponseEntity<Object> getProduct(@PathVariable("name") String name) {
		List<Product> productList = productRepository.getProductsByName(name);
		return new ResponseEntity<>(productList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getall")
	private ResponseEntity<Object> getAllProducts() {
		return new ResponseEntity<>(productRepository.findAll(), new HttpHeaders(), HttpStatus.OK);
	}
}