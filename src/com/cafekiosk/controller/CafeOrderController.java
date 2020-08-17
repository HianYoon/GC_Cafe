package com.cafekiosk.controller;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.interfaces.CafeOrderControllerInterface;
import com.cafekiosk.model.dao.CafeDAO;
import com.cafekiosk.model.vo.MenuItem;

public class CafeOrderController implements CafeOrderControllerInterface{

	private TreeMap<MenuItem, Integer> orderZero;
	private CafeDAO dao=new CafeDAO();
	
	//�޴� �����۵��� ����� �޾ƿ�.->�� ����� 0���� ������ �־� ��ٱ���, ���Ŀ��� �ֹ� �������� Ȱ��
	@Override
	public TreeMap<MenuItem, Integer> menuItemsLoad() {
		orderZero=dao.menuItemsLoad();
		return orderZero;
	}
	
	
	//GUI���� orderCurrent�� �޾Ƽ� CafeMemberController�� memberOderHistorySave�� �����ش�.
	//�� �޼ҵ忡���� CafeAdminController�� ���ο� �ֹ� ������ �����ϰ�, �ű⼭ ���ο� ����� ����Ѵ�.
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
