package com.cafekiosk.view.gui.member;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.model.vo.Member;

public class MemberMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2951827911530832212L;

	private MemberSwitchPanel msp;
	
	private CafeMemberController cmc=new CafeMemberController();
	private JLabel memberView;
	private JLabel name;
	private JLabel Mileage;
	private JLabel reval;
	
	public MemberMainPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmc=msp.getCmc();
				
				if(cmc.renewMemberInfo())System.out.println("��� ������ �ҷ��Խ��ϴ�.");;
				renewTexts();
			}
		});
		
		
		// TODO Auto-generated constructor stub
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		JLabel menubar = new JLabel("");   //�޴���
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mb");
				
			}
		});
		menubar.setBounds(17, 8, 67, 39);
		add(menubar);
		
		
		JLabel back = new JLabel(""); //�ڷΰ���
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMainFrame().getMainCards().show(msp.getMainFrame().getContentPane(), "mainMenu");
			}
		});
		back.setBounds(923, 15, 60, 50);
		add(back);
		
		name = new JLabel();  //�̸�
		name.setForeground(Color.WHITE);
		name.setBounds(720, 110, 195, 39);
		name.setFont(new Font("����", Font.BOLD, 29));
		add(name);
		
		Mileage = new JLabel(); //���ϸ���
		Mileage.setForeground(Color.WHITE);
		Mileage.setBounds(721, 198, 195, 39);
		Mileage.setFont(new Font("����", Font.BOLD, 29));
		
		add(Mileage);
		 
		reval = new JLabel();  //����
		reval.setForeground(Color.WHITE);
		reval.setBounds(723, 285, 195, 39);
		reval.setFont(new Font("����", Font.BOLD, 29));
		add(reval);
		
		
		JLabel order = new JLabel(""); //�ֹ��ϱ�
		order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mc");
			}
		});
		order.setBounds(638, 403, 137, 121);
		add(order);
		
		JLabel menuIntroduce = new JLabel("");  //�޴��Ұ�
		menuIntroduce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mi");
				
			}
		});
		
		menuIntroduce.setBounds(792, 403, 137, 121);
		add(menuIntroduce);
		
		JLabel mypage = new JLabel(""); //����������
		mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mypage");
			}
		});
		
		mypage.setBounds(638, 550, 137, 121);
		add(mypage);
		
		JLabel event = new JLabel("");
		event.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "e");
				System.out.println("�̺�Ʈ");
			}
		});
		
		event.setBounds(791, 550, 137, 121);  //�̺�Ʈ
		add(event);
		
		
		
		JLabel game = new JLabel(""); //����
		game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "gp");
			}
		});
		game.setBounds(625, 678, 315, 44);
		add(game);
		
		
		
		
		
		memberView = new JLabel("");
		memberView.setForeground(Color.DARK_GRAY);
		memberView.setIcon(new ImageIcon("./data/memberData/image/memberMainView/memberHome.jpg"));
		memberView.setBounds(0, 0, 1000, 800);
		add(memberView);
		
				
		setVisible(true);
	}

	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}

	public CafeMemberController getCmc() {
		return cmc;
	}

	public void setCmc(CafeMemberController cmc) {
		this.cmc = cmc;
	}
	//�̸� ����
	public void renewTexts() {
		Member m =cmc.memberInformation();
		name.setText(m.getNickname());
		Mileage.setText(""+m.getMileage());
		reval.setText(cmc.memberLevelLoad());
	}
}