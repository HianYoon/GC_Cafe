package com.cafekiosk.view.member.msg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.MainFrame;

public class CongratulationRegister extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7589330929808823786L;
	private MainFrame mainFrame;

	public CongratulationRegister(MainFrame f) {

		setSize(1000, 800);
		setLayout(null);
		mainFrame = f;

		// 뒤로가기
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.getMainCards().show(mainFrame.getContentPane(), "mainMenu");
			}
		});
		back.setBounds(877, 29, 66, 55);
		add(back);

		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon("./data/memberData/image/memberRegister/registerSuccess.jpg"));
		Image.setBounds(0, 0, 1000, 800);
		add(Image);

		setVisible(true);

	}
}
