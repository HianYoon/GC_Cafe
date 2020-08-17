package com.cafekiosk.view.member.msg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.member.MemberSwitchPanel;

public class CheckMsgOrder extends JPanel {

	private MemberSwitchPanel msp;
	/**
	 * 
	 */
	
	//주문완료메세지 띠우는 클래스
	//새로만듬
	
	private static final long serialVersionUID = 4250856241148157186L;

	
	public CheckMsgOrder() {
	
		setSize(1000,800);
		setLayout(null);
		
		JLabel checkBtn = new JLabel("");
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				msp.getMemberCards().show(msp, "mmp");
				
			}
		});
		checkBtn.setBounds(487, 339, 288, 189);
		add(checkBtn);
		
		JLabel backImage = new JLabel("");
		backImage.setIcon(new ImageIcon("./data/memberData/image/cart/orderSuccess.jpg"));
		backImage.setBounds(0, 0, 1000, 800);
		add(backImage);
		
		
		setVisible(true);
	}
	
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
}
