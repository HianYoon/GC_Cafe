package com.cafekiosk.view.console;

import java.util.Scanner;

import com.cafekiosk.controller.CafeAdminController;

public class AdminView {
	private Scanner sc =new Scanner(System.in);
	private CafeAdminController cac=new CafeAdminController();
	public void mainView() {
		while(true) {
			System.out.println("===== ī�� ���� �� ������ �� =====");
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ���� ����");
			System.out.println("3. �� ��� ��� 0�� ���� �����");
			System.out.println("4. �޴� �߰�");
			System.out.println("5. �޴� ���� ����");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ  �Է� : ");
			
			int choice=inputChoice();
			switch(choice) {
			case 1: cac.ingredientInitializer(); break;
			case 2: cac.printStock(cac.ingredientZeroValueLoader());break;
			case 3: cac.ingredientZeroValueToMyStock(); break;
			case 4: cac.saveMenuItems(); break;
			case 5: cac.printMenuItems(cac.loadMenuItems());break;
			case 9: System.out.println("���α׷� ����"); return;
				default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
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
