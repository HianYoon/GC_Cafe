package com.cafekiosk.view.gui.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cafekiosk.controller.CafeAdminGUIController;
import com.cafekiosk.model.vo.Ingredient;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class OrderPanel extends JPanel {

	private static final long serialVersionUID = 2514051896601511594L;
	private AdminSwitchPanel asp;

	private JLabel orderView;
	private CafeAdminGUIController cagc=new CafeAdminGUIController();
	
	private TreeMap<Ingredient, Double> myStock;
	{
		myStockLoader();
	}
	
	private double[] myStockValues=new double[myStock.size()];
	private int[] ingredientPrices=new int[myStock.size()];
	private int[] purchasedAmount=new int[myStock.size()];
	private JLabel smoothie;
	private JLabel choco;
	private JLabel camo;
	private JLabel mango;
	private JLabel milk;
	private JLabel coffee;
	
	
	private JSpinner smoothieNo;
	private JSpinner chocoNo;
	private JSpinner camoNo;
	private JSpinner mangoNo;
	private JSpinner milkNo;
	private JSpinner coffeeNo;
	private JSpinner[] spinnerArr;
	private boolean ingredientShortage=false;
	private JLabel sumLabel;
	
	public OrderPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				myStockLoader();
				stockTextRenew();
			}
		});
		// TODO Auto-generated constructor stub

		//일단 밸류을 모두 빼온다.
		int i=0;
		for(Ingredient v : new TreeSet<Ingredient>(myStock.keySet())) {
			ingredientPrices[i]=v.getIngredientPrice();
			i++;
		}
		
		smoothie = new JLabel("sm");
		smoothie.setFont(new Font("굴림", Font.PLAIN, 18));
		smoothie.setForeground(Color.WHITE);
		smoothie.setBounds(368, 448, 70, 30);
		
		add(smoothie);
		
		choco = new JLabel("choco");
		choco.setFont(new Font("굴림", Font.PLAIN, 18));
		choco.setForeground(Color.WHITE);
		choco.setBounds(368, 498, 68, 32);
		
		add(choco);
		
		camo = new JLabel("camo");
		camo.setFont(new Font("굴림", Font.PLAIN, 18));
		camo.setForeground(Color.WHITE);
		camo.setBounds(368, 548, 68, 32);
		
		add(camo);
		
		mango = new JLabel("mango");
		mango.setFont(new Font("굴림", Font.PLAIN, 18));
		mango.setForeground(Color.WHITE);
		mango.setBounds(368, 605, 68, 32);
		
		add(mango);
		
		milk = new JLabel("milk");
		milk.setFont(new Font("굴림", Font.PLAIN, 18));
		milk.setForeground(Color.WHITE);
		milk.setBounds(368, 655, 68, 32);
		
		add(milk);
		
		coffee = new JLabel("coffee");
		coffee.setFont(new Font("굴림", Font.PLAIN, 18));
		coffee.setForeground(Color.WHITE);
		coffee.setBounds(368, 705, 68, 32);
		
		add(coffee);
		
		JLabel smoothiePrice = new JLabel("smPrice");
		smoothiePrice.setFont(new Font("굴림", Font.PLAIN, 18));
		smoothiePrice.setForeground(Color.WHITE);
		smoothiePrice.setBounds(547, 448, 70, 30);
		smoothiePrice.setText(""+ingredientPrices[0]);
		add(smoothiePrice);
		
		JLabel chocoPrice = new JLabel("chocoPrice");
		chocoPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		chocoPrice.setForeground(Color.WHITE);
		chocoPrice.setBounds(547, 498, 68, 32);
		chocoPrice.setText(""+ingredientPrices[1]);
		add(chocoPrice);
		
		JLabel camoPrice = new JLabel("camoPrice");
		camoPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		camoPrice.setForeground(Color.WHITE);
		camoPrice.setBounds(547, 548, 68, 32);
		camoPrice.setText(""+ingredientPrices[2]);
		add(camoPrice);
		
		JLabel mangoPrice = new JLabel("mangoPrice");
		mangoPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		mangoPrice.setForeground(Color.WHITE);
		mangoPrice.setBounds(547, 598, 68, 32);
		mangoPrice.setText(""+ingredientPrices[3]);
		add(mangoPrice);
		
		JLabel milkPrice = new JLabel("milkPrice");
		milkPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		milkPrice.setForeground(Color.WHITE);
		milkPrice.setBounds(547, 651, 68, 32);
		milkPrice.setText(""+ingredientPrices[4]);
		add(milkPrice);
		
		JLabel coffeePrice = new JLabel("coffeePrice");
		coffeePrice.setFont(new Font("굴림", Font.PLAIN, 18));
		coffeePrice.setForeground(Color.WHITE);
		coffeePrice.setBounds(547, 701, 68, 32);
		coffeePrice.setText(""+ingredientPrices[5]);
		add(coffeePrice);
		
		
		
		setSize(1000, 800);
		setLayout(null);
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				orderView.setIcon(new ImageIcon("./data/adminData/image/orderView/orderViewMouse.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				asp.getAdminCards().show(asp, "agmp");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				orderView.setIcon(new ImageIcon("./data/adminData/image/orderView/orderView.jpg"));
			}
		});
		backBtn.setBounds(900, 0, 100, 75);
		add(backBtn);
		
		JLabel purchaseBtn = new JLabel("");
		purchaseBtn.setVerticalAlignment(SwingConstants.TOP);
		purchaseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				orderView.setIcon(new ImageIcon("./data/adminData/image/orderView/orderViewPurchaseMouse.jpg"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!getSpinnerValues(smoothieNo)) return;
				
				//새로운 값 저장!
				int i=0;
				for(Ingredient v : new TreeSet<Ingredient>(myStock.keySet())) {
					myStock.replace(v, myStockValues[i]+purchasedAmount[i]);
					i++;
				}
				System.out.println(cagc.ingredientMyStockSave(myStock));
				//모든 스피너 다시 0으로 맞추기
				for(JSpinner v:spinnerArr) v.setValue(0);
				
				asp.getAdminCards().show(asp, "agmp");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				orderView.setIcon(new ImageIcon("./data/adminData/image/orderView/orderView.jpg"));
			}
		});
		purchaseBtn.setBounds(803, 699, 197, 101);
		add(purchaseBtn);
		
		smoothieNo = new JSpinner();
		smoothieNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(smoothieNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		smoothieNo.setForeground(Color.WHITE);
		smoothieNo.setFont(new Font("굴림", Font.PLAIN, 18));
		smoothieNo.setBounds(694, 447, 70, 30);
		add(smoothieNo);
		
		chocoNo = new JSpinner();
		chocoNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(chocoNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		chocoNo.setForeground(Color.WHITE);
		chocoNo.setFont(new Font("굴림", Font.PLAIN, 18));
		chocoNo.setBounds(694, 497, 68, 32);
		add(chocoNo);
		
		camoNo = new JSpinner();
		camoNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(camoNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		camoNo.setForeground(Color.WHITE);
		camoNo.setFont(new Font("굴림", Font.PLAIN, 18));
		camoNo.setBounds(694, 547, 68, 32);
		add(camoNo);
		
		mangoNo = new JSpinner();
		mangoNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(mangoNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		mangoNo.setForeground(Color.WHITE);
		mangoNo.setFont(new Font("굴림", Font.PLAIN, 18));
		mangoNo.setBounds(694, 597, 68, 32);
		add(mangoNo);
		
		milkNo = new JSpinner();
		milkNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(milkNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		milkNo.setForeground(Color.WHITE);
		milkNo.setFont(new Font("굴림", Font.PLAIN, 18));
		milkNo.setBounds(694, 650, 68, 32);
		add(milkNo);
		
		coffeeNo = new JSpinner();
		coffeeNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(!getSpinnerValues(coffeeNo)) return;
				sumLabel.setText(""+getSum());
			}
		});
		coffeeNo.setForeground(Color.WHITE);
		coffeeNo.setFont(new Font("굴림", Font.PLAIN, 18));
		coffeeNo.setBounds(694, 700, 68, 32);
		add(coffeeNo);
		
		
		sumLabel = new JLabel("0");
		sumLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sumLabel.setForeground(Color.WHITE);
		sumLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		sumLabel.setBounds(811, 661, 125, 30);
		add(sumLabel);
		
		orderView = new JLabel("");
		orderView.setIcon(new ImageIcon("./data/adminData/image/orderView/orderView.jpg"));
		orderView.setBounds(0, 0, 1000, 800);
		add(orderView);
		
		setVisible(true);
	}

	
	
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
	public void alertForIngredientShortage() {
		//이 패널이 켜져있고, 어떤재료라도 2보다 작게 남아있으면 재료 부족 경고 메시지 출력
		if(ingredientShortage) {
			JOptionPane.showMessageDialog(null, "재료가 부족합니다! 재료 주문을 서둘러 주세요.\n재료가 없으면 망해요~!", "재료 부족 안내", 1);
		}
	}
	public void ingredientShortageCheck() {
		int i=0;
		for(Ingredient v : new TreeSet<Ingredient>(myStock.keySet())) {
			myStockValues[i]=myStock.get(v);
			i++;
			//어떤 재료라도 2보다 작게 남아있으면 논리값을 true로 바꿔줌.
			if(myStock.get(v)<2) ingredientShortage=true;
			else ingredientShortage=false;
		}
	}
	
	public boolean getSpinnerValues(JSpinner j) {
		int i=0;
		System.out.println(smoothieNo.getValue());
		spinnerArr=new JSpinner[]{smoothieNo,chocoNo,camoNo,mangoNo,milkNo,coffeeNo};
		for(JSpinner v: spinnerArr) {
			int temp=(int)v.getValue();
			//0보다 작은 값이 입력된 곳이 있으면 돌아감.
			if(temp<0) {
				JOptionPane.showMessageDialog(null, "0보다 작은 값이 입력된 필드가 있습니다.", "입력 오류", 1);
				j.setValue(0);
				return false;
			}
			purchasedAmount[i]=temp;
			i++;
		}
		return true;
	}



	public int getSum() {
		int sum=0;
		for(int i=0; i<myStock.size();i++) {
			sum+=ingredientPrices[i]*purchasedAmount[i];
		}
		return sum;
	}



	public void setAsp(AdminSwitchPanel asp) {
		this.asp = asp;
	}
	
}
