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

		// �ڷΰ���
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mypage");
			}
		});
		back.setBounds(911, 15, 60, 50);
		add(back);

		// ��й�ȣ ����
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setForeground(Color.WHITE);
		passwordTextField.setFont(new Font("����", Font.PLAIN, 25));
		passwordTextField.setBounds(339, 278, 322, 71);
		passwordTextField.setOpaque(false);
		passwordTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordTextField);

		// ��й�ȣ Ȯ��
		passwordCheckTextField = new JPasswordField();
		passwordCheckTextField.setForeground(Color.WHITE);
		passwordCheckTextField.setFont(new Font("����", Font.PLAIN, 25));
		passwordCheckTextField.setBounds(339, 411, 322, 71);
		passwordCheckTextField.setOpaque(false);
		passwordCheckTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordCheckTextField);

		// �г��� ����
		nicknameTextField = new JTextField();
		nicknameTextField.setForeground(Color.WHITE);
		nicknameTextField.setFont(new Font("����", Font.PLAIN, 25));
		nicknameTextField.setBounds(339, 549, 322, 71);
		nicknameTextField.setOpaque(false);
		nicknameTextField.setBorder(BorderFactory.createEmptyBorder());
		add(nicknameTextField);

		// �����ϱ� ��ư
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

		// ���ȭ�� �ֱ�
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
