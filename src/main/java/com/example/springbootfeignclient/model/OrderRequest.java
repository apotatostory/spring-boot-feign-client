package com.example.springbootfeignclient.model;

import java.util.List;

public class OrderRequest {

	private OrderModel product;

	private List<OrderModel> products;

	public List<OrderModel> getProducts() {
		return products;
	}

	public void setProducts(List<OrderModel> products) {
		this.products = products;
	}

	public OrderModel getProduct() {
		return product;
	}

	public void setProduct(OrderModel product) {
		this.product = product;
	}
}
