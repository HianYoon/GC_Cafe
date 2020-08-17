package com.cafekiosk.view.gui.member.menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class Javachip extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5306016898948915440L;
	private MemberSwitchPanel msp;
	
	
	public Javachip() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		setVisible(false);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mi"); //MenuIntroduce�� ����
			}
		});
		back.setBounds(912, 0, 88, 83);
		add(back);
		
		JLabel javaView = new JLabel("");
		javaView.setIcon(new ImageIcon("./data/memberData/image/menuInfo/javachip.jpg"));
		javaView.setBounds(0, 0, 1000, 800);
		add(javaView);
		
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	

}