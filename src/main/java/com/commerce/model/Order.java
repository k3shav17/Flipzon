package com.commerce.model;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;

	private String status;

	@JsonManagedReference
	@OneToMany(mappedBy = "pk.order")
	private List<OrderProduct> orderProducts = new ArrayList<>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		List<OrderProduct> orderProducts = getOrderProducts();
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}
		return sum;
	}

	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

}
