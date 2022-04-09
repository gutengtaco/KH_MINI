package com.kh.controller;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductView;

public class ProductController {
	
	public void updateProduct(String productId, String productName, int price, String description, int stock) {
		
		// 1) VO 객체로 가공
		Product p = new Product();
		p.setProductId(productId);
		p.setProductName(productName);
		p.setPrice(price);
		p.setDescription(description);
		p.setStock(stock);
		
		// 2) Service 메소드 호출
		int result = new ProductService().updateProduct(p);
		
		// 3) 성공 / 실패 여부에 따라 응답 뷰 지정
		if (result > 0) {
			new ProductView().displaySuccess("상품 정보 변경 완료");
		}
		else {
			new ProductView().displayFail("상품 정보 변경 실패");
		}
		
	}

}
