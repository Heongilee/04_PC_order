package View;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	 JPanel panel = new JPanel();//////////
	 CardLayout cardLayout = new CardLayout();///////
	    	    
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton loginbt,SignUpbtn;
	JLabel idlb;
	JLabel passlb;
	JLabel la ; 
	JRadioButton user = new JRadioButton("user MODE");
	JRadioButton server = new JRadioButton("server MODE");
	ButtonGroup goup = new ButtonGroup();
	AdminView ad = new AdminView();
	
	public static void main(String[] args) {
		new LoginView();
	}

	public LoginView() {
		
		setSize(700, 600);		
		setLayout(null);
		goup.add(server);
		goup.add(user);
		panel.setLayout(cardLayout);////////
		  
	  
		try {
		//	img = ImageIO.read(new File("img/login.jpg"));//img/login.jpg
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		JPanel layeredpane = new JPanel();
		layeredpane.setBounds(0, 0, 700, 600);
		layeredpane.setLayout(null);
		

		
	
		
	//	MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 700, 600);

		//idlb = new JLabel("아이디");
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
		loginbt.setBounds(240,300, 200, 48);
		
	
		
		 panel.add(layeredpane, "link1");
	     panel.add(ad, "link2");
	      
	      
		loginbt.addActionListener(e -> cardLayout.show(panel, "link2"));
		
		
		
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
		
//		layeredpane.add(panel);
		
	
		add(panel);

		setVisible(true);
		
	}
	
	

	class MyPanel extends JPanel { 
		public void paint(Graphics g) {
			//g.drawImage(img, 0, 0, 700, 600, null);
		}

	}

}