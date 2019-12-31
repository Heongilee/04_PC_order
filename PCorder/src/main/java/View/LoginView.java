package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Controller.LoginController;
import Controller.SignUpView_Controller;
import View.AdminView;
import View.SignUpView;

public class LoginView extends JFrame{
	private static LoginView LV = new LoginView();
	GUIView GV = GUIView.getInstance();
	CardLayout cardLayout;
	JPanel window;
	SignUpView signUpView;
	AdminView adminView;
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton loginbt, SignUpbtn;
	JLabel idlb;
	JLabel passlb;
	JLabel la;
	boolean flag;
	JRadioButton user = new JRadioButton("user MODE");
	JRadioButton server = new JRadioButton("server MODE");
	ButtonGroup goup = new ButtonGroup();
	
	JToolBar bar = new JToolBar();
	JButton previousBtn = new JButton("< 이전");
	JButton nextBtn = new JButton("> 앞으로");
	
//	JToolBar bar = new JToolBar();

	
	public LoginView() {
		setTitle("로그인");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 툴바 interface
		bar.add(previousBtn);
		add(bar, BorderLayout.NORTH);
		
		goup.add(server);
		goup.add(user);
		Container c = getContentPane();

		try {} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		JLayeredPane layeredpane = new JLayeredPane();
		layeredpane.setBounds(0, 0, 700, 600);
		layeredpane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 600);

		user.setFont(new Font("고딕체", Font.BOLD, 18));
		user.setForeground(Color.BLACK);
		user.setBounds(200, 50, 200, 30);

		layeredpane.add(user);

		server.setFont(new Font("고딕체", Font.BOLD, 18));
		server.setForeground(Color.BLACK);
		server.setBounds(400, 50, 200, 30);

		layeredpane.add(server);

		idlb = new JLabel("아이디");
		idlb.setFont(new Font("고딕체", Font.BOLD, 18));
		idlb.setForeground(Color.BLACK);
		idlb.setBounds(100, 109, 100, 30);
		loginTextField = new JTextField(15);
		loginTextField.setBounds(200, 109, 320, 30);

		layeredpane.add(idlb);
		layeredpane.add(loginTextField);

		passlb = new JLabel("비밀번호");
		passlb.setFont(new Font("고딕체", Font.BOLD, 18));
		passlb.setForeground(Color.BLACK);
		passlb.setBounds(100, 209, 100, 30);
		passwordField = new JPasswordField(15);
		passwordField.setBounds(200, 209, 320, 30);

		layeredpane.add(passlb);
		layeredpane.add(passwordField);

		loginbt = new JButton("로그인");
		loginbt.setBackground(Color.black);
		loginbt.setFont(new Font("고딕체", Font.BOLD, 18));
		loginbt.setForeground(Color.WHITE);
		loginbt.setBounds(240, 300, 200, 48);

		layeredpane.add(loginbt);

		la = new JLabel("or");
		la.setBackground(Color.BLACK);
		la.setFont(new Font("고딕체", Font.PLAIN, 23));
		la.setForeground(Color.BLACK);
		la.setBounds(330, 350, 200, 48);

		layeredpane.add(la);

		SignUpbtn = new JButton("회원가입");
		SignUpbtn.setBackground(Color.black);
		SignUpbtn.setFont(new Font("고딕체", Font.BOLD, 18));
		SignUpbtn.setForeground(Color.WHITE);
		SignUpbtn.setBounds(240, 400, 200, 48);

		layeredpane.add(SignUpbtn);
		layeredpane.add(panel);
		
		//////////////
		window = new JPanel();
		cardLayout = new CardLayout();
		window.setLayout(cardLayout);
		adminView = new AdminView();
		signUpView = new SignUpView();
		window.add(layeredpane, "layer");
		window.add(adminView, "admin");
		window.add(signUpView, "signUp");
		loginbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (server.isSelected()) {
					 cardLayout.show(window, "admin");
				 } else if (user.isSelected()) {
					 setVisible(false);
					 GV.getInstance().setVisible(true);
				 } else {
					 
				 }
			}
		});
		SignUpbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(window, "signUp");
			}
		});

		previousBtn.addActionListener(e -> cardLayout.show(window, "layer"));
		add(window);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public static LoginView getInstance() {
		return LV;
	}
	
	public void addButtonActionListener(ActionListener listener) {
		loginbt.addActionListener(listener);
	}
}