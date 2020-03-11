package com.example.springbootfeignclient.model;

import java.util.List;

import com.example.springbootfeignclient.vo.OrderVo;

public class OrderRequest {

	private OrderVo product;

	private List<OrderVo> products;

	public List<OrderVo> getProducts() {
		return products;
	}

	public void setProducts(List<OrderVo> products) {
		this.products = products;
	}

	public OrderVo getProduct() {
		return product;
	}

	public void setProduct(OrderVo product) {
		this.product = product;
	}
}
