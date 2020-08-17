package com.cafekiosk.interfaces;

import java.util.TreeMap;

import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public interface CafeDAOInterface {
	
	int checkIDNickname(String id, String nickname);
	
	boolean memberRegister(String id,Member m);
	
	Member memberSignIn(String id, String pw);
	
	boolean memberInformationModify(String id, Member M);
	

	TreeMap<MenuItem, Integer> menuItemsLoad();
}
