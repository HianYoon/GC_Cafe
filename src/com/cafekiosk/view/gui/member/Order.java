package com.cafekiosk.view.gui.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.controller.CafeOrderController;
import com.cafekiosk.model.vo.MenuItem;

public class Order extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -445225570065081423L;
	
	@SuppressWarnings("unused")
	private MemberSwitchPanel msp;
	private CafeOrderController coc=new CafeOrderController();
	private CafeMemberController cmc;
	private TreeMap<MenuItem,Integer> orderCurrent = coc.menuItemsLoad();
	@SuppressWarnings("unused")
	private MenuChoice mc;
	private int[] prices = new int[5];


	//int[] count : 망고, 티, 라뗴, 아메, 자바
	//TreeMap : 아메, 라떼, 망고, 자바 티
	{
		int i =0;
		for(MenuItem v :new TreeSet<MenuItem>(orderCurrent.keySet())) {
		prices[i]=v.getPrice();
		i++;
		}
	}
	public Order(MemberSwitchPanel msp) {
		this.msp=msp;
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmc=msp.getCmc();
				
			}
		});
		setBounds(0,0,1000,800);
		setLayout(null);
		
		
		JLabel mangoCount = new JLabel("" + MenuChoice.count[2]);
		mangoCount.setHorizontalAlignment(SwingConstants.CENTER);
		mangoCount.setForeground(Color.WHITE);
		mangoCount.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		mangoCount.setBounds(673, 183, 105, 40);
		add(mangoCount);
		
		JLabel teeCount = new JLabel("" + MenuChoice.count[4]);
		teeCount.setHorizontalAlignment(SwingConstants.CENTER);
		teeCount.setForeground(Color.WHITE);
		teeCount.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		teeCount.setBounds(673, 280, 105, 40);
		add(teeCount);
		
		JLabel latteCount = new JLabel("" + MenuChoice.count[1]);
		latteCount.setHorizontalAlignment(SwingConstants.CENTER);
		latteCount.setForeground(Color.WHITE);
		latteCount.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		latteCount.setBounds(673, 376, 105, 40);
		add(latteCount);
		
		JLabel ameCount = new JLabel("" + MenuChoice.count[0]);
		ameCount.setHorizontalAlignment(SwingConstants.CENTER);
		ameCount.setForeground(Color.WHITE);
		ameCount.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		ameCount.setBounds(673, 471, 105, 40);
		add(ameCount);
		
		JLabel javaCount = new JLabel("" + MenuChoice.count[3]);
		javaCount.setHorizontalAlignment(SwingConstants.CENTER);
		javaCount.setForeground(Color.WHITE);
		javaCount.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		javaCount.setBounds(673, 558, 105, 40);
		add(javaCount);
		
		int priceAll = 0;
		for(int i = 0; i < 5; i++) {
			priceAll += (prices[i] * MenuChoice.count[i]);
			System.out.println(prices[i]+" "+MenuChoice.count[i]);
		}
		
		JLabel price = new JLabel("" + priceAll);
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 35));
		price.setBounds(276, 707, 184, 60);
		add(price);
		
		JLabel order = new JLabel();
		order.setHorizontalAlignment(SwingConstants.CENTER);		
		order.setBounds(641, 707, 292, 60);
		add(order);
		order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ArrayList<Integer> countList=new ArrayList<Integer>();
				for(int v : MenuChoice.count) {
					countList.add(v);
				}
				int i =0;
				for(MenuItem mi : new TreeSet<MenuItem>(orderCurrent.keySet())) {
					orderCurrent.replace(mi, MenuChoice.count[i]);
					i++;
				}
				coc.menuItemsPurcahsed(countList);
				
				cmc.memberOrderHistorySave(orderCurrent);
				System.out.println("저장완료!");
				
				msp.getMemberCards().show(msp, "cmo");
			}
			
		});
		//***추가***뒤로 가기 버튼 추가부분
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
			}
		});
		backBtn.setBounds(900, 12, 72, 50);
		add(backBtn);
		//여기까지
				
		JLabel backImage = new JLabel("");
		backImage.setIcon(new ImageIcon("./data/memberData/image/cart/order.jpg"));
		backImage.setBounds(0, 0, 1000, 800);
		add(backImage);
		
	
		setVisible(true);
		
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	public void setMc(MenuChoice mc) {
		this.mc = mc;
	}
	public void setCmc(CafeMemberController cmc) {
		this.cmc = cmc;
	}

}
