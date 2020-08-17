package com.cafekiosk.view.console;

import java.util.Scanner;

import com.cafekiosk.controller.CafeAdminController;

public class AdminView {
	private Scanner sc =new Scanner(System.in);
	private CafeAdminController cac=new CafeAdminController();
	public void mainView() {
		while(true) {
			System.out.println("===== 카페 개발 및 보수용 뷰 =====");
			System.out.println("1. 재료 추가");
			System.out.println("2. 재료 종류 보기");
			System.out.println("3. 내 재료 재고 0인 파일 만들기");
			System.out.println("4. 메뉴 추가");
			System.out.println("5. 메뉴 종류 보기");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호  입력 : ");
			
			int choice=inputChoice();
			switch(choice) {
			case 1: cac.ingredientInitializer(); break;
			case 2: cac.printStock(cac.ingredientZeroValueLoader());break;
			case 3: cac.ingredientZeroValueToMyStock(); break;
			case 4: cac.saveMenuItems(); break;
			case 5: cac.printMenuItems(cac.loadMenuItems());break;
			case 9: System.out.println("프로그램 종료"); return;
				default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public int inputChoice() {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return -1;
		}
	}
}
