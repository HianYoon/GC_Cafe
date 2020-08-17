package com.cafekiosk.controller;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import com.cafekiosk.interfaces.CafeMemberControllerInterface;
import com.cafekiosk.model.dao.CafeDAO;
import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public class CafeMemberController implements CafeMemberControllerInterface{
	//이 클래스에서 DAO의 멤버 정보를 불러올 경우, 한명의 멤버만 m에 동기화되기때문에, 
	//이 클래스의 객체가 같은 주소값을 참조한다는 가정 하에 이 클래스를 같은 멤버의 정보를 참조, 수정하는 컨트롤러로 사용가능하다.
	
	//오버라이드 된 메소드는 인터페이스 참조!
	private String id;
	private Member m=new Member();
	private CafeDAO dao = new CafeDAO();
	private String[] level= {"GREEN","GOLD","PLATINUM"};
	
	@Override
	public int checkIDNickname(String id, String nickname) {
		return dao.checkIDNickname(id, nickname);
	}
	@Override
	public boolean memberRegister(String name, String id, String pw, String nickname) {
		if(checkIDNickname(id, nickname)==1) return false;
		m=new Member(name, pw, nickname);
		boolean result = dao.memberRegister(id, m);
		m=null;
		return result;
	}
	
	@Override
	public boolean memberSignIn(String id, String pw) {
		this.id=id;
		m=dao.memberSignIn(id, pw);
		if(m == null ) {
			System.out.println("불일치");
			return false;
		}
		return true;
	}
	//로그인을 할때 이미 m이 동기화 되었다
	@Override
	public Member memberInformation() {
		return m;
	}
	
	public boolean renewMemberInfo() {
		m=dao.renewMemberInfo(id);
		if(m!=null) return true;
		else return false;
	}
	
	@Override
	public boolean memberInformationModify(String pw, String nickname) {
		m.setPw(pw); m.setNickname(nickname);
		Member modifiedMember=m;
		dao.memberInformationModify(id, modifiedMember);
		return true;
	}
	
	@Override
	public boolean memberOrderHistorySave(TreeMap<MenuItem,Integer> orderCurrent) {
		m.getOrderHistory().add(orderCurrent);
		int addedMileage=0;
		for(MenuItem mi: new TreeSet<MenuItem>(orderCurrent.keySet())) {
			addedMileage+=mi.getPrice()*orderCurrent.get(mi);
		}
		m.setMileage(m.getMileage()+(int)(0.1*addedMileage));
		dao.memberInformationModify(id, m);
		return true;
	}
	@Override
	public  ArrayList<TreeMap<MenuItem, Integer>> memberOrderHistoryLoad() {
		return m.getOrderHistory();
	}
	@Override
	public int memberMileageLoad() {
		return m.getMileage();
	}
	@Override
	public String memberLevelLoad() {
		int count = m.getOrderHistory().size();
		if(count==0) return level[0];
		else if(count>0 && count<12) return level[1];
		else return level[2];
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
