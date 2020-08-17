package com.cafekiosk.view.member.msg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.view.gui.member.MemberSwitchPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ModifyOKCheck extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3143035988780964684L;
	@SuppressWarnings("unused")
	private MemberSwitchPanel msp;
	@SuppressWarnings("unused")
	private CafeMemberController cmc;
	public ModifyOKCheck(MemberSwitchPanel msp) {
		this.msp = msp;
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmc = msp.getCmc();
			}
		});
		
		setSize(1000, 800);
		setLayout(null);

		// 뒤로가기
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mif");
			}
		});
		back.setBounds(911, 15, 60, 50);
		add(back);

		
		JLabel ModifyOkBtn = new JLabel();
		ModifyOkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mypage");
			}
		});
		ModifyOkBtn.setBounds(462, 465, 100, 44);
		add(ModifyOkBtn);

		
		JLabel cancleBtn = new JLabel();
		cancleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mif");
			}
		});
		cancleBtn.setBounds(598, 465, 100, 44);
		add(cancleBtn);
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon("./data/memberData/image/modify/modifySuccess.jpg"));
		Image.setBounds(0, 0, 1000, 800);
		add(Image);
		setVisible(true);
	}
}
