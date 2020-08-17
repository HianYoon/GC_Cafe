package com.cafekiosk.view.member.msg;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.view.gui.MainFrame;

public class CheckIdAlready extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1284737620522782224L;
	private JLabel checkBtn;
	private MainFrame mainFrame;
	public CheckIdAlready(MainFrame f) {
		
		setSize(1000,800);
		setLayout(null);
		
		mainFrame=f;
		
		checkBtn = new JLabel();
		checkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.getMainCards().show(mainFrame.getContentPane(), "jm");
			}
		});
		checkBtn.setBounds(640, 458, 141, 47);
		add(checkBtn);
		checkBtn.setLayout(null);
		
		//배경이미지
		JLabel idAlreadyImage = new JLabel();
		idAlreadyImage.setIcon(new ImageIcon("./data/memberData/image/memberRegister/idAlreadyExist.jpg"));
		idAlreadyImage.setBounds(0, 0, 1000, 800);
		add(idAlreadyImage);

		setVisible(true);
	}
}
