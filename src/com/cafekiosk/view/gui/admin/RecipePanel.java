package com.cafekiosk.view.gui.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6540321408844291625L;
	private AdminSwitchPanel asp;
	private JLabel recipePanel;
	
	
	public RecipePanel() {
		setSize(1000, 800);
		setLayout(null);
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				recipePanel.setIcon(new ImageIcon("./data/adminData/image/recipeView/recipeViewMouseOver.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "agmp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				recipePanel.setIcon(new ImageIcon("./data/adminData/image/recipeView/recipeView.jpg"));
			}
		});
		backBtn.setBounds(900, 0, 100, 78);
		add(backBtn);
		
		recipePanel = new JLabel("");
		recipePanel.setIcon(new ImageIcon("./data/adminData/image/recipeView/recipeView.jpg"));
		recipePanel.setBounds(0, 0, 1000, 800);
		add(recipePanel);
		
		setVisible(true);
	}


	public void setAsp(AdminSwitchPanel asp) {
		this.asp = asp;
	}

}
