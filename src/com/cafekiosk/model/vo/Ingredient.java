package com.cafekiosk.model.vo;

import java.io.Serializable;

public class Ingredient implements Serializable, Comparable<Ingredient>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5906389968417757675L;
	
	private String ingredientKind;
	private String ingredientName;
	private int ingredientPrice;
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String ingredientKind, String ingredientName, int ingredientPrice) {
		super();
		this.ingredientKind = ingredientKind;
		this.ingredientName = ingredientName;
		this.ingredientPrice = ingredientPrice;
	}

	public String getIngredientKind() {
		return ingredientKind;
	}

	public void setIngredientKind(String ingredientKind) {
		this.ingredientKind = ingredientKind;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public int getIngredientPrice() {
		return ingredientPrice;
	}

	public void setIngredientPrice(int ingredientPrice) {
		this.ingredientPrice = ingredientPrice;
	}

	@Override
	public String toString() {
		return "\nIngredient [ingredientKind=" + ingredientKind + ", ingredientName=" + ingredientName
				+ ", ingredientPrice=" + ingredientPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientKind == null) ? 0 : ingredientKind.hashCode());
		result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
		result = prime * result + ingredientPrice;
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
		Ingredient other = (Ingredient) obj;
		if (ingredientKind == null) {
			if (other.ingredientKind != null)
				return false;
		} else if (!ingredientKind.equals(other.ingredientKind))
			return false;
		if (ingredientName == null) {
			if (other.ingredientName != null)
				return false;
		} else if (!ingredientName.equals(other.ingredientName))
			return false;
		if (ingredientPrice != other.ingredientPrice)
			return false;
		return true;
	}

	@Override
	public int compareTo(Ingredient o) {
		int result=0;
		result=this.ingredientKind.compareTo(o.getIngredientKind());
		if(result==0) result=this.ingredientName.compareTo(o.getIngredientName());
		return result;
	}

	
}
