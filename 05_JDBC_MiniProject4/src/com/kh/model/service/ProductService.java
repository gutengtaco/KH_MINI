package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductService {
	
	public ArrayList<Product> selectByProductName(String keyword){
		
		//1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//2) DAO 메소드 호출(conn, keyword 매개변수 넘기기)
		ArrayList<Product> list = new ProductDao().selectByProductName(conn,keyword);
		
		//3) 트랜잭션 처리 ( SELECT문의 경우 생략 )
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5)결과물을 Controller로 리턴
		return list;
		
	}//selectByProductName

}
