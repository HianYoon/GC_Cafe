package com.cafekiosk.view.gui.member;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.view.gui.MainFrame;
import com.cafekiosk.view.gui.member.menus.Americano;
import com.cafekiosk.view.gui.member.menus.CaffeLatte;
import com.cafekiosk.view.gui.member.menus.Javachip;
import com.cafekiosk.view.gui.member.menus.Mango;
import com.cafekiosk.view.gui.member.menus.MenuIntroduce;
import com.cafekiosk.view.gui.member.menus.Tea;
import com.cafekiosk.view.member.msg.CheckMsgOrder;
import com.cafekiosk.view.member.msg.ModifyOKCheck;

public class MemberSwitchPanel extends JPanel {
	/*
	 * 멤버 메뉴들을 컨트롤하는 카드레이아웃 패널
	 * 각 하위 메뉴들은 이 클래스 객체의 주소값을 동기화하여 membercards에 접근해야 한다.
	 * 단 멤버메인패널은 MainFrame의 객체 주소도 동기화해야하는데, 이는 메인메뉴로 돌아가야 하기 때문이다
	 */
	private static final long serialVersionUID = 125555471238154502L;
	private MainFrame mainFrame;
	private CafeMemberController cmc;
	//멤버화면에서 쓸 모든 패널을 이 아래에 객체화하세요
	
	private CardLayout memberCards = new CardLayout();
	
	private MemberMainPanel mmp = new MemberMainPanel();
	private MemberMyPage mypage = new MemberMyPage(this);
	private MemberInfoModify mif = new MemberInfoModify(this); //회원정보 수정 화면
	private ModifyOKCheck moc = new ModifyOKCheck(this); //회원정보수정 체크메세지 화면
	private MenuIntroduce mi=new MenuIntroduce();
	private CheckMsgOrder cmo = new CheckMsgOrder();
	
	private Event e =new Event();
	private Order o=new Order(this);
	private MenuChoice mc=new MenuChoice();
	@SuppressWarnings("unused")
	private MemberSwitchPanel msp=this;
	
	private Mango ma = new Mango();
	private Tea t = new Tea();
	private CaffeLatte cl = new CaffeLatte();
	private Americano ame = new Americano();
	private Javachip jv = new Javachip();
	private Gamepage gp = new Gamepage();
	
	private MenuBar mb=new MenuBar();
	private OrderList ol=new OrderList();
	{
		mmp.setMsp(this);
		mi.setMsp(this);
		e.setMsp(this);
		mc.setMsp(this);
		mc.setO(o);
		mc.setCmc(cmc);
		cmo.setMsp(this);
		
		
		ma.setMsp(this);
		t.setMsp(this);
		cl.setMsp(this);
		ame.setMsp(this);
		jv.setMsp(this);
		gp.setMsp(this);
		
		mb.setMsp(this);
		ol.setMsp(this);
	}
	
	
	

	public MemberSwitchPanel() {
		
		setBounds(0, 0, 1000, 800);
		
		setLayout(memberCards);
		//그리고 여기에서 아래와 같은 양식으로 add해주세요. 왼쪽은 각 패널을 불러올 이름입니다.
		//
		add("mmp",mmp);
		add("mypage",mypage);
		add("mif",mif);
		add("moc",moc);
		add("mi",mi);
		add("e",e);
		add("mc",mc);
		add("o",o);
		
		add("cmo",cmo);
		
		add("ma", ma); //망고스무디
		add("t", t); //카모마일 티
		add("cl", cl); //카페라떼 
		add("ame", ame); //아메리카노
		add("jv", jv); //자바칩
		add("gp", gp); //게임
		add("mb",mb);
		add("ol",ol);
		setVisible(true);
		
	}
	//아래의 멤버카드를 각자 패널에서 받아 msp(여기패널을 객체화한 변수명).getMemberCards.show(getParent(),"원하는 패널 이름");의 방식으로 불러옵니다.
	public CardLayout getMemberCards() {
		return memberCards;
	}
	//초기의 아이디 적는 메인메뉴로 돌아가야 할 때 필요합니다. msp.getMainFrame().getMainCards(msp.getMainFrame().getContentPane(),"mainMenu");
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public MenuChoice getMc() {
		return mc;
	}
	
	public void setCmc(CafeMemberController cmc) {
		this.cmc = cmc;
	}
	public CafeMemberController getCmc() {
		return cmc;
	}
	public Order getO() {
		return o;
	}
	public MemberMainPanel getMmp() {
		return mmp;
	}
	
}
