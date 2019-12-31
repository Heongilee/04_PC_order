package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class SignUpView extends JPanel {// 회원가입화면
	private MainFrame mainf;
	JPanel p = new JPanel();
	JLabel SignUpLabel = new JLabel("회원가입");
	JLabel IdLabel = new JLabel("아이디");
	JLabel PassLabel = new JLabel("비밀번호");
	JLabel NameLabel = new JLabel("닉네임");
	JLabel EmailLabel = new JLabel("이메일");
	CardLayout cardLayout = new CardLayout();////화면 전화/////
	JButton IdOverlapbtn = new JButton("중복확인");
	JButton NameOverlapbtn = new JButton("중복확인");
	JButton EmailOverlapbtn = new JButton("중복확인");
	
	JTextField IdField = new JTextField();
	JTextField PassField = new JTextField();
	JTextField NameField = new JTextField();
	JTextField EmailField = new JTextField();
	JButton btn = new JButton("완료");
	public SignUpView(MainFrame mainf) {
		
		this.mainf = mainf;
		setLayout(null);
		add(SignUpLabel);
		add(IdLabel);
		add(PassLabel);
		add(NameLabel);
		add(EmailLabel);

		SignUpLabel.setFont(new Font("고딕체", Font.BOLD, 30));
		IdLabel.setFont(new Font("고딕체", Font.BOLD, 18));
		PassLabel.setFont(new Font("고딕체", Font.BOLD, 18));
		NameLabel.setFont(new Font("고딕체", Font.BOLD, 18));
		EmailLabel.setFont(new Font("고딕체", Font.BOLD, 18));
		

		add(IdField);
		add(PassField);
		add(NameField);
		add(EmailField);

		
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
		btn.setFont(new Font("고딕체", Font.BOLD, 19));
		btn.setForeground(Color.WHITE);

		btn.setBounds(200, 400, 300, 45);

		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		add(IdOverlapbtn);

		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		add(NameOverlapbtn);

		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		add(EmailOverlapbtn);
	
		add(p);

		// TODO Auto-generated method stub
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt", true));
					bos.write(IdField.getText() + "/");
					bos.write(PassField.getText() + "/");
					bos.write(NameField.getText() + "/");
					bos.write(EmailField.getText() + "/");
					bos.close();
					
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
		
//			dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}
				mainf.change("ChLogin");
			}
		});
	}
}
