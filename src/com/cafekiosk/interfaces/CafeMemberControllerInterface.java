package com.cafekiosk.interfaces;

import java.util.ArrayList;
import java.util.TreeMap;

import com.cafekiosk.model.vo.Member;
import com.cafekiosk.model.vo.MenuItem;

public interface CafeMemberControllerInterface {
	
	//id와 nickname을 CafeDAO로 보냄. DAO에서는 이 값을 체크해서 아래의 메소드로 보내고, 그 값을 다시 view로 보냄
	//리턴 값이 0이면 기존 값들과 일치하지 않아 해당 id와 nickname으로 생성가능
	//1이면 id가 이미 존재하나 nickname은 중복X, 2이면 앞 상황의 반대, 3이면 둘다 중복
	int checkIDNickname(String id, String nickname);
	
	//위의 상황으로 체크후 멤버 등록. boolean값으로 성공여부 반환
	//경로("./memberData/memberList.dat")에 저장
	//TreeMap<String,Member>형태로 저장!
	boolean memberRegister(String name, String id, String pw, String nickname);
	
	//멤버 로그인, DAO에서 파일 확인후 일치하면 DAO에서 멤버받아와 컨트롤러에 변수화시키고, 성공여부 boolean값 반환
	boolean memberSignIn(String id, String pw);
	
	//멤버 정보 반환
	Member memberInformation();
	
	//멤버 정보 수정
	boolean memberInformationModify(String pw, String nickname);
	
	//멤버 주문 내역 저장/ ArrayList<TreeMap<MenuItem, Integer>>의 형태로 DAO에 전송
	//콘솔에 "손님의 주문이 완료되었습니다."출력
	boolean memberOrderHistorySave(TreeMap<MenuItem, Integer> orderCurrent);
	
	//멤버 주분 내역 불러오기
	ArrayList<TreeMap<MenuItem, Integer>> memberOrderHistoryLoad();
	
	//멤버 마일리지 반환
	int memberMileageLoad();
	
	//초기 가입시 레벨0(그린), 주문내역 참조하여 1회이상 구매 레벨1(골드), 12회이상 구매시 레벨2(플래티넘)
	String memberLevelLoad();
}
