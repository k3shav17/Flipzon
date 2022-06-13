package com.commerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByName(String productName);

}
