package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Product;

	// 공통 기능: DB 에 접근하여 각 기능 별 쿼리 실행 후 결과 처리 및 결과값 리턴

public class ProductDao {
	
	// 전역변수
	private Properties prop = new Properties();
	
	public ProductDao(){ // 기본생성자 호출됨
		
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	// 상품 추가 요청시 입력했던 값들로 INSERT 하는 메소드	
	public int insertProduct(Connection conn, Product p) {
			
		// 변수 셋팅
		int result = 0;		
		PreparedStatement pstmt = null;
		
		// 실행할 SQL문(미완성)
		// INSERT INTO PROPDUCT VALUES(?, ?, ?, ?, ?);
		String sql = prop.getProperty("insertProduct");	
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성 SQL문  값 채우기
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getProductName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setInt(5, p.getStock());
			
			// DB 에 완성된 SQL 문 실행 후 결과받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			
			// pstmt 반납
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 반환
		return result;
		}
	
	
	
	
	
}
