package com.cafekiosk.view.gui.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchedulePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5803840941485548011L;
	private AdminSwitchPanel asp;
	
	private JLabel schedulePanel;


	
	public SchedulePanel() {
		// TODO Auto-generated constructor stub
		setSize(1000, 800);
		setLayout(null);
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				schedulePanel.setIcon(new ImageIcon("./data/adminData/image/scheduleView/scheduleMouseOver.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "agmp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				schedulePanel.setIcon(new ImageIcon("./data/adminData/image/scheduleView/scheduleView.jpg"));
			}
		});
		backBtn.setBounds(900, 0, 100, 75);
		add(backBtn);
		
		schedulePanel = new JLabel("");
		schedulePanel.setIcon(new ImageIcon("./data/adminData/image/scheduleView/scheduleView.jpg"));
		schedulePanel.setBounds(0, 0, 1000, 800);
		add(schedulePanel);
		
		
		setVisible(true);
	}
	
	public void setAsp(AdminSwitchPanel asp) {
		this.asp = asp;
	}
	
}
