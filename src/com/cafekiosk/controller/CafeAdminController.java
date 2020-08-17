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
	//���α׷� ����/���� ������ Ŭ����
	private Scanner sc =new Scanner(System.in);
	
	private String[] ingredientKindArr = {"�ż���ǰ","Ŀ��","�����","��Ÿ��"};
	private String[] menuKindArr= {"Coffee", "Non-Coffee"};
	
	//Ʈ������ ���� �������� Ű�� �����ϱ� ������ ���� Ű���� ���� Ʈ������ ��𿡼��� ���� ���ļ����� �����ٰ� ������ �� �ִ�.
	private TreeMap<Ingredient,Double> ingMap=new TreeMap<Ingredient, Double>();
	private TreeMap<Ingredient,Double> recipeMap= new TreeMap<Ingredient, Double>();
	
	//OrderHistory�� ������ �� ����
	private TreeMap<MenuItem,Integer> menuItems=new TreeMap<MenuItem, Integer>();
	
	
	
	public CafeAdminController() {}
	
	//��� ���� �޾ƿͼ� ����Ʈ��
	public void printStock(TreeMap<Ingredient,Double> ingMap) {
		this.ingMap=ingMap;
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(ingMap.keySet());
		int i=1;
		System.out.println("===== ���� ��� ======");
		for(Ingredient v:tsKey) {
			System.out.println("**"+i+"�� ��� ====");
			System.out.println(v+"/ ��� : "+ingMap.get(v));
			i++;
		}
	}
	//��� ����� ����� 0������ �Ǿ��ִ� �ڷ� ��������
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
	//��� ���/��� ���� 0���� ����
	public boolean ingredientInitializer() {
		System.out.println("���� ������ �ҷ��ɴϴ�!");
		ingMap=ingredientZeroValueLoader();
		
		int i=1;
		try{
			i=ingMap.size()+1;
		}catch(Exception e) {
		}
		while(true) {
			System.out.println("======"+i+"��° ����� ���======");
			i++;
			System.out.println("�ż���ǰ(0), Ŀ��(1), �����(2), ��Ÿ��(3) �߿��� ���ÿ�");
			int index=sc.nextInt();
			System.out.println("��ǰ�� �̸��� �Է��Ͻÿ�.");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("��ǰ�� ������ �Է��Ͻÿ�.");
			int price=sc.nextInt();
			ingMap.put(new Ingredient(ingredientKindArr[index], name, price), 0.0);
	
			System.out.println("1�� ������ �����ϰ� ��� ��� ����");
			if(sc.next().equals("1")) break;
		}
		//���� ����
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
	//��� ����� ����� 0���� �Ǿ��ִ� �ڷḦ �� ���� ������ִ� �޼ҵ�
	public void ingredientZeroValueToMyStock() {
		ingMap=ingredientZeroValueLoader();
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/ingredientMyStock.dat"))){
			oos.writeObject(ingMap);
		}catch(IOException e) {
			e.printStackTrace();
		}
		printStock(ingMap);
	}
	
	//�� ��� ��� ���Ͽ��� �ҷ�����, �� ���� ����� Ʈ������ �����ϴ� �޼ҵ�
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
	//���ο� ��� ���� ���� �޾ƿ� �����ִ� ������ �������
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
	
	//���� �ֹ��� ��ġ�� �� ������ŭ �ش� ��� ��� �߰��Ǵ� �޼ҵ�
	public void ingredientMarketBought(double[] boughtNumbers) {
		ingMap=ingredientMyStockLoader();
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(ingMap.keySet());
		int i=0;
		for(Ingredient v:tsKey) {
			ingMap.replace(v, ingMap.get(v)+boughtNumbers[i]);
			i++;
		}
		boolean result=ingredientMyStockSave(ingMap);
		if(result) System.out.println("���������� ����!");
		else System.out.println("�������!");
	}
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
	//�޴� ������ ����Ʈ
	public void printMenuItems(TreeMap<MenuItem, Integer> menuItems) {
		for(MenuItem mi:new TreeSet<MenuItem>(menuItems.keySet())) {
			System.out.println(mi);
		}
	}
	
	//���� �޴� �����۵��� �ҷ����� �޼ҵ� 
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
	
	//�޴� �����۵��� loadMenuItems���� �ҷ��� �� ���� �����ϴ� �޼ҵ�
	public boolean saveMenuItems() {
		System.out.println("���� ������ �ҷ��ɴϴ�!");
		menuItems=loadMenuItems();
		int i=1;
		try{
			i=menuItems.size()+1;
		} catch(Exception e) {	
		}
		while(true) {
			System.out.println("======"+i+"��° ����� ��ǰ======");
			i++;
			System.out.println("Coffee(0), Non-Coffee(1)�߿��� ���ÿ�");
			int index=sc.nextInt();
			System.out.println("��ǰ�� �̸��� �Է��Ͻÿ�.");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("�����Ǹ� �Է��Ͻÿ�");
			recipeMap=recipeMaker();
			System.out.println("��ǰ�� ������ �Է��Ͻÿ�.");
			int price=sc.nextInt();
			menuItems.put(new MenuItem(menuKindArr[index], name, recipeMap, price), 0);
	
			System.out.println("1�� ������ �����ϰ� ��� ��� ����");
			if(sc.next().equals("1")) break;
		}
		
		//���� ����
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("./data/adminData/menuItems.dat"))){
			oos.writeObject(menuItems);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	//������ ������ִ� �޼ҵ�
	public TreeMap<Ingredient,Double> recipeMaker(){
		recipeMap=ingredientZeroValueLoader();
		Ingredient[] ingArr=new Ingredient[recipeMap.size()];
		while(true) {
			System.out.println("�ʿ��� ��� ��ȣ�� �Է��ϼ���");
			int i=0;
			for(Ingredient v:new TreeSet<Ingredient>(recipeMap.keySet())) {
				System.out.print(i+"�� "+v.getIngredientName()+" ");
				ingArr[i]=v;
				i++;
			}
			System.out.print(": ");
			int index=sc.nextInt();
			System.out.println("�ʿ��� "+ingArr[index].getIngredientName()+"�� ���� �Է��ϼ���.");
			double amount =sc.nextDouble();
			if(index<0||amount<0) {
				System.out.println("�߸��� �Է�! �ٽ� �Է��ϼ���."); continue;
			}
			recipeMap.put(ingArr[index],amount);
			System.out.println("��Ḧ �� �Է��Ͻðڽ��ϱ�? ��ġ�÷��� 1�� �����ּ���");
			if(sc.next().equals("1")) break;
		}
		
		printRecipe(recipeMap);
		
		return recipeMap;
	}
	
	//������ ����Ʈ���ִ� �޼ҵ�
	public void printRecipe(TreeMap<Ingredient,Double> recipeMap) {
		this.recipeMap=recipeMap;
		TreeSet<Ingredient> tsKey=new TreeSet<Ingredient>(recipeMap.keySet());
		int i=1;
		System.out.println("===== ������ ======");
		for(Ingredient v:tsKey) {
			System.out.println("**"+i+"�� ��� ====");
			System.out.println(v+"/ ���� : "+recipeMap.get(v));
			i++;
		}
	}
	//////////////////////////////////////////////////////
	//CafeOrderController�� ����Ǿ�, �ֹ��� �޾ƿ���, 
	//�� �޴��� ���� �����Ǹ� �� �޴��� ������ ���� ���� ��� ������
	
	public void renewStock(TreeMap<MenuItem, Integer> orderCurrent) {
		//���� ��� �ҷ�����
		TreeMap<Ingredient, Double> stockCurrent=ingredientMyStockLoader();
		//������ ��ᰡ ���� ���� �ջ��ϱ� ���� �迭 ����
		double[] usedIngredientsValue= new double[stockCurrent.size()];
		
		//1.���� �ֹ����� ������ �޴� �������� �̾Ƴ���, 2. �޴������۵鿡�� ������ �����Ǹ� �̾�. 
		//3.������ ��ᰡ ���� ���� ���� �迭�� �ִ´�.
		for(MenuItem mi : orderCurrent.keySet()) {
			int i=0;
			for(Ingredient ig : new TreeSet<Ingredient>(mi.getRecipe().keySet())) {
				usedIngredientsValue[i]+=mi.getRecipe().get(ig);
				i++;
			}
		}
		
		//stockCurrent�� ��� �ϳ��ϳ� ������ �ϰ� ���� �迭��ŭ ���ڿ��� ���ش�.
		int i=0;
		for(Ingredient ig:stockCurrent.keySet()) {
			stockCurrent.replace(ig, stockCurrent.get(ig)-usedIngredientsValue[i]);
			i++;
		}
		ingredientMyStockSave(stockCurrent);
	}
}

