package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

<<<<<<< HEAD
public class SignUpView extends JPanel {// 회원가입화면
	LoginView LV = LoginView.getInstance();
	JPanel p = new JPanel();
	JLabel SignUpLabel = new JLabel("회원가입");
	
	JLabel IdLabel = new JLabel("아이디");
	JLabel PassLabel = new JLabel("비밀번호");
	JLabel NameLabel = new JLabel("닉네임");
	JLabel EmailLabel = new JLabel("이메일");
	
	public JButton IdOverlapbtn, NameOverlapbtn, EmailOverlapbtn;
	
	public JButton btn = new JButton("완료");
=======
public class SignUpView extends JPanel {// �쉶�썝媛��엯�솕硫�
	public LoginView LV = LoginView.getInstance();
	public JPanel p = new JPanel();
	public 	JLabel SignUpLabel = new JLabel("�쉶�썝媛��엯");
	public JLabel IdLabel = new JLabel("�븘�씠�뵒");
	public JLabel PassLabel = new JLabel("鍮꾨��踰덊샇");
	public JLabel NameLabel = new JLabel("�땳�꽕�엫");
	public JLabel EmailLabel = new JLabel("�씠硫붿씪");
	
	public JTextField IdField = new JTextField();
	public JTextField PassField = new JTextField();
	public JTextField NameField = new JTextField();
	public JTextField EmailField = new JTextField();
	
	public JButton IdOverlapbtn = new JButton("以묐났�솗�씤");
	public JButton NameOverlapbtn = new JButton("以묐났�솗�씤");
	public JButton EmailOverlapbtn = new JButton("以묐났�솗�씤");
	
	public JButton btn = new JButton("�셿猷�");
>>>>>>> origin/project1
	
	public SignUpView() {
		setLayout(new BorderLayout());
		add(SignUpLabel);
		add(IdLabel);
		add(PassLabel);
		add(NameLabel);
		add(EmailLabel);

		SignUpLabel.setFont(new Font("怨좊뵓泥�", Font.BOLD, 30));
		IdLabel.setFont(new Font("怨좊뵓泥�", Font.BOLD, 18));
		PassLabel.setFont(new Font("怨좊뵓泥�", Font.BOLD, 18));
		NameLabel.setFont(new Font("怨좊뵓泥�", Font.BOLD, 18));
		EmailLabel.setFont(new Font("怨좊뵓泥�", Font.BOLD, 18));

		add(IdField);
		add(PassField);
		add(NameField);
		add(EmailField);
<<<<<<< HEAD


=======
>>>>>>> origin/project1
		add(btn);

		SignUpLabel.setBounds(300, 0, 130, 100);

		IdLabel.setBounds(70, 90, 100, 30);
		PassLabel.setBounds(70, 170, 100, 30);
		NameLabel.setBounds(70, 250, 100, 30);
		EmailLabel.setBounds(70, 330, 100, 30);

		IdField.setBounds(170, 90, 250, 30);
		PassField.setBounds(170, 170, 250, 30);
		NameField.setBounds(170, 250, 250, 30);
		EmailField.setBounds(170, 330, 250, 30);

		btn.setBackground(Color.black);
		btn.setFont(new Font("怨좊뵓泥�", Font.BOLD, 19));
		btn.setForeground(Color.WHITE);
		btn.setName("btn");
		btn.setBounds(200, 400, 300, 45);

		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("怨좊뵓泥�", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		IdOverlapbtn.setName("IdOverlapbtn");
		add(IdOverlapbtn);

		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("怨좊뵓泥�", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		NameOverlapbtn.setName("NameOverlapbtn");
		add(NameOverlapbtn);

		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("怨좊뵓泥�", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		EmailOverlapbtn.setName("EmailOverlapbtn");
		add(EmailOverlapbtn);

		add(p);

		setSize(700, 600);
		setVisible(true);
<<<<<<< HEAD

//		IdOverlapbtn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					JOptionPane.showMessageDialog(null, "이 아이디 중복 없돠 ~~ ");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "다른 아이디를 입력해주세요");
//				}
//			}
//		});
//		// TODO Auto-generated method stub
//		btn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
//					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
//				}
//			}
//
//		});
	}
	public void addButtonActionListener(ActionListener listener) {
		IdOverlapbtn.addActionListener(listener);
		btn.addActionListener(listener);
=======
	}
	
	public void addButtonActionListener(ActionListener listener) {
		IdOverlapbtn.addActionListener(listener);
		NameOverlapbtn.addActionListener(listener);
		EmailOverlapbtn.addActionListener(listener);
		
		btn.addActionListener(listener);		//�쉶�썝媛��엯 �젣異� 踰꾪듉.
>>>>>>> origin/project1
	}
}
