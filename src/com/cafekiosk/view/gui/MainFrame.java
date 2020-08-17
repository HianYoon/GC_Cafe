package com.cafekiosk.view.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.view.gui.admin.AdminSwitchPanel;
import com.cafekiosk.view.gui.member.JoinMember;
import com.cafekiosk.view.gui.member.MemberSwitchPanel;
import com.cafekiosk.view.gui.music.Music;
import com.cafekiosk.view.member.msg.CheckIdAlready;
import com.cafekiosk.view.member.msg.CheckMsgId;
import com.cafekiosk.view.member.msg.CongratulationRegister;
import java.awt.Toolkit;


public class MainFrame extends JFrame {
	/**
	 * 메인 프레임. 메인에서 이 프레임이 바로 실행되며 첫번째로 실행되는 카드레이아웃이다.
	 * 이곳에서 메인메뉴, 어드민 메뉴, 멤버 메뉴, 회원 가입이 카드로 추가되어 있다.
	 * mainCards를 불러와 각 카드에서 다른 카드를 불러오게 하여야 하므로 각 카드에는 이 클래스 객체의 주소를 동일하게 가지고 있어야 한다.
	 * 스레딩을 통해서 음악을 실행시켰다.
	 */
	private static final long serialVersionUID = -4953416208548913944L;

	private CardLayout mainCards=new CardLayout();
	
	private CafeMemberController cmc=new CafeMemberController();
	
	private MainMenu mainMenu= new MainMenu();
	private AdminSwitchPanel asp= new AdminSwitchPanel();
	private MemberSwitchPanel msp=new MemberSwitchPanel();
	
	private CheckMsgId cms = new CheckMsgId(this); //아이디 사용가능  메세지 화면
	private CheckIdAlready cia = new CheckIdAlready(this); //아이디 사용불가메세지 화면
	private CongratulationRegister cr = new CongratulationRegister(this); // 회원가입축하화면
	private JoinMember jm = new JoinMember(this);
	
	{
		mainMenu.setCmc(cmc);
		msp.setCmc(cmc);
		mainMenu.setMainFrame(this);
		asp.setMainFrame(this);
		msp.setMainFrame(this);
	}
	
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./data/icon.jpg"));
		setTitle("CAFE_G&C");
		setResizable(false);
		
	setSize(1006, 829);
	
			
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	getContentPane().setLayout(mainCards);
	
	getContentPane().add("mainMenu",mainMenu);
	getContentPane().add("asp",asp);
	getContentPane().add("msp",msp);
	getContentPane().add("cms",cms);
	getContentPane().add("cia",cia);
	getContentPane().add("cr",cr);
	getContentPane().add("jm",jm);
	
	
	//자바줌의 플러그인을 통해서 음악을 실행시킴. 스레딩.
	Music introMusic = new Music("kapustinPianoConcerto2mov2.mp3", true);
	introMusic.start();
	
	
	setVisible(true);
	}
	
	
	public CardLayout getMainCards() {
		return mainCards;
	}


	public MemberSwitchPanel getMsp() {
		return msp;
	}
}
