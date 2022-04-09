package com.kh.model.service;

import java.util.ArrayList;

import com.kh.model.vo.Product;
import com.kh.view.ProductView;

public class ProductController {
	
	public void selectByProductName(String keyword) {
		
		//1) 가공 : 상품명이란 값이 하나 뿐이라 VO 객체로 가공 패스
		
		//2) Serivce 메소드 호출
		ArrayList<Product> list = new ProductService().selectByProductName(keyword);
		
		// 3) 조회 결과가 있는지 없는지 판단 후 View 지정
		
		if(list.isEmpty()) {// 검색결과가 없는 경우
			new ProductView().displayNoResult("<"+keyword +">" + " 에 해당하는 검색 결과가 없습니다.");
			
		}
		else {	// 검색 결과가 있는 경우
			
			new ProductView().displayList(list);
		}
		
	}//selectByProductName

}
