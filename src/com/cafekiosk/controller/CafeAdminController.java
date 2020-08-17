package com.cafekiosk.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import com.cafekiosk.model.vo.Ingredient;
import com.cafekiosk.model.vo.MenuItem;

public class CafeAdminController {
	//프로그램 개발/보수 관리용 클래스
	private Scanner sc =new Scanner(System.in);
	
	private String[] ingredientKindArr = {"신선제품","커피","가루류","기타류"};
	private String[] menuKindArr= {"Coffee", "Non-Coffee"};
	
	//트리맵은 같은 로직으로 키를 정렬하기 때문에 같은 키들을 가진 트리맵은 어디에서든 같은 정렬순서를 가진다고 예측할 수 있다.
	private TreeMap<Ingredient,Double> ingMap=new TreeMap<Ingredient, Double>();
	private TreeMap<Ingredient,Double> recipeMap= new TreeMap<Ingredient, Double>();
	
	//OrderHistory와 공유될 수 있음
	private TreeMap<MenuItem,Integer> menuItems=new TreeMap<MenuItem, Integer>();
	
	
	
	public CafeAdminController() {}
	
	//재고 맵을 받아와서 프린트함
	public void printStock(TreeMap<Ingredient,Double> ingMap) {
		this.ingMap=ingMap;
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(ingMap.keySet());
		int i=1;
		System.out.println("===== 현재 재료 ======");
		for(Ingredient v:tsKey) {
			System.out.println("**"+i+"번 재료 ====");
			System.out.println(v+"/ 재고 : "+ingMap.get(v));
			i++;
		}
	}
	//모든 재료의 밸류가 0값으로 되어있는 자료 가져오기
	@SuppressWarnings("unchecked")
	public TreeMap<Ingredient,Double> ingredientZeroValueLoader() {
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("./data/adminData/totalIngredientZeroValue.dat"))){
			ingMap=(TreeMap<Ingredient,Double>)ois.readObject();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
		}
		return ingMap;
	}
	//재료 등록/모든 값은 0으로 시작
	public boolean ingredientInitializer() {
		System.out.println("기존 파일을 불러옵니다!");
		ingMap=ingredientZeroValueLoader();
		
		int i=1;
		try{
			i=ingMap.size()+1;
		}catch(Exception e) {
		}
		while(true) {
			System.out.println("======"+i+"번째 등록할 재료======");
			i++;
			System.out.println("신선제품(0), 커피(1), 가루류(2), 기타류(3) 중에서 고르시오");
			int index=sc.nextInt();
			System.out.println("제품의 이름을 입력하시오.");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("제품의 가격을 입력하시오.");
			int price=sc.nextInt();
			ingMap.put(new Ingredient(ingredientKindArr[index], name, price), 0.0);
	
			System.out.println("1을 누르면 종료하고 모든 목록 저장");
			if(sc.next().equals("1")) break;
		}
		//파일 저장
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/totalIngredientZeroValue.dat"))){
			oos.writeObject(ingMap);
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		printStock(ingMap);
		return true;
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	//모든 재료의 밸류가 0으로 되어있는 자료를 내 재고로 만들어주는 메소드
	public void ingredientZeroValueToMyStock() {
		ingMap=ingredientZeroValueLoader();
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/ingredientMyStock.dat"))){
			oos.writeObject(ingMap);
		}catch(IOException e) {
			e.printStackTrace();
		}
		printStock(ingMap);
	}
	
	//내 재료 재고를 파일에서 불러오고, 그 값이 저장된 트리맵을 리턴하는 메소드
	@SuppressWarnings("unchecked")
	public TreeMap<Ingredient,Double> ingredientMyStockLoader() {
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("./data/adminData/ingredientMyStock.dat"))){
			ingMap=(TreeMap<Ingredient,Double>)ois.readObject();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
		}
		return ingMap;
	}
	//새로운 재료 개수 맵을 받아와 원래있던 파일을 덮어쓰기함
	public boolean ingredientMyStockSave(TreeMap<Ingredient,Double> myNewStock) {
		ingMap=myNewStock;
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/ingredientMyStock.dat"))){
			oos.writeObject(ingMap);
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
		printStock(ingMap);
		return true;
	}
	
	//본사 주문을 마치면 산 갯수만큼 해당 재료 재고에 추가되는 메소드
	public void ingredientMarketBought(double[] boughtNumbers) {
		ingMap=ingredientMyStockLoader();
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(ingMap.keySet());
		int i=0;
		for(Ingredient v:tsKey) {
			ingMap.replace(v, ingMap.get(v)+boughtNumbers[i]);
			i++;
		}
		boolean result=ingredientMyStockSave(ingMap);
		if(result) System.out.println("성공적으로 저장!");
		else System.out.println("저장실패!");
	}
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
	//메뉴 아이템 프린트
	public void printMenuItems(TreeMap<MenuItem, Integer> menuItems) {
		for(MenuItem mi:new TreeSet<MenuItem>(menuItems.keySet())) {
			System.out.println(mi);
		}
	}
	
	//기존 메뉴 아이템들을 불러오는 메소드 
	@SuppressWarnings("unchecked")
	public TreeMap<MenuItem, Integer> loadMenuItems(){
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("./data/adminData/menuItems.dat"))){
			menuItems=(TreeMap<MenuItem, Integer>)ois.readObject();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
		}
		return menuItems;
	}
	
	//메뉴 아이템들을 loadMenuItems에서 불러온 뒤 새로 저장하는 메소드
	public boolean saveMenuItems() {
		System.out.println("기존 파일을 불러옵니다!");
		menuItems=loadMenuItems();
		int i=1;
		try{
			i=menuItems.size()+1;
		} catch(Exception e) {	
		}
		while(true) {
			System.out.println("======"+i+"번째 등록할 제품======");
			i++;
			System.out.println("Coffee(0), Non-Coffee(1)중에서 고르시오");
			int index=sc.nextInt();
			System.out.println("제품의 이름을 입력하시오.");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("레시피를 입력하시오");
			recipeMap=recipeMaker();
			System.out.println("제품의 가격을 입력하시오.");
			int price=sc.nextInt();
			menuItems.put(new MenuItem(menuKindArr[index], name, recipeMap, price), 0);
	
			System.out.println("1을 누르면 종료하고 모든 목록 저장");
			if(sc.next().equals("1")) break;
		}
		
		//파일 저장
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/menuItems.dat"))){
			oos.writeObject(menuItems);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//레시피 만들어주는 메소드
	public TreeMap<Ingredient,Double> recipeMaker(){
		recipeMap=ingredientZeroValueLoader();
		Ingredient[] ingArr=new Ingredient[recipeMap.size()];
		while(true) {
			System.out.println("필요한 재료 번호를 입력하세요");
			int i=0;
			for(Ingredient v:new TreeSet<Ingredient>(recipeMap.keySet())) {
				System.out.print(i+"번 "+v.getIngredientName()+" ");
				ingArr[i]=v;
				i++;
			}
			System.out.print(": ");
			int index=sc.nextInt();
			System.out.println("필요한 "+ingArr[index].getIngredientName()+"의 양을 입력하세요.");
			double amount =sc.nextDouble();
			if(index<0||amount<0) {
				System.out.println("잘못된 입력! 다시 입력하세요."); continue;
			}
			recipeMap.put(ingArr[index],amount);
			System.out.println("재료를 더 입력하시겠습니까? 마치시려면 1을 눌러주세요");
			if(sc.next().equals("1")) break;
		}
		
		printRecipe(recipeMap);
		
		return recipeMap;
	}
	
	//레시피 프린트해주는 메소드
	public void printRecipe(TreeMap<Ingredient,Double> recipeMap) {
		this.recipeMap=recipeMap;
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(recipeMap.keySet());
		int i=1;
		System.out.println("===== 레시피 ======");
		for(Ingredient v:tsKey) {
			System.out.println("**"+i+"번 재료 ====");
			System.out.println(v+"/ 수량 : "+recipeMap.get(v));
			i++;
		}
	}
	//////////////////////////////////////////////////////
	//CafeOrderController와 연결되어, 주문을 받아오고, 
	//각 메뉴에 사용된 레시피를 각 메뉴의 개수에 곱해 현재 재고를 수정함
	
	public void renewStock(TreeMap<MenuItem, Integer> orderCurrent) {
		//현재 재고 불러오기
		TreeMap<Ingredient, Double> stockCurrent=ingredientMyStockLoader();
		//각각의 재료가 사용된 양을 합산하기 위한 배열 생성
		double[] usedIngredientsValue= new double[stockCurrent.size()];
		
		//1.현재 주문에서 각각의 메뉴 아이템을 뽑아내고, 2. 메뉴아이템들에서 각각의 레시피를 뽑아. 
		//3.각각의 재료가 사용된 양을 더블 배열에 넣는다.
		for(MenuItem mi : orderCurrent.keySet()) {
			int i=0;
			for(Ingredient ig : new TreeSet<Ingredient>(mi.getRecipe().keySet())) {
				usedIngredientsValue[i]+=mi.getRecipe().get(ig);
				i++;
			}
		}
		
		//stockCurrent의 재고를 하나하나 나오게 하고 더블 배열만큼 각자에서 빼준다.
		int i=0;
		for(Ingredient ig:stockCurrent.keySet()) {
			stockCurrent.replace(ig, stockCurrent.get(ig)-usedIngredientsValue[i]);
			i++;
		}
		ingredientMyStockSave(stockCurrent);
	}
}

