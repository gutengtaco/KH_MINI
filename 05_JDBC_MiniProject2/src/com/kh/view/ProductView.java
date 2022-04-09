package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductView {
	ProductController pc = new ProductController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 상품 전체 조회 하기");
			System.out.println("2.");
			System.out.println("3.");
			System.out.println("4.");
			System.out.println("5.");
			System.out.println("6.");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("---------------------");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				selectAll();
				break;
				
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력하세요.");
			}
			
			
		}
	}

	public void selectAll() {
		System.out.println("1. 상품 전체 조회 하기");
		
		pc.selectAll();
		
	}

	// 조회 실패  화면
	public void displayNodata(String string) {
		System.out.println(string);
	}
	
	// 조회 결과 화면
	public void displayList(ArrayList<Product> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
