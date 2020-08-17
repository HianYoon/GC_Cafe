package com.cafekiosk.view.gui.member.menus;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class MenuIntroduce extends JPanel {  //메인화면에서 메뉴소개 해주는 창
	/**
	 * 
	 */
	private static final long serialVersionUID = 1041755640464395828L;
	private MemberSwitchPanel msp;

	public MenuIntroduce() {
		
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		JLabel btnNewButton = new JLabel();
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		btnNewButton.setBounds(927, 15, 73, 47);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./data/memberData/image/menuInfo/drinkmenu.jpg"
				+ ""));
		lblNewLabel.setBounds(0, 0, 1000, 800);
		add(lblNewLabel);
		
		//망고스무디
		JLabel mango = new JLabel("");
		mango.setBackground(Color.BLACK);
		mango.setForeground(Color.BLACK);
		mango.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "ma");
			}
		});
		mango.setBounds(49, 46, 401, 271);
		add(mango);
		
		//카모마일 티
		JLabel tea = new JLabel("");
		tea.setBackground(Color.BLACK);
		tea.setForeground(Color.BLACK);
		tea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "t");
			}
		});
		tea.setBounds(509, 46, 401, 271);
		add(tea);
		
		//카페라떼
		JLabel caffeLatte = new JLabel("");
		caffeLatte.setBackground(Color.BLACK);
		caffeLatte.setForeground(Color.BLACK);
		caffeLatte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "cl");
			}
		});
		caffeLatte.setBounds(0, 514, 283, 286);
		add(caffeLatte);
		
		//아메리카노
		JLabel americano = new JLabel("");
		americano.setBackground(Color.BLACK);
		americano.setForeground(Color.BLACK);
		americano.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "ame");
			}
		});
		americano.setBounds(301, 514, 283, 286);
		add(americano);
		
		//자바칩 프라프치노
		JLabel javachip = new JLabel("");
		javachip.setBackground(Color.BLACK);
		javachip.setForeground(Color.BLACK);
		javachip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "jv");
			}
		});
		javachip.setBounds(676, 514, 283, 286);
		add(javachip);
		
		setVisible(true);
	}
	
	
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
}
