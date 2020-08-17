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
	 * ���������� ī�� ������ ù��° ī��. �ٸ� ī������ ���� �б�
	 */
	
	private static final long serialVersionUID = 389395695854749865L;
	
	private JTextField idtextField;
	private JPasswordField passwordField;
	
	private MainFrame mainFrame;
	private CafeAdminGUIController cagc=new CafeAdminGUIController();
	private CafeMemberController cmc;
	
	//���� �α��ι�ư�� ������ adminLogin������ �����. �� ���� true�� ���� �α��������� ���� false�� ���
	private boolean adminLogIn=false;
	//���� ���� Ƚ���� ���� ��� �޼��� �ٸ��� �ϱ� ���� ī��Ʈ
	private int adminLogInFailureCount=0;;

	private JLabel mainMenuView;
	
	public MainMenu() {
		
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		
		//���̵� �ؽ�Ʈ�ʵ�
		idtextField = new JTextField();
		idtextField.setFont(new Font("����", Font.BOLD, 23));
		idtextField.setBounds(109, 642, 219, 46);
		add(idtextField);
		idtextField.setColumns(10);
		idtextField.setOpaque(false); //�����ϰ� �����
		idtextField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //�����ϰ� �����
		
		//��й�ȣ �ؽ�Ʈ�ʵ�
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.BOLD, 23));
		passwordField.setBounds(109, 701, 218, 44);
		passwordField.setColumns(10);
		passwordField.setOpaque(false); //�����ϰ� �����
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //�����ϰ� �����
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
		
		
		//ȸ������ ��ư
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
	
		//Login ��ư
		JLabel login = new JLabel();
		login.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(adminLogIn) {
					if(cagc.adminLogIn(idtextField.getText(), passwordField.getText())) {
						if(adminLogInFailureCount==0) JOptionPane.showMessageDialog(null, "�Ͼ����. GC�� ��翩...���� �ð��Դϴ�..", "�α��� ����", 1);
						else if(adminLogInFailureCount==1) JOptionPane.showMessageDialog(null, "�� ������ �Ǽ��� ����", "�α��� ����", 1);
						else if(adminLogInFailureCount==2) JOptionPane.showMessageDialog(null, "��... ���.. �ٺ��� �ƴ���?", "�α��� ����", 1);
						else JOptionPane.showMessageDialog(null, "�̷� �ٺ��� �Բ� ���ؾ� �ϴٴ�...", "WTF", 1);
						adminLogInFailureCount=0;
						mainFrame.getMainCards().show(mainFrame.getContentPane(), "asp");
					}else {
						if(adminLogInFailureCount==0) {
							cagc.adminLoginInfoFileCreate();
							JOptionPane.showMessageDialog(null, "����� ����̱���...\n������ ���̵�� ��й�ȣ�� �̹� �־������ϴ�...", "�ƴ� �̰� �� XX�� �ƴϰ�.. �α��� ����", 0);
						}else if(adminLogInFailureCount==1){
							JOptionPane.showMessageDialog(null, "�������� �ٴ�, �װ��� ����� ������ �ֽ��ϴ�.", "�� ���� ��Ʈ�δ� �����ϴ� ���ΰ�?", 2);
						}else if(adminLogInFailureCount>=2) {
							int result=JOptionPane.showConfirmDialog(null, "��.... �ٺ���� �����ϸ� ���� �˷��帮����", "�� XX �� XX �� XX", JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.CLOSED_OPTION) {
							}else if(result == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "�׳� \"�� ����\"�� ���ְڴ�.. ȥ�� �ְ� �ʹ�..", "�����ߴ�..", 3);
							}else {
							}
						}
						adminLogInFailureCount++;
					}
					
				}else {
					//CafeMemberController�� �α��� ȭ�� �ҷ����� 
					boolean result=cmc.memberSignIn(idtextField.getText(), passwordField.getText());
					//�α��� ���� �ҷ��ͼ� �Ѱ��ֱ�...?
					
					if(result) {
						JOptionPane.showMessageDialog(null, cmc.memberInformation().getNickname()+"��, ȯ���մϴ�.", "�α��� ����", 1);
						mainFrame.getMainCards().show(mainFrame.getContentPane(), "msp");
						mainFrame.getMsp().getMmp().setCmc(cmc);
						mainFrame.getMsp().getMmp().renewTexts();
					}
					else JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�.", "���̵�/��й�ȣ ����", 1);
				}
				idtextField.setText("");
				passwordField.setText("");
			}
		});
		login.setBounds(339, 701, 84, 42);
		add(login);

		//���ȭ�� �ֱ� 
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
