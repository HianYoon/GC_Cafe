package com.cafekiosk.view.gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cafekiosk.controller.CafeAdminGUIController;
import com.cafekiosk.model.vo.Ingredient;

public class StockPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3684267122721007740L;
	private AdminSwitchPanel asp;
	
	private JLabel stockView;
	private CafeAdminGUIController cagc=new CafeAdminGUIController();
	private TreeMap<Ingredient, Double> myStock;
	
	{
		myStockLoader();
	}
	
	private double[] myStockValues=new double[myStock.size()];
	private JLabel smoothie;
	private JLabel choco;
	private JLabel camo;
	private JLabel mango;
	private JLabel milk;
	private JLabel coffee;
	
	
	public StockPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				myStockLoader();
				stockTextRenew();
			}
		});
		// TODO Auto-generated constructor stub
		setSize(1000, 800);
		setLayout(null);
		
		//일단 밸류를 모두 뺀다.
		ingredientShortageCheck();
		
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				stockView.setIcon(new ImageIcon("./data/adminData/image/stockView/stockMouse.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "agmp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				stockView.setIcon(new ImageIcon("./data/adminData/image/stockView/stockView.jpg"));
			}
		});
		backBtn.setBounds(900, 0, 100, 75);
		add(backBtn);
		
		smoothie = new JLabel("sm");
		smoothie.setFont(new Font("굴림", Font.PLAIN, 18));
		smoothie.setForeground(Color.WHITE);
		smoothie.setBounds(830, 390, 70, 30);
		smoothie.setText(""+myStockValues[0]);
		add(smoothie);
		
		choco = new JLabel("choco");
		choco.setFont(new Font("굴림", Font.PLAIN, 18));
		choco.setForeground(Color.WHITE);
		choco.setBounds(830, 440, 68, 32);
		choco.setText(""+myStockValues[1]);
		add(choco);
		
		camo = new JLabel("camo");
		camo.setFont(new Font("굴림", Font.PLAIN, 18));
		camo.setForeground(Color.WHITE);
		camo.setBounds(830, 490, 68, 32);
		camo.setText(""+myStockValues[2]);
		add(camo);
		
		mango = new JLabel("mango");
		mango.setFont(new Font("굴림", Font.PLAIN, 18));
		mango.setForeground(Color.WHITE);
		mango.setBounds(830, 540, 68, 32);
		mango.setText(""+myStockValues[3]);
		add(mango);
		
		milk = new JLabel("milk");
		milk.setFont(new Font("굴림", Font.PLAIN, 18));
		milk.setForeground(Color.WHITE);
		milk.setBounds(830, 593, 68, 32);
		milk.setText(""+myStockValues[4]);
		add(milk);
		
		coffee = new JLabel("coffee");
		coffee.setFont(new Font("굴림", Font.PLAIN, 18));
		coffee.setForeground(Color.WHITE);
		coffee.setBounds(830, 643, 68, 32);
		coffee.setText(""+myStockValues[5]);
		add(coffee);
		
		stockView = new JLabel("");
		stockView.setIcon(new ImageIcon("./data/adminData/image/stockView/stockView.jpg"));
		stockView.setBounds(0, 0, 1000, 800);
		add(stockView);
		
		setVisible(true);
	}

	//오더 패널로 이동
//	public void alertForIngredientShortage() {
//		//이 패널이 켜져있고, 어떤재료라도 2보다 작게 남아있으면 재료 부족 경고 메시지 출력
//		if(ingredientShortage) {
//			JOptionPane.showMessageDialog(null, "재료가 부족합니다! 재료 주문을 서둘러 주세요.\n재료가 없으면 망해요~!", "재료 부족 안내", 1);
//		}
//	}
	public void myStockLoader() {
		myStock=cagc.ingredientMyStockLoader();
	}
	public void stockTextRenew() {
		ingredientShortageCheck();
		smoothie.setText(""+myStockValues[0]);
		choco.setText(""+myStockValues[1]);
		camo.setText(""+myStockValues[2]);
		mango.setText(""+myStockValues[3]);
		milk.setText(""+myStockValues[4]);
		coffee.setText(""+myStockValues[5]);
	}
	
	public void ingredientShortageCheck() {
		int i=0;
		for(Ingredient v : new TreeSet<Ingredient>(myStock.keySet())) {
			myStockValues[i]=myStock.get(v);
			i++;
		}
	}
	public void setAsp(AdminSwitchPanel asp) {
		this.asp = asp;
	}
}
