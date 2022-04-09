package com.kh.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Product;
import com.kh.model.vo.ProductDao;

public class ProductService {
	
	public int updateProduct(Product p) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 메소드 호출 (Connection, Controller에서 받은 전달값)
		int result = new ProductDao().updateProduct(conn, p);
		
		// 3) 트랜잭션 처리
		if (result > 0 ) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) 결과 반환
		return result;
		
	}

}
