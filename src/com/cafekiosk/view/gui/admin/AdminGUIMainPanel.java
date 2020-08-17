package com.cafekiosk.view.gui.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class AdminGUIMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4946313900145255983L;
	
	private JLabel background;
	private JLabel backBtn ;
	
	private AdminSwitchPanel asp;

	public AdminGUIMainPanel() {
		setBackground(new Color(51, 0, 0));
		
		setSize(1000, 800);
		setLayout(null);
						
		JLabel storageBtn = new JLabel("");
		storageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/storage.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "sp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/mainData.jpg"));
			}
		});
		storageBtn.setBounds(187, 170, 189, 193);
		add(storageBtn);
		
		JLabel scheduleBtn = new JLabel("");
		scheduleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/schedule.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "schep");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/mainData.jpg"));
			}
		});
		scheduleBtn.setBounds(582, 261, 189, 193);
		add(scheduleBtn);
		
		JLabel recipeBtn = new JLabel("");
		recipeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/recipe.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "rp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/mainData.jpg"));
			}
		});
		recipeBtn.setBounds(187, 428, 189, 193);
		add(recipeBtn);
		
		JLabel orderBtn = new JLabel("");
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/order.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "op");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				background.setIcon(new ImageIcon("./data/adminData/image/mainView/mainData.jpg"));
			}
		});
		orderBtn.setBounds(377, 330, 193, 226);
		add(orderBtn);
		
		backBtn=new JLabel("");
		backBtn.setIcon(new ImageIcon("./data/adminData/image/mainView/back.jpg"));
		
		
		backBtn.setBounds(899, 0, 100, 75);
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backBtn.setIcon(new ImageIcon("./data/adminData/image/mainView/backMouseOver.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				asp.getMainFrame().getMainCards().show(asp.getMainFrame().getContentPane(), "mainMenu");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backBtn.setIcon(new ImageIcon("./data/adminData/image/mainView/back.jpg"));
			}
		});
		
		
		background = new JLabel("");
		background.setBounds(0, 0, 1000, 800);
		add(backBtn);
		add(background);
		
		setVisible(true);
	}
	
	public void setAsp(AdminSwitchPanel asp) {
		this.asp = asp;
	}


}
