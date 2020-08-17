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
		text.setProperty("좀 까먹지마라.... ", "멍청이....");
		text.setProperty("비밀번호는", "gecko");
		text.setProperty("아이디는", "admin");
		
		
		try(FileWriter fw =new FileWriter(System.getProperty("user.home") + "/My Documents/보아라 아이디와 비번을 까먹은 멍청이여.txt")){
			text.store(fw, "한심한 중생아..... 휴");
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
