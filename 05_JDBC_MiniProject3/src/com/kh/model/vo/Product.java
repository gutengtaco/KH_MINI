package com.kh.model.vo;

	// DB 에 생성한 테이블의 컬럼과 일치하게 필드 생성
	// 생성자, getter&setter 작성, toString() 메소드 오버라이딩

public class Product {
	
	// 필드부	
	private String productId; // PRODUCT_ID VARCHAR2(20) PRIMARY KEY, -- 상품아이디
	private String productName; // PRODUCT_NAME VARCHAR2(20) NOT NULL, -- 상품명
	private int price; // PRICE NUMBER NOT NULL, -- 상품가격
	private String description; // DESCRIPTION VARCHAR2(20), -- 상품상세정보
	private int stock; // STOCK NUMBER NOT NULL); -- 재고
	
	// 생성자부
	public Product() {
		super();
	}

	public Product(String productId, String productName, int price, String description, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.stock = stock;
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