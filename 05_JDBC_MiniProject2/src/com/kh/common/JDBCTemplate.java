package com.kh.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	// Connection 객체를 생성하고 생성된 객체를 반환해주는 메소드
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			// 동적코딩을 위해 Properties를 이용해서 resources/driver.properties 파일을 사용
			prop.load(new FileInputStream("resources/driver.properties"));

			// 1) JDBC Driver 등록/ driver.properties의 키값 driver의 value값을 가져온다
			Class.forName(prop.getProperty("driver"));

			// 2) Connection 객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// Connection 객체를 매개변수로 전달받아 반납하는 메소드
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				// Connection 객체가 null이 아니거나 Connection 객체가 닫혔지 않았다면
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Statement 객체를 매개변수로 전달받아 반납하는 메소드
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				// Statement 객체가 null이 아니거나 Statement 객체가 닫혔지 않았다면
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ResultSet 객체를 매개변수로 전달받아 반납하는 메소드
	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				// ResultSet 객체가 null이 아니거나 ResultSet 객체가 닫혔지 않았다면
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 매개변수로 전달 받은 Connection 객체로 COMMIT 시켜주는 메소드
	public static void commit(Connection conn) {
		try {

			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 매개변수로 전달 받은 Connection 객체로 ROLLBACK 시켜주는 메소드
	public static void rollback(Connection conn) {
		try {

			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
