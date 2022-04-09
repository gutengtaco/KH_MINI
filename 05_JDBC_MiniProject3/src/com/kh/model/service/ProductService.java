package com.kh.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

	 /*
	  * JDBCTemplate 클래스의 getConnection() 메소드를 호출하여 
		커넥션 객체를 생성 후 ProductDao 의 메소드 호출시 매개변수로 사용하며
		처리 후 JDBCTemplate 클래스의 close() 메소드 호출을 commit 필요시 결과값에 따라
		JDBCTemplate 클래스의 commit() 또는 rollback() 메소드 호출 처리
		JDBCTemplate 클래스의 close() 메소드 호출을 통해 커넥션 객체 자원 반납
	  */

public class ProductService {
	
	// 2
	public int insertProduct(Product p) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 메소드 호출
		int result = new ProductDao().insertProduct(conn, p);
		
		// 3) 트랜잭션 처리
		if(result > 0) { // 성공 COMMIT
			JDBCTemplate.commit(conn);
		}
		else { // 실패 ROLLBACK
			JDBCTemplate.rollback(conn);
		}
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) 결과값 리턴
		return result;
	}
}
