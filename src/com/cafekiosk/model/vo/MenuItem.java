package com.cafekiosk.model.vo;

import java.io.Serializable;
import java.util.TreeMap;
//메뉴아이템들은 객체로서 TreeMap의 키가 되기 때문에 컴페어러블로 TreeMap이 sort할 수 있게 해주어야 한다.
public class MenuItem implements Serializable,Comparable<MenuItem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6068476453348083878L;
	
	private String kind;
	private String menuName;
	private TreeMap<Ingredient, Double> recipe=new TreeMap<Ingredient, Double>();
	private int price;
	
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public MenuItem(String kind, String menuName, TreeMap<Ingredient, Double> recipe, int price) {
		super();
		this.kind = kind;
		this.menuName = menuName;
		this.recipe = recipe;
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public TreeMap<Ingredient, Double> getRecipe() {
		return recipe;
	}

	public void setRecipe(TreeMap<Ingredient, Double> recipe) {
		this.recipe = recipe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [kind=" + kind + ", menuName=" + menuName + ", recipe=" + recipe + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + price;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (price != other.price)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}

	@Override
	public int compareTo(MenuItem o) {
		int result=this.kind.compareTo(o.getKind());
		if(result==0) result=this.menuName.compareTo(o.getMenuName());
		return result;
	}
}
	