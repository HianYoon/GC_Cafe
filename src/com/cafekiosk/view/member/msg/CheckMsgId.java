package com.cafekiosk.view.member.msg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.MainFrame;

public class CheckMsgId extends JPanel {

	private static final long serialVersionUID = -3354310249258209082L;

	private MainFrame mainFrame;
	// 회원 가입 패널 위에 새로운 프레임으로 띄우기
	public CheckMsgId(MainFrame f) {

		setSize(1000,800);
		setLayout(null);
		mainFrame=f;

		JLabel checkBtn = new JLabel();
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.getMainCards().show(mainFrame.getContentPane(), "jm");
			}
		});
		checkBtn.setBounds(640, 458, 141, 47);
		add(checkBtn);
		checkBtn.setLayout(null);

		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon("./data/memberData/image/memberRegister/idAvailable.jpg"));
		Image.setBounds(0, 0, 1000, 800);
		add(Image);

		
		setVisible(true);
	}

}
