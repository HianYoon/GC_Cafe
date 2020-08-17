package com.cafekiosk.interfaces;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public interface CafeMemberControllerInterface {
	
	//id�� nickname�� CafeDAO�� ����. DAO������ �� ���� üũ�ؼ� �Ʒ��� �޼ҵ�� ������, �� ���� �ٽ� view�� ����
	//���� ���� 0�̸� ���� ����� ��ġ���� �ʾ� �ش� id�� nickname���� ��������
	//1�̸� id�� �̹� �����ϳ� nickname�� �ߺ�X, 2�̸� �� ��Ȳ�� �ݴ�, 3�̸� �Ѵ� �ߺ�
	int checkIDNickname(String id, String nickname);
	
	//���� ��Ȳ���� üũ�� ��� ���. boolean������ �������� ��ȯ
	//���("./memberData/memberList.dat")�� ����
	//TreeMap<String,Member>���·� ����!
	boolean memberRegister(String name, String id, String pw, String nickname);
	
	//��� �α���, DAO���� ���� Ȯ���� ��ġ�ϸ� DAO���� ����޾ƿ� ��Ʈ�ѷ��� ����ȭ��Ű��, �������� boolean�� ��ȯ
	boolean memberSignIn(String id, String pw);
	
	//��� ���� ��ȯ
	Member memberInformation();
	
	//��� ���� ����
	boolean memberInformationModify(String pw, String nickname);
	
	//��� �ֹ� ���� ����/ ArrayList<TreeMap<MenuItem, Integer>>�� ���·� DAO�� ����
	//�ֿܼ� "�մ��� �ֹ��� �Ϸ�Ǿ����ϴ�."���
	boolean memberOrderHistorySave(TreeMap<MenuItem, Integer> orderCurrent);
	
	//��� �ֺ� ���� �ҷ�����
	ArrayList<TreeMap<MenuItem, Integer>> memberOrderHistoryLoad();
	
	//��� ���ϸ��� ��ȯ
	int memberMileageLoad();
	
	//�ʱ� ���Խ� ����0(�׸�), �ֹ����� �����Ͽ� 1ȸ�̻� ���� ����1(���), 12ȸ�̻� ���Ž� ����2(�÷�Ƽ��)
	String memberLevelLoad();
}
