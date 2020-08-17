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
	 * ���� ������. ���ο��� �� �������� �ٷ� ����Ǹ� ù��°�� ����Ǵ� ī�巹�̾ƿ��̴�.
	 * �̰����� ���θ޴�, ���� �޴�, ��� �޴�, ȸ�� ������ ī��� �߰��Ǿ� �ִ�.
	 * mainCards�� �ҷ��� �� ī�忡�� �ٸ� ī�带 �ҷ����� �Ͽ��� �ϹǷ� �� ī�忡�� �� Ŭ���� ��ü�� �ּҸ� �����ϰ� ������ �־�� �Ѵ�.
	 * �������� ���ؼ� ������ ������״�.
	 */
	private static final long serialVersionUID = -4953416208548913944L;

	private CardLayout mainCards=new CardLayout();
	
	private CafeMemberController cmc=new CafeMemberController();
	
	private MainMenu mainMenu= new MainMenu();
	private AdminSwitchPanel asp= new AdminSwitchPanel();
	private MemberSwitchPanel msp=new MemberSwitchPanel();
	
	private CheckMsgId cms = new CheckMsgId(this); //���̵� ��밡��  �޼��� ȭ��
	private CheckIdAlready cia = new CheckIdAlready(this); //���̵� ���Ұ��޼��� ȭ��
	private CongratulationRegister cr = new CongratulationRegister(this); // ȸ����������ȭ��
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
	
	
	//�ڹ����� �÷������� ���ؼ� ������ �����Ŵ. ������.
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
