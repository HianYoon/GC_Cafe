package com.cafekiosk.view.gui.member.menus;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class Tea extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 114114432199631322L;
	private MemberSwitchPanel msp;
	
	
	public Tea() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		setVisible(false);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mi");
			}
		});
		back.setBounds(912, 0, 88, 83);
		add(back);
		
		JLabel teaView = new JLabel("");
		teaView.setIcon(new ImageIcon("./data/memberData/image/menuInfo/tea.jpg"));
		teaView.setBounds(0, 0, 1000, 800);
		add(teaView);
	}
	
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}

}
