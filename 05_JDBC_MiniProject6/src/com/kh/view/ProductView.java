package com.kh.view;

import java.util.Scanner;

import com.kh.controller.ProductController;

public class ProductView {
	
	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("-------- 제품 관리 프로그램 --------");
			System.out.println("1. 상품 전체 조회 하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품명 검색 하기 (상품 이름으로 키워드 검색)");
			System.out.println("4. 상품 정보 수정 하기 (상품 id로 조회하고 수정)");
			System.out.println("5. 상품 삭제 하기 (상품 id로 조회해서 삭제)");
			System.out.println("6. 상품 가격으로 검색하기 ");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("------------------------");
			System.out.print("메뉴 검색 : ");
			
			char answer = sc.nextLine().charAt(0);
			
			switch(answer) {
			case '1':
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				updateProduct();
				break;
			case '5':
				break;
			case '6':
				break;
			case '0':
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void updateProduct() {
		
		System.out.println("-------- 4. 상품 정보 수정하기 (상품 id로 조회하고 수정) --------");
		System.out.print("정보를 수정할 상품 id : ");
		String productId = sc.nextLine();
		System.out.print("수정할 상품명 : ");
		String productName = sc.nextLine();
		System.out.print("수정할 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 상품 상세정보 : ");
		String description = sc.nextLine();
		System.out.print("수정할 재고 : "); // *********** 재고를 수정하는 것이 맞는지 **********
		int stock = sc.nextInt();
		sc.nextLine();
		pc.updateProduct(productId, productName, price, description, stock);
	}
	
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 성공 : " + message);
	}
	
	public void displayFail(String message) {
		System.out.println("서비스 요청 실패 : " + message);
	}
}
