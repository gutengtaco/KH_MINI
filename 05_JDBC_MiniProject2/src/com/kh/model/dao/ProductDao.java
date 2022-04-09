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

	// new ProductDao().___(); 할 때마다 ProductDao 객체가 생성되면서 기본생성자가 호출됨
	Properties prop = new Properties();

	public ProductDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> selectAll(Connection conn) {
		// 조회된 결과를 담을 ArrayList변수 선언
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null; // sql문 실행후 결과를 받기위한 변수
		ResultSet rset = null; // SELECT문이 실행된 조회결과값들이 담길 변수

		String sql = prop.getProperty("selectAll"); // query.xml에서 selectAll의 value값을 sql변수에 넣는다

		try {
			// PreparedStatement 객체 생성과 SQL 문 전달
			pstmt = conn.prepareStatement(sql);

			// SQL문 실행후 결과 받기
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Product p = new Product();

				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("STOCK"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		// 결과반납
		return list;
	}

}
