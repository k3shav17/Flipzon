package com.commerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.exception.CategoryNotFoundException;
import com.commerce.exception.NoProductFoundWithName;
import com.commerce.exception.ProductNotFoundException;
import com.commerce.model.Product;
import com.commerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;

	@PostMapping("/addProduct")
	private String productAddition(@RequestBody Product product) {

		List<Product> isProductWithIdExists = productRepository.findProductsByName(product.getName());
		if (!isProductWithIdExists.isEmpty()) {
			return String.format("Product %s already exists", product.getName());
		} else {
			productRepository.save(product);
			return String.format("Product %s is added successfully", product.getName());
		}
	}

	@GetMapping("/getProduct/{name}")
	private ResponseEntity<Object> getProduct(@PathVariable("name") String name) {
		List<Product> productList = productRepository.findProductsByName(name);
		if (productList.isEmpty()) {
			throw new NoProductFoundWithName();
		}
		return new ResponseEntity<>(productList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getall")
	private ResponseEntity<Object> getAllProducts() {
		return new ResponseEntity<>(productRepository.findAll(), new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	private void removeProduct(@PathVariable("id") Long productId) {
		Optional<Product> isProductWithIdExists = productRepository.findById(productId);
		if (isProductWithIdExists.isEmpty()) {
			throw new ProductNotFoundException();
		}
		productRepository.deleteById(productId);
	}

	@GetMapping("/category/{type}")
	private ResponseEntity<Object> getProductsByCategory(@PathVariable("type") String type) {

		List<Product> isCategory = productRepository.findByCategory(type);
		if (isCategory.isEmpty()) {
			throw new CategoryNotFoundException();
		}
		return new ResponseEntity<>(isCategory, new HttpHeaders(), HttpStatus.OK);
	}
}
