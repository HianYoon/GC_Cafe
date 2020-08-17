package com.cafekiosk.view.gui.member;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gamepage extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -862151065698961801L;
	private MemberSwitchPanel msp;
	
	public Gamepage() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		setVisible(true);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		back.setBounds(912, 0, 88, 83);
		add(back);
		
		JLabel gameView = new JLabel("");
		gameView.setIcon(new ImageIcon("./data/memberData/image/memberMainView/ing.jpg"));
		gameView.setBounds(0, 0, 1000, 800);
		add(gameView);
		
	}
	
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}

}
