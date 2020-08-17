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
				System.out.println("멤버 정보를 불러왔습니다.");
				renewTexts();
				System.out.println("마이페이지 리프레쉬");
			
			}
		});

		setSize(1000, 800);

		setLayout(null);
		this.msp = msp;

		// 뒤로가기
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		back.setBounds(911, 15, 60, 50);
		add(back);

		// 회원아이디
		IdLabel = new JLabel("");
		IdLabel.setBounds(339, 278, 322, 71);
		IdLabel.setForeground(Color.WHITE);
		IdLabel.setFont(new Font("굴림", Font.BOLD, 29));
		add(IdLabel);

		// 회원 이름
		nameLabel = new JLabel("");
		nameLabel.setBounds(339, 411, 322, 71);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("굴림", Font.BOLD, 29));
		add(nameLabel);

		// 회원닉네임
		nicknameLabel = new JLabel("");
		nicknameLabel.setBounds(339, 549, 322, 71);
		nicknameLabel.setForeground(Color.WHITE);
		nicknameLabel.setFont(new Font("굴림", Font.BOLD, 29));
		add(nicknameLabel);

		// 회원정보수정 버튼
		JLabel modifyBtn = new JLabel();
		modifyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mif");
			}
		});
		modifyBtn.setBounds(313, 682, 373, 87);
		add(modifyBtn);

		// 배경화면 넣기
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
