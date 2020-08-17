package com.cafekiosk.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.cafekiosk.interfaces.CafeDAOInterface;
import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public class CafeDAO implements CafeDAOInterface{
	private TreeMap<String,Member> memberAll=new TreeMap<String,Member>();
	private Member m = new Member();
	private TreeMap<MenuItem, Integer> order;
	///////////////////////////////////////////////
	//초기 memberList.dat생성용
	public boolean memberListCreate() {
		m=new Member("윤병현", "1111", "전설의공익");
		memberAll.put("mightymosses", m);
		modifiedMemberAllSave(memberAll);
		return true;
	}
	///////////////////////////////////////////////////////
	//모든 멤버의 리스트를 불러오는 메소드
	@SuppressWarnings("unchecked")
	public TreeMap<String,Member> loadMemberAll(){
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/memberData/memberList.dat"))){
			
			memberAll = (TreeMap<String, Member>) ois.readObject();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberAll;
	}
	//아이디를 체크하는 메소드
	@Override
	public int checkIDNickname(String id, String nickname) {
		loadMemberAll();
		
		for(String v:memberAll.keySet()) {
			if(v.equals(id)) return 1;
		}
		return 0;
	}
	
	@Override
	public boolean memberRegister(String id, Member m) {
		loadMemberAll();
		memberAll.put(id, m);
		return modifiedMemberAllSave(memberAll);

	}
	
	public boolean modifiedMemberAllSave(TreeMap<String,Member> modifiedMemberAll) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/memberData/memberList.dat"))){
			oos.writeObject(modifiedMemberAll);
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public Member memberSignIn(String id, String pw) {
		loadMemberAll();
		if(memberAll.containsKey(id)) {
			Member temp=memberAll.get(id);
			if(temp.getPw().equals(pw)){
				m = temp;
				return m;
			}
		}
		return null;
	}


	@Override
	public boolean memberInformationModify(String id, Member modifiedMember) {
		loadMemberAll();
		memberAll.replace(id, modifiedMember);
		return modifiedMemberAllSave(memberAll);
	}
	
	
	
//////////////////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	@Override
	public TreeMap<MenuItem, Integer> menuItemsLoad() {
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("./data/adminData/menuItems.dat"))){
			order=(TreeMap<MenuItem, Integer>)ois.readObject();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
		}
		return order;
	}
////////////////////유다해 고침
	public Member renewMemberInfo(String id) {
		loadMemberAll();
		if(memberAll.containsKey(id)) {
		return memberAll.get(id);
		
		}
		return null;
	}

}
