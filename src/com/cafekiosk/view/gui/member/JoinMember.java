package com.cafekiosk.view.gui.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cafekiosk.controller.CafeMemberController;
import com.cafekiosk.view.gui.MainFrame;
import com.cafekiosk.view.member.msg.CheckMsgId;

public class JoinMember extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6648810609087765593L;
	private CafeMemberController cmc = new CafeMemberController();
	@SuppressWarnings("unused")
	private CheckMsgId cmi;
	
	private MainFrame mainFrame;

	private JTextField nameTextField;
	private JTextField idTextField;
	private JPasswordField passwordTextField;
	private JPasswordField passwordCheckTextField;
	private JTextField nicknameTextField;

	private JPanel idAvailableBtn;
	private JPanel registerSaveBtn;
	private JPanel registerCancleBtn;
	private JLabel registerFoam;

	public JoinMember(MainFrame f) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				passwordTextField.setText("");
				passwordCheckTextField.setText("");
							
			}
		});
		
 //////////test//////////////tset/////////test/////////
		//콘솔창에 회원 띄워보기
//		cmc.whoIs();
/////////////test//////////////test//////////////test/////////////
		setSize(1000, 800);

		setLayout(null);
		mainFrame=f;

		nameTextField = new JTextField();

		nameTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		nameTextField.setBounds(185, 122, 293, 49);
		nameTextField.setOpaque(false);
		nameTextField.setBorder(BorderFactory.createEmptyBorder());
		add(nameTextField);
		nameTextField.setColumns(10);

		idTextField = new JTextField();
		idTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		idTextField.setColumns(10);
		idTextField.setBounds(185, 266, 293, 49);
		idTextField.setOpaque(false);
		idTextField.setBorder(BorderFactory.createEmptyBorder());
		add(idTextField);

		idAvailableBtn = new JPanel();
		// id중복확인메세지 띄우기
		idAvailableBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = cmc.checkIDNickname(idTextField.getText(), "");
				if (result == 0) {
					// id사용가능
					mainFrame.getMainCards().show(mainFrame.getContentPane(), "cms");
				} else if (result == 1) {
					// 중복된 아이디
					mainFrame.getMainCards().show(mainFrame.getContentPane(), "cia");
				}
			}

		});

		idAvailableBtn.setBounds(507, 266, 114, 49);
		idAvailableBtn.setBackground(new Color(255, 0, 0, 0));
		add(idAvailableBtn);

		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(185, 412, 293, 49);
		passwordTextField.setOpaque(false);
		passwordTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordTextField);

		passwordCheckTextField = new JPasswordField();
		passwordCheckTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		passwordCheckTextField.setColumns(10);
		passwordCheckTextField.setBounds(185, 550, 293, 49);
		passwordCheckTextField.setOpaque(false);
		passwordCheckTextField.setBorder(BorderFactory.createEmptyBorder());
		add(passwordCheckTextField);

		nicknameTextField = new JTextField();
		nicknameTextField.setFont(new Font("굴림", Font.PLAIN, 25));
		nicknameTextField.setColumns(10);
		nicknameTextField.setBounds(185, 689, 293, 49);
		nicknameTextField.setOpaque(false);
		nicknameTextField.setBorder(BorderFactory.createEmptyBorder());
		add(nicknameTextField);
		
		

		registerSaveBtn = new JPanel();
		registerSaveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("deprecation")
				boolean result = cmc.memberRegister(nameTextField.getText(), idTextField.getText(), passwordTextField.getText(), nicknameTextField.getText());
				if(result == true) {
					//가입완료
					mainFrame.getMainCards().show(mainFrame.getContentPane(), "cr");					
				}
				// 오류
				else JOptionPane.showInputDialog(this, "다시 입력해주세요");
			}
		});
		registerSaveBtn.setBounds(714, 630, 234, 49);
		registerSaveBtn.setBackground(new Color(255, 0, 0, 0));
		add(registerSaveBtn);
		registerSaveBtn.setLayout(null);

		registerCancleBtn = new JPanel();
		registerCancleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "가입을 취소하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
				}else if(result == JOptionPane.YES_OPTION) {
					mainFrame.getMainCards().show(mainFrame.getContentPane(), "mainMenu");
				}else {
				}
	
			}
		});
		registerCancleBtn.setLayout(null);
		registerCancleBtn.setBounds(714, 701, 234, 49);
		registerCancleBtn.setBackground(new Color(255, 0, 0, 0));
		add(registerCancleBtn);
		
		JLabel backBtn = new JLabel("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.getMainCards().show(mainFrame.getContentPane(), "mainMenu");
			}
		});
		backBtn.setBounds(853, 0, 147, 90);
		add(backBtn);

		registerFoam = new JLabel("");
		registerFoam.setIcon(new ImageIcon("./data/memberData/image/memberRegister/registerFoam.jpg"));
		registerFoam.setBounds(0, 0, 1000, 800);
		add(registerFoam);
	
	
	}
}
