package com.cafekiosk.view.gui.admin;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.cafekiosk.view.gui.MainFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AdminSwitchPanel extends JPanel{

	/**
	 * 어드민 카드들을 제어하는 패널. adminCards들을 통해서 다른 카드들이 카드 전환을 실시
	 * 따라서 각 카드는 이 클래스 객체의 주소값을 가지고 있어야 한다.
	 */
	private static final long serialVersionUID = -6153562686651676226L;
	private CardLayout adminCards=new CardLayout();
	
	private MainFrame mainFrame;
	private AdminGUIMainPanel agmp=new AdminGUIMainPanel();
	private OrderPanel op = new OrderPanel();
	private RecipePanel rp=new RecipePanel();
	private SchedulePanel schep=new SchedulePanel();
	private StockPanel sp=new StockPanel();
	
	{
		agmp.setAsp(this);
		op.setAsp(this);
		rp.setAsp(this);
		schep.setAsp(this);
		sp.setAsp(this);
	}
	
	
	
	public AdminSwitchPanel() {
		setBounds(0, 0, 1000, 800);
		
		setLayout(adminCards);
		
		add("agmp",agmp);
		add("op",op);
		add("rp",rp);
		add("schep",schep);
		add("sp",sp);
		
		
		setVisible(true);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				op.ingredientShortageCheck();
				op.alertForIngredientShortage();
			}
		});
	}
	public CardLayout getAdminCards() {
		return adminCards;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
