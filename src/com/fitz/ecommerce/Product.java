package com.fitz.ecommerce;

import java.math.BigDecimal;

public class Product {

	private int productId;
	private String productName;
	private int quantityPerProduct;
	private Unit unit;
	private BigDecimal cost;
	private int inventory;

	public Product(Integer productId) {

		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityPerProduct() {
		return quantityPerProduct;
	}

	public void setQuantityPerProduct(int quantityPerProduct) {
		this.quantityPerProduct = quantityPerProduct;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getInventory() {
		return this.inventory;
	}

	public void setInventory(int quantity) {
		this.inventory = quantity;
	}

}
