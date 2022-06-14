package com.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> getProductsByCategory(String category);

	@Query("FROM Product WHERE name = :productName")
	List<Product> findProductsByName(String productName);
}
