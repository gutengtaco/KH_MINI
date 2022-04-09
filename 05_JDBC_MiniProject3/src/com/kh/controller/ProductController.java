package com.kh.controller;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductView;

// 입력 받은 데이터의 수가 많을 경우에는 Product 객체에 담아 ProductService 클래스로 넘긴다.

public class ProductController {

	// 1. 상품 전체 조회
	public void selectAll() {		
	}
	
	
	// 2. 상품 추가
	public void insertProduct(String productId, String productName, int price,
							  String description, int stock) {
		
		Product p = new Product(productId, productName, price, description, stock);
		
		int result = new ProductService().insertProduct(p);
		
		if(result > 0) {
			new ProductView().displaySuccess("상품 추가 성공");
		}
		else {
			new ProductView().displayFail("상품 추가 실패");
		}
	}
	
	
	// 3. 상품명 이름으로 검색 (키워드 입력)
	public void selectByProductName(String keyword) {		
	}	
	// 4. 상품 정보 수정 (id 입력)
	public void updateProduct(String productId, int price, String description, int stock) {		
	}	
	// 5. 상품 삭제 (id 입력)
	public void deleteProduct(String productId) {		
	}	
	// 6. 상품 가격으로 조회
}
