package com.kh.view;

import java.util.Scanner;
import com.kh.controller.ProductController;

public class ProductView {

	Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController();

	public void mainMenu() { //사용자가 가장 먼저 보게 될 메인 메뉴

		while (true) {
			System.out.println("메뉴 구성");
			System.out.println("1. 상품 전체 조회하기");
			System.out.println("2. 상품 추가하기");
			System.out.println("3. 상품명 검색하기");
			System.out.println("4. 상품 정보 수정하기");
			System.out.println("5. 상품 삭제 하기"); // DELETE FROM PRODUCT WHERE PRODUCT_NAME = ?
			System.out.println("0. 프로그램 종료하기");

			System.out.print("메뉴를 입력하세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 5:
				deleteProduct();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("잘못된 메뉴 입력입니다. 다시 입력하세요");
			}

		}
	}

	public void deleteProduct() {//상품 삭제 화면
		System.out.println("***** 상품 삭제 하기 *****");

		System.out.print("삭제 시킬 상품을 입력하세요 : ");
		String productld = sc.nextLine();

		pc.deleteProduct(productld);

	}

	public void displaySuccess(String message) {
		System.out.println(message);
	}

	public void displayFail(String message) {
		System.out.println(message);
	}

}
