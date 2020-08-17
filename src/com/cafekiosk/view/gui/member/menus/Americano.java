package com.cafekiosk.view.gui.member.menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class Americano extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4098499410088578087L;
	private MemberSwitchPanel msp;
	
	public Americano() {
		
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
		
		JLabel ameView = new JLabel("");
		ameView.setIcon(new ImageIcon("./data/memberData/image/menuInfo/americano.jpg"));
		ameView.setBounds(0, 0, 1000, 800);
		add(ameView);
		
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	

}
