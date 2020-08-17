package com.cafekiosk.interfaces;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.model.vo.MenuItem;

public interface CafeOrderControllerInterface {
	//메뉴 아이템들을 불러오기. 경로("./adminData/menuItems.dat") 해당 파일의 모든 메뉴는 값이 0으로 맞춰져 있다.
	//계속 이 파일을 초기화파일로 사용할 것이므로 수정해서는 안 됨!
	TreeMap<MenuItem, Integer> menuItemsLoad();

	//GUI에서 각 메뉴의 수량 파악후 매개변수로 받아옴. 이 메소드에서 그 값을 위에서 불러온 TreeMap<MenuItem,Integer>의
	//value부분을 수정해 수량 수정해줌.
	//CafeMemberController로 해당 이 메소드반환하여 order로 넣어줌
	TreeMap<MenuItem,Integer> menuItemsPurcahsed(ArrayList<Integer> menuNumbers) ;
}
