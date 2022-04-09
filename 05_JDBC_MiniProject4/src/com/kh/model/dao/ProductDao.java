package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Product;

public class ProductDao {
	
	// 전역변수
	private Properties prop = new Properties();
	
	// new ProductDao().xxx(); 할때마다 ProductDao 객체가 생성되면서 기본생성자가 호출됨

	public ProductDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//ProductDao()
	

	// 사용자 회원 이름(키워드)을 검색 요청시 SELECT문을 실행할 메소드
	public ArrayList<Product> selectByProductName(Connection conn, String keyword) {// SELECT문 => ResultSet 객체(여러 행 조회)

		// 0) 필요한 변수 셋팅
		ArrayList<Product> list = new ArrayList<>(); // 조회한 상품 정보를 차곡차곡 담을 예정

		PreparedStatement pstmt = null; // 
		ResultSet rset = null; // 


		String sql = prop.getProperty("selectByProductName");
	
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rset = pstmt.executeQuery();


			while(rset.next()) {


				Product p = new Product();
				p.setProductID(rset.getString("PRODUCT_ID"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("STOCK"));

				// 리스트에 해당 Member 객체를 add
				list.add(p);
			}

		} catch (SQLException e) {//2번에 대해서 예외처리
			e.printStackTrace();
		}finally {

			// 7) 자원반납(역순)
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);

		}
		// 8) 결과 값 return
		return list;

	}//selectByUserName
}
