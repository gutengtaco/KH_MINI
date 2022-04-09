package com.kh.view;

import java.util.Scanner;

import com.kh.controller.ProductController;

	// 화면에 메뉴를 출력. 아래에 제시된 메뉴로 구성하고 각 메뉴를 선택하면 해당 기능 실행
	// 반복문을 활용하여 반복하게 작성하며 선택한 메뉴는 switch 문을 통해 각 기능별 메소드를 실행
	// 서비스 요청 처리 후 사용자가 보게 되는 응답 화면에 해당하는 메소드는 자유롭게 구현

public class ProductView {
	
	// 전역변수
	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("======= 제품 관리 프로그램 =======");
			System.out.println("1. 상품 전체 조회");
			System.out.println("2. 상품 추가");
			System.out.println("3. 상품명 이름으로 검색 (키워드 입력)"); // 상품 이름으로 키워드 검색
			System.out.println("4. 상품 정보 수정 (id 입력)"); // 상품 id로 조회하고 수정
			System.out.println("5. 상품 삭제 (id 입력)"); // 상품 id로 조회해서 삭제
			System.out.println("6. 상품 가격으로 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("----------------------------");
			System.out.println("이용할 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1 : break;
				case 2 : insertProduct(); break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("제품 관리 프로그램을 종료합니다. 감사합니다."); return;
				default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
		// 1. 상품 전체 조회
		
		// 2. 상품 추가
		public void insertProduct() {
			System.out.println("------ 상품 추가 ------");
			
			// 상품 추가시 입력받아야하는 데이터(NOT NULL 필수)
			System.out.println("상품 아이디 : ");
			String productId = sc.nextLine();
			
			System.out.println("상품명 : ");
			String productName = sc.nextLine();
			
			System.out.println("상품 가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.println("상품 상세정보 : ");
			String description = sc.nextLine();
			
			System.out.println("재고현황 : ");
			int stock = sc.nextInt();
			sc.nextLine();
			
			pc.insertProduct(productId, productName, price, description, stock);
		}					
		
	// 결과 관련 메소드
	// 성공시 출력용
	public void displaySuccess(String message) {
		System.out.println("요청 성공 : " + message);
	}
	
	// 실패시 출력용
	public void displayFail(String message) {
		System.out.println("요청 실패 : " + message);
	}
	
	
}
