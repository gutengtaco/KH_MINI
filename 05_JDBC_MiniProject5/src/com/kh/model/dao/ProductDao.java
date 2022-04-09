package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;

public class ProductDao {//Controller 에서 전달받은 값으로 본격적인 JDBC코드 작성

	//전역변수로 Properties 객체생성
	private Properties prop = new Properties();

	public ProductDao() {//코드수를 줄이기 위해 기본생성자로 호출
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int deleteProduct(Connection conn, String productld) {
		
		//0) 변수 셋팅 
		int result = 0;
		PreparedStatement pstmt = null;
		
		//1) SQL문 작성(Properties 파일에 작성한 sql문 불러오기)
		String sql = prop.getProperty("deleteProduct");

		try {
			//2) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//3) 미완성 sql문 완성시키기
			pstmt.setString(1, productld);

			//4) DB 에 완성된 SQL문을 실행 후 결과를 받기(delete=executeUpdate)
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5) 자원반납(JDBCTemplate 에서 불러오기)
			JDBCTemplate.close(pstmt);
		}
		//6) 결과값 리턴
		return result;
	}

}
