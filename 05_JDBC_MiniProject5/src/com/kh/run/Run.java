package com.kh.run;

import com.kh.view.ProductView;

public class Run {

	public static void main(String[] args) {
//
//		Properties prop = new Properties();
		//Properties 객체 생성
//
//		try { //파일 형식으로 내보내기
//			prop.store(new FileOutputStream("resources/driver.properties"), "driver.properties");
//			prop.storeToXML(new FileOutputStream("resources/query.xml"), "query.properties");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		try { //파일 형식으로 읽어들이기
//			prop.load(new FileInputStream("resources/driver.properties"));
//			prop.loadFromXML(new FileInputStream("resources/query.xml"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		new ProductView().mainMenu();
	}
}
