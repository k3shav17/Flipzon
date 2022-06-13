package com.commerce.repository;

import java.util.List;

import com.commerce.model.Product;

public interface ProductRepository {

	List<Product> getAllProducts();

	List<Product> getProductsByCategory();

	List<Product> getProductsByName();

}
