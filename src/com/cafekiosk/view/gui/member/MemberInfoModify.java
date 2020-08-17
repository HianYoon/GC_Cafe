package com.cafekiosk.view.gui.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.model.vo.Member;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPasswordField;

public class MemberInfoModify extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5777398220142215223L;
	@SuppressWarnings("unused")
	private MemberSwitchPanel msp;
	private CafeMemberController cmc;
	
	private JPasswordField passwordCheckTextField;
	private JTextField nicknameTextField;

	public MemberInfoModify(MemberSwitchPanel msp) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmc = msp.getCmc();
				renewTexts();
			}
		});
		this.msp=msp;

		setSize(1000, 800);

		setLayout(null);

		// 뒤로가기
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mypage");
			}
		});
		back.setBounds(911, 15, 60, 50);
		add(back);

		// 비밀번호 수정
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setForeground(Color.WHITE);
		passwordTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordTextField.setBounds(339, 278, 322, 71);
		passwordTextField.setOpaque(false);
		passwordTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordTextField);

		// 비밀번호 확인
		passwordCheckTextField = new JPasswordField();
		passwordCheckTextField.setForeground(Color.WHITE);
		passwordCheckTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordCheckTextField.setBounds(339, 411, 322, 71);
		passwordCheckTextField.setOpaque(false);
		passwordCheckTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordCheckTextField);

		// 닉네임 수정
		nicknameTextField = new JTextField();
		nicknameTextField.setForeground(Color.WHITE);
		nicknameTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		nicknameTextField.setBounds(339, 549, 322, 71);
		nicknameTextField.setOpaque(false);
		nicknameTextField.setBorder(BorderFactory.createEmptyBorder());
		add(nicknameTextField);

		// 수정하기 버튼
		JLabel modifyOkBtn = new JLabel();
		modifyOkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("deprecation")
				boolean result = cmc.memberInformationModify(passwordTextField.getText(), nicknameTextField.getText());
				if(result == true) {
					msp.getMemberCards().show(msp, "moc");
				}
			}
		});
		modifyOkBtn.setBounds(313, 682, 373, 87);
		add(modifyOkBtn);

		// 배경화면 넣기
		JLabel memberMofidyView = new JLabel("");
		memberMofidyView.setIcon(new ImageIcon("./data/memberData/image/modify/memberModifyFoam.jpg"));
		memberMofidyView.setBounds(0, 0, 1000, 800);
		add(memberMofidyView);
		setVisible(true);
	}
	public void renewTexts() {
		Member m =cmc.memberInformation();
		nicknameTextField.setText(m.getNickname());
		
	}
}
