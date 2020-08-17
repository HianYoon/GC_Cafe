package com.cafekiosk.view.gui.member.menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class CaffeLatte extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7196812097146083390L;
	private MemberSwitchPanel msp;
	
	
	public CaffeLatte() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		setVisible(true);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mi"); //MenuIntroduce·Î °¡±â
			}
		});
		back.setBounds(912, 0, 88, 83);
		add(back);
		
		JLabel clView = new JLabel("");
		clView.setIcon(new ImageIcon("./data/memberData/image/menuInfo/cafeLatte.jpg"));
		clView.setBounds(0, 0, 1000, 800);
		add(clView);
	}
	
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	

}
