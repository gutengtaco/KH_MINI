package com.kh.controller;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductView;

public class ProductController {// 기능담당
	
	
	
	
	
	
	
	public void deleteProduct(String productld) {
		
		//1) VO로 가공할 필요 X 
		
		//2)Service 메소드로 호출할 때 전달
		int result = new ProductService().deleteProduct(productld);
		
		//3) 성공/실패 여부에 따라 뷰 메소드에서 호출
		if(result > 0) {
			new ProductView().displaySuccess(productld + "상품 삭제를 성공하였습니다.");
		}
		else {
			new ProductView().displayFail("입력하신 상품은 존재하지 않는 상품입니다.");
		}
		
	}	
}
