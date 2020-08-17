package com.cafekiosk.view.gui.member;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	
	private static final long serialVersionUID = 2989632161598495443L;
	/**
	 * 
	 */
	
	private MemberSwitchPanel msp;


	public MenuBar() {
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		JLabel home = new JLabel("");//홈화면으로
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				msp.getMemberCards().show(msp, "mmp");
				
			}
		});
		home.setBounds(33, 98, 378, 83);
		add(home);
		
		JLabel event = new JLabel(""); //이벤트
		event.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "e");
			}
		});
		event.setBounds(33, 201, 378, 83);
		add(event);
		
		JLabel orderlist = new JLabel(""); //주문내역
		orderlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "ol");
				
			}
		});
		orderlist.setBounds(33, 302, 378, 83);
		add(orderlist);
		
		JLabel menuview = new JLabel(""); //메뉴소개
		menuview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mi");
			}
		});
		menuview.setBounds(33, 407, 378, 83);
		add(menuview);
		
		JLabel close = new JLabel(""); ///닫기
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		close.setBounds(384, 15, 38, 31);
		add(close);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./data/memberData/image/memberMainView/sideMenuBarDemo.jpg"));
		lblNewLabel.setBounds(0, 0, 1000, 800);
		add(lblNewLabel);
		
		setVisible(true);
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}

}
