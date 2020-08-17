package com.cafekiosk.interfaces;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.model.vo.MenuItem;

public interface CafeOrderControllerInterface {
	//�޴� �����۵��� �ҷ�����. ���("./adminData/menuItems.dat") �ش� ������ ��� �޴��� ���� 0���� ������ �ִ�.
	//��� �� ������ �ʱ�ȭ���Ϸ� ����� ���̹Ƿ� �����ؼ��� �� ��!
	TreeMap<MenuItem, Integer> menuItemsLoad();

	//GUI���� �� �޴��� ���� �ľ��� �Ű������� �޾ƿ�. �� �޼ҵ忡�� �� ���� ������ �ҷ��� TreeMap<MenuItem,Integer>��
	//value�κ��� ������ ���� ��������.
	//CafeMemberController�� �ش� �� �޼ҵ��ȯ�Ͽ� order�� �־���
	TreeMap<MenuItem,Integer> menuItemsPurcahsed(ArrayList<Integer> menuNumbers) ;
}
