package com.cafekiosk.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6647358339558674097L;
	
	private String name;
	private String pw;
	private String nickname;
	private int mileage=2000;
	//널 포인터 에러가 뜨지 않도록 ArrayList를 생성해주었다.
	private ArrayList<TreeMap<MenuItem,Integer>> orderHistory=new ArrayList<TreeMap<MenuItem,Integer>>();
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, String pw, String nickname) {
		super();
		this.name = name;
		this.pw = pw;
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public ArrayList<TreeMap<MenuItem, Integer>> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(ArrayList<TreeMap<MenuItem, Integer>> orderHistory) {
		this.orderHistory = orderHistory;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", pw=" + pw + ", nickname=" + nickname + ", mileage=" + mileage
				+ ", orderHistory=" + orderHistory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

	
	
}
