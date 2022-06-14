package com.commerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.commerce.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Long, Order> {

}
