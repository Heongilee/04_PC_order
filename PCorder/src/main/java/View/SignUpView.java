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
public class SignUpView extends JPanel {// È¸¿ø°¡ÀÔÈ­¸é
	LoginView LV = LoginView.getInstance();
	JPanel p = new JPanel();
	JLabel SignUpLabel = new JLabel("È¸¿ø°¡ÀÔ");
	
	JLabel IdLabel = new JLabel("¾ÆÀÌµð");
	JLabel PassLabel = new JLabel("ºñ¹Ð¹øÈ£");
	JLabel NameLabel = new JLabel("´Ð³×ÀÓ");
	JLabel EmailLabel = new JLabel("ÀÌ¸ÞÀÏ");
	
	public JButton IdOverlapbtn, NameOverlapbtn, EmailOverlapbtn;
	
	public JButton btn = new JButton("¿Ï·á");
=======
public class SignUpView extends JPanel {// íšŒì›ê°€ìž…í™”ë©´
	public LoginView LV = LoginView.getInstance();
	public JPanel p = new JPanel();
	public 	JLabel SignUpLabel = new JLabel("íšŒì›ê°€ìž…");
	public JLabel IdLabel = new JLabel("ì•„ì´ë””");
	public JLabel PassLabel = new JLabel("ë¹„ë°€ë²ˆí˜¸");
	public JLabel NameLabel = new JLabel("ë‹‰ë„¤ìž„");
	public JLabel EmailLabel = new JLabel("ì´ë©”ì¼");
	
	public JTextField IdField = new JTextField();
	public JTextField PassField = new JTextField();
	public JTextField NameField = new JTextField();
	public JTextField EmailField = new JTextField();
	
	public JButton IdOverlapbtn = new JButton("ì¤‘ë³µí™•ì¸");
	public JButton NameOverlapbtn = new JButton("ì¤‘ë³µí™•ì¸");
	public JButton EmailOverlapbtn = new JButton("ì¤‘ë³µí™•ì¸");
	
	public JButton btn = new JButton("ì™„ë£Œ");
>>>>>>> origin/project1
	
	public SignUpView() {
		setLayout(new BorderLayout());
		add(SignUpLabel);
		add(IdLabel);
		add(PassLabel);
		add(NameLabel);
		add(EmailLabel);

		SignUpLabel.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 30));
		IdLabel.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 18));
		PassLabel.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 18));
		NameLabel.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 18));
		EmailLabel.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 18));

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
		btn.setFont(new Font("ê³ ë”•ì²´", Font.BOLD, 19));
		btn.setForeground(Color.WHITE);
		btn.setName("btn");
		btn.setBounds(200, 400, 300, 45);

		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("ê³ ë”•ì²´", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		IdOverlapbtn.setName("IdOverlapbtn");
		add(IdOverlapbtn);

		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("ê³ ë”•ì²´", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		NameOverlapbtn.setName("NameOverlapbtn");
		add(NameOverlapbtn);

		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("ê³ ë”•ì²´", Font.PLAIN, 14));
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
//					JOptionPane.showMessageDialog(null, "ÀÌ ¾ÆÀÌµð Áßº¹ ¾øµÂ ~~ ");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "´Ù¸¥ ¾ÆÀÌµð¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
//				}
//			}
//		});
//		// TODO Auto-generated method stub
//		btn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔÀ» ÃàÇÏÇÕ´Ï´Ù!!");
//					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
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
		
		btn.addActionListener(listener);		//íšŒì›ê°€ìž… ì œì¶œ ë²„íŠ¼.
>>>>>>> origin/project1
	}
}
