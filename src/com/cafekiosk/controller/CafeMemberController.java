package com.cafekiosk.controller;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import com.cafekiosk.interfaces.CafeMemberControllerInterface;
import com.cafekiosk.model.dao.CafeDAO;
import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public class CafeMemberController implements CafeMemberControllerInterface{
	//�� Ŭ�������� DAO�� ��� ������ �ҷ��� ���, �Ѹ��� ����� m�� ����ȭ�Ǳ⶧����, 
	//�� Ŭ������ ��ü�� ���� �ּҰ��� �����Ѵٴ� ���� �Ͽ� �� Ŭ������ ���� ����� ������ ����, �����ϴ� ��Ʈ�ѷ��� ��밡���ϴ�.
	
	//�������̵� �� �޼ҵ�� �������̽� ����!
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
			System.out.println("����ġ");
			return false;
		}
		return true;
	}
	//�α����� �Ҷ� �̹� m�� ����ȭ �Ǿ���
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
