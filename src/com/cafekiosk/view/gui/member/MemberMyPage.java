package com.cafekiosk.view.gui.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.model.vo.Member;

public class MemberMyPage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4304809825585612002L;
	@SuppressWarnings("unused")
	private MemberSwitchPanel msp;
	private CafeMemberController cmc;
	
	@SuppressWarnings("unused")
	private Member m;
	
	private JLabel IdLabel;
	private JLabel nameLabel;
	private JLabel nicknameLabel;

	public MemberMyPage(MemberSwitchPanel msp) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				cmc = msp.getCmc();
				
				cmc.renewMemberInfo();
				System.out.println("��� ������ �ҷ��Խ��ϴ�.");
				renewTexts();
				System.out.println("���������� ��������");
			
			}
		});

		setSize(1000, 800);

		setLayout(null);
		this.msp = msp;

		// �ڷΰ���
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		back.setBounds(911, 15, 60, 50);
		add(back);

		// ȸ�����̵�
		IdLabel = new JLabel("");
		IdLabel.setBounds(339, 278, 322, 71);
		IdLabel.setForeground(Color.WHITE);
		IdLabel.setFont(new Font("����", Font.BOLD, 29));
		add(IdLabel);

		// ȸ�� �̸�
		nameLabel = new JLabel("");
		nameLabel.setBounds(339, 411, 322, 71);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("����", Font.BOLD, 29));
		add(nameLabel);

		// ȸ���г���
		nicknameLabel = new JLabel("");
		nicknameLabel.setBounds(339, 549, 322, 71);
		nicknameLabel.setForeground(Color.WHITE);
		nicknameLabel.setFont(new Font("����", Font.BOLD, 29));
		add(nicknameLabel);

		// ȸ���������� ��ư
		JLabel modifyBtn = new JLabel();
		modifyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mif");
			}
		});
		modifyBtn.setBounds(313, 682, 373, 87);
		add(modifyBtn);

		// ���ȭ�� �ֱ�
		JLabel myPageView = new JLabel("");
		
		myPageView.setIcon(new ImageIcon("./data/memberData/image/myPage/myPage.jpg"));
		myPageView.setBounds(0, 0, 1000, 800);
		add(myPageView);

		setVisible(true);
	}
	
	public void renewTexts() {
		Member m =cmc.memberInformation();
		
		IdLabel.setText(cmc.getId());
		nameLabel.setText(m.getName());
		nicknameLabel.setText(m.getNickname());
	}
}
