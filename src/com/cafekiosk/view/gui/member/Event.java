package com.cafekiosk.view.gui.member;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Event extends JPanel {  // 메인화면에서 이벤트 보여쥬는 화면
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -223514687807440977L;
	private MemberSwitchPanel msp;
	
	public Event() {
		
		setBounds(0, 0, 1000,800);
		setLayout(null);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		
		back.setBounds(865, 0, 135, 73);
		add(back);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1000, 800);
		background.setIcon(new ImageIcon("./data/memberData/image/whatsNew/whatsnew.jpg"));
		add(background);
		
		setVisible(true);
		
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
}
