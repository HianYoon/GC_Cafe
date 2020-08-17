package com.cafekiosk.view.gui.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.cafekiosk.controller.CafeMemberController;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MenuChoice extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8120821855578471150L;
	
	@SuppressWarnings("unused")
	private CafeMemberController cmc;
	private MemberSwitchPanel msp;
	private Order o;
	static int[] count = {0,0,0,0,0};
	private JLabel mangoMinus, mangoPlus, teeMinus, teePlus, latteMinus, lattePlus, ameMinus, amePlus, javaMinus, javaPlus, cartAdd;
	private JLabel mangoCount, teeCount, latteCount, ameCount, javaCount;

		//int[] count : ¸Á°í, Æ¼, ¶ó‹ó, ¾Æ¸Þ, ÀÚ¹Ù
		//TreeMap : ¾Æ¸Þ, ¶ó¶¼, ¸Á°í, ÀÚ¹Ù, Æ¼
	public MenuChoice() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cmc=msp.getCmc();
				count=new int[] {0,0,0,0,0};
			}
		});
		//this.main=main;
		
		setSize(1000,800);
		setBackground(new Color(255, 0, 0, 0));
		setLayout(null);
		
		mangoMinus = new JLabel();
		mangoMinus.setBounds(605, 57, 50, 50);
		add(mangoMinus);
		
		mangoPlus = new JLabel();
		mangoPlus.setBounds(759, 55, 50, 50);
		add(mangoPlus);
		
		mangoCount = new JLabel("" + count[2]);
		mangoCount.setHorizontalAlignment(SwingConstants.CENTER);
		mangoCount.setForeground(Color.WHITE);
		mangoCount.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.BOLD, 35));
		mangoCount.setBounds(656, 59, 89, 42);
		add(mangoCount);
			
		teeMinus = new JLabel();
		teeMinus.setBounds(605, 194, 50, 50);
		add(teeMinus);
		
		teePlus = new JLabel();
		teePlus.setBounds(759, 194, 50, 50);
		teePlus.setBackground(new Color(255, 0, 0, 0));
		add(teePlus);
		
		teeCount = new JLabel("" + count[4]);
		teeCount.setHorizontalAlignment(SwingConstants.CENTER);
		teeCount.setForeground(Color.WHITE);
		teeCount.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.BOLD, 35));
		teeCount.setBounds(658, 196, 89, 42);
		add(teeCount);
		
		
		latteMinus = new JLabel();
		latteMinus.setBounds(605, 324, 50, 50);
		add(latteMinus);
		
		lattePlus = new JLabel();
		lattePlus.setBounds(759, 324, 50, 50);
		lattePlus.setBackground(new Color(255, 0, 0, 0));
		add(lattePlus);
		
		latteCount = new JLabel("" + count[1]);
		latteCount.setHorizontalAlignment(SwingConstants.CENTER);
		latteCount.setForeground(Color.WHITE);
		latteCount.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.BOLD, 35));
		latteCount.setBounds(658, 332, 89, 42);
		add(latteCount);
		
		ameMinus = new JLabel();
		ameMinus.setBounds(605, 454, 50, 50);
		ameMinus.setBackground(new Color(255, 0, 0, 0));
		add(ameMinus);
		
		amePlus = new JLabel();
		amePlus.setBounds(759, 454, 50, 50);
		amePlus.setBackground(new Color(255, 0, 0, 0));
		add(amePlus);
		
		ameCount = new JLabel("" + count[0]);
		ameCount.setHorizontalAlignment(SwingConstants.CENTER);
		ameCount.setForeground(Color.WHITE);
		ameCount.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.BOLD, 35));
		ameCount.setBounds(658, 454, 89, 42);
		add(ameCount);
		
		javaMinus = new JLabel();
		javaMinus.setBounds(605, 589, 50, 50);
		add(javaMinus);
		
		javaPlus = new JLabel();
		javaPlus.setBounds(759, 592, 50, 50);
		add(javaPlus);
		
		javaCount = new JLabel("" + count[3]);
		javaCount.setHorizontalAlignment(SwingConstants.CENTER);
		javaCount.setForeground(Color.WHITE);
		javaCount.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.BOLD, 35));
		javaCount.setBounds(658, 596, 89, 42);
		add(javaCount);
		
		mangoMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count[2] > 0)
				count[2]--;
				mangoCount.setText("" + count[2]);
			}
		});
		mangoPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count[2]++;
				mangoCount.setText("" + count[2]);
			}
		});
		
		teeMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count[4] > 0)
				count[4]=count[1]-1;
				teeCount.setText("" + count[4]);
			}
		});
		teePlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count[4]=count[4]+1;
				teeCount.setText("" + count[4]);
			}
		});
		latteMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count[1] > 0)
				count[1]=count[1]-1;
				latteCount.setText("" + count[1]);
			}
		});
		lattePlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count[1]=count[1]+1;
				latteCount.setText("" + count[1]);
			}
		});
		ameMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count[0] > 0)
				count[0]--;
				ameCount.setText("" + count[0]);
			}
		});
		amePlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count[0]++;
				ameCount.setText("" + count[0]);
			}
		});
		javaMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count[3] > 0)
				count[3]--;
				javaCount.setText("" + count[3]);
			}
		});
		javaPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count[3]++;
				javaCount.setText("" + count[3]);
			}
		});
		
		
		
		cartAdd = new JLabel();
		cartAdd.setBounds(558, 695, 311, 66);
		cartAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(msp.getO()!=null)msp.remove(o);
				o=new Order(msp);
				msp.add(o,"o");
				
				setTexts();
				msp.getMemberCards().show(msp, "o");
			}
			
		});
		add(cartAdd);
		//add(order);
		//main.getContentPane().add(this);
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msp.getMemberCards().show(msp, "mmp");
				setTexts();
		
			}
		});
		backBtn.setBounds(900, 12, 72, 50);
		add(backBtn);
		
		JLabel backImage = new JLabel("");
		backImage.setIcon(new ImageIcon("./data/memberData/image/cart/menuChoice.jpg"));
		backImage.setBounds(0, 0, 1000, 800);
		add(backImage);
		
		setVisible(true);
	}
	public void setO(Order o) {
		this.o = o;
	}
	public void setMsp(MemberSwitchPanel msp) {
		this.msp = msp;
	}
	
	public void setCmc(CafeMemberController cmc) {
		this.cmc = cmc;
	}
	
	public void setTexts() {
		mangoCount.setText("0");
		teeCount.setText("0");
		latteCount.setText("0");
		ameCount.setText("0");
		javaCount.setText("0");
	}
}


	

