package com.cafekiosk.controller;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.interfaces.CafeOrderControllerInterface;
import com.cafekiosk.model.dao.CafeDAO;
import com.cafekiosk.model.vo.MenuItem;

public class CafeOrderController implements CafeOrderControllerInterface{

	private TreeMap<MenuItem, Integer> orderZero;
	private CafeDAO dao=new CafeDAO();
	
	//메뉴 아이템들의 목록을 받아옴.->각 밸류는 0으로 맞춰져 있어 장바구니, 이후에는 주문 내역으로 활용
	@Override
	public TreeMap<MenuItem, Integer> menuItemsLoad() {
		orderZero=dao.menuItemsLoad();
		return orderZero;
	}
	
	
	//GUI에서 orderCurrent를 받아서 CafeMemberController의 memberOderHistorySave로 보내준다.
	//이 메소드에서는 CafeAdminController에 새로운 주문 수량을 전달하고, 거기서 새로운 재고량을 계산한다.
	@Override
	public TreeMap<MenuItem,Integer> menuItemsPurcahsed(ArrayList<Integer> menuNumbers) {
		TreeMap<MenuItem, Integer> orderCurrent=menuItemsLoad();
		int i=0;
		for(MenuItem mi:orderCurrent.keySet()) {
			orderCurrent.replace(mi, menuNumbers.get(i));
			i++;
		}
		new CafeAdminController().renewStock(orderCurrent);
		return orderCurrent;
	}
}
