package com.cafekiosk.view.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cafekiosk.controller.CafeAdminGUIController;
import com.cafekiosk.controller.CafeMemberController;


public class MainMenu extends JPanel {

	/**
	 * 메인프레임 카드 스택의 첫번째 카드. 다른 카드들로의 연결 분기
	 */
	
	private static final long serialVersionUID = 389395695854749865L;
	
	private JTextField idtextField;
	private JPasswordField passwordField;
	
	private MainFrame mainFrame;
	private CafeAdminGUIController cagc=new CafeAdminGUIController();
	private CafeMemberController cmc;
	
	//어드민 로그인버튼을 누르면 adminLogin논리값이 변경됨. 이 값이 true면 어드민 로그인쪽으로 연결 false면 멤버
	private boolean adminLogIn=false;
	//어드민 실패 횟수에 따라 출력 메세지 다르게 하기 위한 카운트
	private int adminLogInFailureCount=0;;

	private JLabel mainMenuView;
	
	public MainMenu() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		//아이디 텍스트필드
		idtextField = new JTextField();
		idtextField.setFont(new Font("굴림", Font.BOLD, 23));
		idtextField.setBounds(109, 642, 219, 46);
		add(idtextField);
		idtextField.setColumns(10);
		idtextField.setOpaque(false); //투명하게 만들기
		idtextField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //투명하게 만들기
		
		//비밀번호 텍스트필드
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.BOLD, 23));
		passwordField.setBounds(109, 701, 218, 44);
		passwordField.setColumns(10);
		passwordField.setOpaque(false); //투명하게 만들기
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //투명하게 만들기
		add(passwordField);
		
		

		JLabel admin = new JLabel("");
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminLogIn=!adminLogIn;
				if(adminLogIn) mainMenuView.setIcon(new ImageIcon("./data/mainView/homeChecked.jpg"));
				else mainMenuView.setIcon(new ImageIcon("./data/mainView/home.jpg"));
			}
			
		});
		admin.setBounds(0, 540, 339, 82);
		add(admin);
		
		
		//회원가입 버튼
		JLabel signUp = new JLabel("");
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.getMainCards().show(mainFrame.getContentPane(), "jm");
			}
		});
		signUp.setBounds(339, 642, 84, 39);
		add(signUp);
		setVisible(true);
	
		//Login 버튼
		JLabel login = new JLabel();
		login.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(adminLogIn) {
					if(cagc.adminLogIn(idtextField.getText(), passwordField.getText())) {
						if(adminLogInFailureCount==0) JOptionPane.showMessageDialog(null, "일어나세요. GC의 용사여...일할 시간입니다..", "로그인 성공", 1);
						else if(adminLogInFailureCount==1) JOptionPane.showMessageDialog(null, "한 번쯤은 실수지 후후", "로그인 성공", 1);
						else if(adminLogInFailureCount==2) JOptionPane.showMessageDialog(null, "흠... 당신.. 바보는 아니죠?", "로그인 성공", 1);
						else JOptionPane.showMessageDialog(null, "이런 바보와 함께 일해야 하다니...", "WTF", 1);
						adminLogInFailureCount=0;
						mainFrame.getMainCards().show(mainFrame.getContentPane(), "asp");
					}else {
						if(adminLogInFailureCount==0) {
							cagc.adminLoginInfoFileCreate();
							JOptionPane.showMessageDialog(null, "까먹은 모양이군요...\n하지만 아이디와 비밀번호는 이미 주어졌습니다...", "아니 이건 뭐 XX도 아니고.. 로그인 실패", 0);
						}else if(adminLogInFailureCount==1){
							JOptionPane.showMessageDialog(null, "문서들의 바다, 그곳에 당신의 정보가 있습니다.", "그 정도 힌트로는 부족하단 말인가?", 2);
						}else if(adminLogInFailureCount>=2) {
							int result=JOptionPane.showConfirmDialog(null, "흠.... 바보라고 인정하면 답을 알려드리지요", "내 XX 내 XX 내 XX", JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.CLOSED_OPTION) {
							}else if(result == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "그냥 \"내 문서\"좀 가주겠니.. 혼자 있고 싶다..", "포기했니..", 3);
							}else {
							}
						}
						adminLogInFailureCount++;
					}
					
				}else {
					//CafeMemberController의 로그인 화면 불러오기 
					boolean result=cmc.memberSignIn(idtextField.getText(), passwordField.getText());
					//로그인 정보 불러와서 넘겨주기...?
					
					if(result) {
						JOptionPane.showMessageDialog(null, cmc.memberInformation().getNickname()+"님, 환영합니다.", "로그인 성공", 1);
						mainFrame.getMainCards().show(mainFrame.getContentPane(), "msp");
						mainFrame.getMsp().getMmp().setCmc(cmc);
						mainFrame.getMsp().getMmp().renewTexts();
					}
					else JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀렸습니다.", "아이디/비밀번호 오류", 1);
				}
				idtextField.setText("");
				passwordField.setText("");
			}
		});
		login.setBounds(339, 701, 84, 42);
		add(login);

		//배경화면 넣기 
		mainMenuView = new JLabel("");
		mainMenuView.setIcon(new ImageIcon("./data/mainView/home.jpg"));
		mainMenuView.setBounds(0, 0, 1000, 800);
		add(mainMenuView);
	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}

	public void setCmc(CafeMemberController cmc) {
		this.cmc = cmc;
	}
	
}
