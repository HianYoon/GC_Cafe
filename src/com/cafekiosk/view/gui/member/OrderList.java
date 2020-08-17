package com.cafekiosk.view.gui.member;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4459676700111550322L;
	private MemberSwitchPanel msp;

	public OrderList() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		JLabel close = new JLabel(""); //´Ý±â¹öÆ°
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		close.setBounds(918, 15, 65, 39);
		add(close);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./data/memberData/image/menuInfo/wait.jpg"));
		lblNewLabel.setBounds(0, 0, 1000, 800);
		add(lblNewLabel);
		setVisible(true);


		
		
		
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}

}
