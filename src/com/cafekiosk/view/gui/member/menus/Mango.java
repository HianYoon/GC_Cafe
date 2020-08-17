package com.cafekiosk.view.gui.member.menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class Mango extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7477380842735646610L;
	private MemberSwitchPanel msp;

	
	public Mango() {
		
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
		
		JLabel mangoView = new JLabel("");
		mangoView.setIcon(new ImageIcon("./data/memberData/image/menuInfo/mango.jpg"));
		mangoView.setBounds(0, 0, 1000, 800);
		add(mangoView);

	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	
}
