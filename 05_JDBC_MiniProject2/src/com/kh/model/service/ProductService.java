package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductService {

	public ArrayList<Product> selectAll() {

		// 1) Connection 객체생성 / JDBCTemplate에 선언해둔 getConnection()메소드를 호출
		Connection conn = JDBCTemplate.getConnection();

		// 2) 반환을 위한 ArrayList<Product> list변수 / DAO메소드 호출
		ArrayList<Product> list = new ProductDao().selectAll(conn);

		// 3) Connection 객체 반납
		JDBCTemplate.close(conn);

		return list;
	}

}
