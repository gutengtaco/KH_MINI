package com.kh.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.view.ProductView;

public class Run {
	
	// 프로그램 실행 클래스. main 메소드 포함
	// ProductView 클래스의 mainMenu() 실행

	public static void main(String[] args) {
		
		// properties, xml 파일 형태로 내보내기
		/*
			Properties prop = new Properties();
			
			 // 파일 형식으로 내보내는 메소드 : prop.store(), prop.storeToXML()		
				try {
					prop.store(new FileOutputStream("resources/test.properties"), "test.properties");
					prop.storeToXML(new FileOutputStream("resources/test.xml"), "test.xml");
				
				} catch (IOException e) {			
					e.printStackTrace();
				}	
				=> 파일 만들어지고 이름 변경
		*/		
			
		// Properties 파일 읽어들이기
		/*
		Properties prop = new Properties();
		
			try {				
				prop.load(new FileInputStream("resources/driver.properties"));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 안의 값 수정 후 출력
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
			*/
		
		
		// xml 읽어들이기
		/*
		Properties prop = new Properties();
			
			try {				
				prop.loadFromXML(new FileInputStream("resources/query.xml"));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		*/
		
		// 메인메뉴 화면
		new ProductView().mainMenu();
				
	}

}
