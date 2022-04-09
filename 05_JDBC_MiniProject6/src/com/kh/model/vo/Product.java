package com.kh.model.vo;

public class Product {
	
	// 필드부
	String productId; // PRODUCT_ID VARCHAR2(20) PRIMARY KEY
	String productName; // PRODUCT_NAME VARCHAR2(20) NOT NULL
	int price; // PRICE NUMBER NOT NULL
	String description; // DESCRIPTION VARCHAR2(20)
	int stock; // STOCK NUMBER NOT NULL
	
	// 생성자부
	public Product() {
		super();
	}
	
	// 메소드부
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + ", stock=" + stock + "]";
	}
}
