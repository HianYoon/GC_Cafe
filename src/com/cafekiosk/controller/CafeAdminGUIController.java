package com.cafekiosk.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.TreeMap;

import com.cafekiosk.model.vo.Ingredient;

public class CafeAdminGUIController {
	private CafeAdminController cac= new CafeAdminController();
	
	public void adminLoginInfoFileCreate() {
		Properties text=new Properties();
		text.setProperty("�� ���������.... ", "��û��....");
		text.setProperty("��й�ȣ��", "gecko");
		text.setProperty("���̵��", "admin");
		
		
		try(FileWriter fw =new FileWriter(System.getProperty("user.home") + "/My Documents/���ƶ� ���̵�� ����� ����� ��û�̿�.txt")){
			text.store(fw, "�ѽ��� �߻���..... ��");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public TreeMap<Ingredient,Double> ingredientMyStockLoader(){
		return cac.ingredientMyStockLoader();
	}
	
	public boolean ingredientMyStockSave(TreeMap<Ingredient,Double> myNewStock) {
		return cac.ingredientMyStockSave(myNewStock);
	}
	
	public boolean adminLogIn(String id, String pw) {
		if(id.equals("admin") && pw.equals("gecko")) {

			return true;
		} else return false;
	}
}
