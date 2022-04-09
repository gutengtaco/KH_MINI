package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductView;

public class ProductController {

	// 상품 전체 조회요청 처리 메소드
	public void selectAll() {
		// 반환값이 여러개이므로 ArrayList<Product>로 받는다 / Service 메소드 호출
		ArrayList<Product> list = new ProductService().selectAll();

		// 조회된 결과에 따른 응답화면 / 동적코딩
		if (list.isEmpty()) {
			new ProductView().displayNodata("전체 조회 결과가 없습니다.");
		} else {
			new ProductView().displayList(list);
		}
	}

}
