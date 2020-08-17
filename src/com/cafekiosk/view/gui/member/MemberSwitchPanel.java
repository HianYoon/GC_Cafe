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
	 * ��� �޴����� ��Ʈ���ϴ� ī�巹�̾ƿ� �г�
	 * �� ���� �޴����� �� Ŭ���� ��ü�� �ּҰ��� ����ȭ�Ͽ� membercards�� �����ؾ� �Ѵ�.
	 * �� ��������г��� MainFrame�� ��ü �ּҵ� ����ȭ�ؾ��ϴµ�, �̴� ���θ޴��� ���ư��� �ϱ� �����̴�
	 */
	private static final long serialVersionUID = 125555471238154502L;
	private MainFrame mainFrame;
	private CafeMemberController cmc;
	//���ȭ�鿡�� �� ��� �г��� �� �Ʒ��� ��üȭ�ϼ���
	
	private CardLayout memberCards = new CardLayout();
	
	private MemberMainPanel mmp = new MemberMainPanel();
	private MemberMyPage mypage = new MemberMyPage(this);
	private MemberInfoModify mif = new MemberInfoModify(this); //ȸ������ ���� ȭ��
	private ModifyOKCheck moc = new ModifyOKCheck(this); //ȸ���������� üũ�޼��� ȭ��
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
		//�׸��� ���⿡�� �Ʒ��� ���� ������� add���ּ���. ������ �� �г��� �ҷ��� �̸��Դϴ�.
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
		
		add("ma", ma); //��������
		add("t", t); //ī���� Ƽ
		add("cl", cl); //ī��� 
		add("ame", ame); //�Ƹ޸�ī��
		add("jv", jv); //�ڹ�Ĩ
		add("gp", gp); //����
		add("mb",mb);
		add("ol",ol);
		setVisible(true);
		
	}
	//�Ʒ��� ���ī�带 ���� �гο��� �޾� msp(�����г��� ��üȭ�� ������).getMemberCards.show(getParent(),"���ϴ� �г� �̸�");�� ������� �ҷ��ɴϴ�.
	public CardLayout getMemberCards() {
		return memberCards;
	}
	//�ʱ��� ���̵� ���� ���θ޴��� ���ư��� �� �� �ʿ��մϴ�. msp.getMainFrame().getMainCards(msp.getMainFrame().getContentPane(),"mainMenu");
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
