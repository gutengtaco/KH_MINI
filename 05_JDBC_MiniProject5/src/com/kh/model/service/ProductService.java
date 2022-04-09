package com.kh.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductDao;

public class ProductService {//DAO의 역할분담 : Connection 객체 이용 코드들은 전부 이곳에서 이루어질 예정
	
	
	
	
	
	public int deleteProduct(String productld) {
		
		//1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//2) DAO메소드 호출(Connection, 전달값 같이 넘기기)
		int result = new ProductDao().deleteProduct(conn, productld);
		
		//3) (conn) 트랜잭션처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		//4) 결과값 리턴
		return result;
	}
}
