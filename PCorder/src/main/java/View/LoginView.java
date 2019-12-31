package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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

import View.AdminView;
import View.SignUpView;

public class LoginView extends JFrame{
	private static LoginView LV = new LoginView();
	public GUIView GV = GUIView.getInstance();
	public CardLayout cardLayout;
	public JPanel window;
	public SignUpView signUpView;
	public AdminView adminView;
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	public JButton loginbt, SignUpbtn;
	JLabel idlb;
	JLabel passlb;
	JLabel la;
	boolean flag;
	public JRadioButton user = new JRadioButton("user MODE");
	public JRadioButton server = new JRadioButton("server MODE");
	ButtonGroup goup = new ButtonGroup();
	
	JToolBar bar = new JToolBar();
	public JButton previousBtn = new JButton("< ����");
	
	private LoginView() {
		setTitle("�α���");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ���� interface
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

		user.setFont(new Font("���ü", Font.BOLD, 18));
		user.setForeground(Color.BLACK);
		user.setBounds(200, 50, 200, 30);

		layeredpane.add(user);

		server.setFont(new Font("���ü", Font.BOLD, 18));
		server.setForeground(Color.BLACK);
		server.setBounds(400, 50, 200, 30);

		layeredpane.add(server);

		idlb = new JLabel("���̵�");
		idlb.setFont(new Font("���ü", Font.BOLD, 18));
		idlb.setForeground(Color.BLACK);
		idlb.setBounds(100, 109, 100, 30);
		loginTextField = new JTextField(15);
		loginTextField.setBounds(200, 109, 320, 30);

		layeredpane.add(idlb);
		layeredpane.add(loginTextField);

		passlb = new JLabel("��й�ȣ");
		passlb.setFont(new Font("���ü", Font.BOLD, 18));
		passlb.setForeground(Color.BLACK);
		passlb.setBounds(100, 209, 100, 30);
		passwordField = new JPasswordField(15);
		passwordField.setBounds(200, 209, 320, 30);

		layeredpane.add(passlb);
		layeredpane.add(passwordField);

		loginbt = new JButton("�α���");
		loginbt.setBackground(Color.black);
		loginbt.setFont(new Font("���ü", Font.BOLD, 18));
		loginbt.setForeground(Color.WHITE);
		loginbt.setBounds(240, 300, 200, 48);

		layeredpane.add(loginbt);

		la = new JLabel("or");
		la.setBackground(Color.BLACK);
		la.setFont(new Font("���ü", Font.PLAIN, 23));
		la.setForeground(Color.BLACK);
		la.setBounds(330, 350, 200, 48);

		layeredpane.add(la);

		SignUpbtn = new JButton("ȸ������");
		SignUpbtn.setBackground(Color.black);
		SignUpbtn.setFont(new Font("���ü", Font.BOLD, 18));
		SignUpbtn.setForeground(Color.WHITE);
		SignUpbtn.setBounds(240, 400, 200, 48);

		layeredpane.add(SignUpbtn);

		layeredpane.add(panel);

		window = new JPanel();
		cardLayout = new CardLayout();
		window.setLayout(cardLayout);
		adminView = new AdminView();
		signUpView = new SignUpView();
		window.add(layeredpane, "layer");
		window.add(adminView, "admin");
		window.add(signUpView, "signUp");
		
		add(window);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static LoginView getInstance() {
		return LV;
	}
	public void addButtonActionListener(ActionListener listener) {
		loginbt.addActionListener(listener);
		SignUpbtn.addActionListener(listener);
		previousBtn.addActionListener(listener);
	}
}