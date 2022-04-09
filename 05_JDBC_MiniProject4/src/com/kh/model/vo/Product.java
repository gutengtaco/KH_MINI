package com.kh.model.vo;

public class Product {

	// 필드부 : DB 컬럼 정보와 유사하게
	
	private String productID; 	//상품아이디	//PRODUCT_ID VARCHAR2(20) PRIMARY KEY,
	private String productName;	//상품명		//PRODUCT_NAME VARCHAR2(20) NOT NULL,
	private int price;			//상품가격		//PRICE NUMBER NOT NULL,
	private String description;	//상품상세정보	//DESCRIPTION VARCHAR2(20),
	private int stock;			//재고 		//STOCK NUMBER NOT NULL);
	
	
	//생성자부 
	
	public Product() {
		super();
	}

	public Product(String productID, String productName, int price, String description, int stock) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.stock = stock;
	}

	// 메소드부
	//getter / setter 
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	//toString 오버라이딩
	@Override
	/*
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + ", stock=" + stock + "]";
	*/
	public String toString() {
		return "Product [상품아이디 :" + productID + ", 상품이름 :" + productName + ", 가격 :" + price
				+ ", 상품상세정보" + description + ", 재고 : " + stock + "]";
	
	}


	
	
	


	
	
	
}

