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

public class SignUpView extends JPanel {// ȸ������ȭ��
	public LoginView LV = LoginView.getInstance();
	public JPanel p = new JPanel();
	public JLabel SignUpLabel = new JLabel("ȸ������");
	public JLabel IdLabel = new JLabel("���̵�");
	public JLabel PassLabel = new JLabel("��й�ȣ");
	public JLabel NameLabel = new JLabel("�г���");
	public JLabel EmailLabel = new JLabel("�̸���");
	
	public JTextField IdField = new JTextField();
	public JTextField PassField = new JTextField();
	public JTextField NameField = new JTextField();
	public JTextField EmailField = new JTextField();
	
	public JButton IdOverlapbtn = new JButton("�ߺ�Ȯ��");
	public JButton NameOverlapbtn = new JButton("�ߺ�Ȯ��");
	public JButton EmailOverlapbtn = new JButton("�ߺ�Ȯ��");
	
	public JButton btn = new JButton("�Ϸ�");
	
	public SignUpView() {
		setLayout(new BorderLayout());
		add(SignUpLabel);
		add(IdLabel);
		add(PassLabel);
		add(NameLabel);
		add(EmailLabel);

		SignUpLabel.setFont(new Font("���ü", Font.BOLD, 30));
		IdLabel.setFont(new Font("���ü", Font.BOLD, 18));
		PassLabel.setFont(new Font("���ü", Font.BOLD, 18));
		NameLabel.setFont(new Font("���ü", Font.BOLD, 18));
		EmailLabel.setFont(new Font("���ü", Font.BOLD, 18));

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
		btn.setFont(new Font("���ü", Font.BOLD, 19));
		btn.setForeground(Color.WHITE);
		btn.setName("btn");
		btn.setBounds(200, 400, 300, 45);

		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		IdOverlapbtn.setName("IdOverlapbtn");
		add(IdOverlapbtn);

		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		NameOverlapbtn.setName("NameOverlapbtn");
		add(NameOverlapbtn);

		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		EmailOverlapbtn.setName("EmailOverlapbtn");
		add(EmailOverlapbtn);

		add(p);

		setSize(700, 600);
		setVisible(true);
	}
	
	public void addButtonActionListener(ActionListener listener) {
		IdOverlapbtn.addActionListener(listener);
		NameOverlapbtn.addActionListener(listener);
		EmailOverlapbtn.addActionListener(listener);
		
		btn.addActionListener(listener);		//ȸ������ ���� ��ư.
	}
}
