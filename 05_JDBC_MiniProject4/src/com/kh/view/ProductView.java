package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

import com.kh.model.service.ProductController;
import com.kh.model.vo.Product;

public class ProductView {

	// 전역으로 다 쓸 수 있게 Scanner 객체 생성
	Scanner sc = new Scanner(System.in);

	// ProductController도 전역 변수로 객체 생성
	private ProductController pc = new ProductController();

	// 메인화면을 담담하는 메소 (사용자가 제일 먼저 볼 화면)
	public void mainMenu() {

		while(true) {

			System.out.println("****** 상품 관리 프로그램 *****");
			System.out.print("3.상품명 검색하기");
			System.out.println("-------------------------");
			System.out.print("이용할 메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch(menu) {

			case 3: selectByProductName();break;
			case 0:  System.out.println("프로그램을 종료합니다."); return;
			}
		}

	}//mainMenu


	// 상품명 검색 ( 상품 이름으로 키워드 검색)
	public void selectByProductName() {

		System.out.print("상품명을 입력하세요 : ");
		// 필요한 데이터
		String keyword = sc.nextLine();

		// keyword 변수를 ProductController 메소드로 넘김
		pc.selectByProductName(keyword);

	}//selectByProductName() 

	//검색 결과가 없는 경우 (keyword)
	public void displayNoResult(String message) {

		System.out.println(message);
		disOneMore();


	}//displayNoResult

	public void displayList(ArrayList<Product>list) {

		System.out.println("검색 결과는 총 " + list.size() + "개 입니다.");

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}// displayList

	public void disOneMore() {
		while(true) {

			System.out.print("상품명을 다시 입력하시겠습니까? (Y/ N) : ");
			char awser = sc.nextLine().toUpperCase().charAt(0);

			if(awser == ('Y')) {
				selectByProductName();
			}
			else if(awser == ('N')) {
				mainMenu();
			}
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 ");
				continue;
			}
		}

	}//disOneMore()
}

