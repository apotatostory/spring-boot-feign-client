package com.example.springbootfeignclient.vo;

import java.math.BigDecimal;

public class OrderVo {

	private String name;

	private BigDecimal price;

	// 剩餘數量
	private int remained;

	// 數量
	private int count;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRemained() {
		return remained;
	}
	public void setRemained(int remained) {
		this.remained = remained;
	}
}
