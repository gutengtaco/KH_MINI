package com.kh.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {//JDBC에서 반복적으로 쓰는 코드들을 간단하게 메소드로 호출하기 위해 정의해둔 곳
						   //static메소드로 전부 만들기(재사용)

	//1) DB와 접속된 Connection 객체를 생성 후 객체를 반환
	public static Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();

		try {
			//driver.properties에 들어있는 파일불러오기
			prop.load(new FileInputStream("resources/driver.properties"));
			
			//1) JDBC Driver 등록
			Class.forName(prop.getProperty("driver"));
			
			//2) Connection 객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {//Connection 자원반납

		try {
			if (conn != null && !conn.isClosed()) {
				//null값인 상태에서 자원반납으로 닫으면 안되기떄문에 != 
				//conn이 닫힌상태로 자원반납이되면안되기떄문에 논리부정!으로 닫혀있지않은상태라면
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {//Result 자원반납
		try {
			if (rset != null && !rset.isClosed()) {
				//null값인 상태에서 자원반납으로 닫으면 안되기떄문에 != 
				//rset이 닫힌상태로는 안되기떄문에 논리부정!으로 닫혀있지않은상태라면
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {//(Prepared)Statement(부모) 자원반납
		try {
			if (stmt != null && !stmt.isClosed()) {
				//null값인 상태에서 자원반납으로 닫으면 안되기떄문에 != 
				//tmt이 닫힌상태로 자원반납이되면안되기떄문에 논리부정!으로 닫혀있지않은상태라면
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {//Connection 객체로 트랜잭션 처리
		try {
			if (conn != null && !conn.isClosed()) {
				//null값인 상태에서 자원반납으로 닫으면 안되기떄문에 !=
				//commit이 닫힌상태로는 안되기떄문에 논리부정!으로 닫혀있지않은상태라면
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {//Connection 객체로 트랜잭션 처리
		try {
			if (conn != null && !conn.isClosed()) {
				//null값인 상태에서 자원반납으로 닫으면 안되기떄문에 != 
				//rollback이 닫힌상태로는 안되기떄문에 논리부정!으로 닫혀있지않은상태라면
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
