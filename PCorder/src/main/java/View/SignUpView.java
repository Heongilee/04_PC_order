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
	public int test_data = 50;
	public JLabel IdLabel = new JLabel("���̵�");
	public JLabel PassLabel = new JLabel("��й�ȣ");
	public JLabel NameLabel = new JLabel("�г���");
	public JLabel EmailLabel = new JLabel("�̸���");
	
	public JButton IdOverlapbtn, NameOverlapbtn, EmailOverlapbtn;
	public JTextField IdField = new JTextField();
	public JTextField PassField = new JTextField();
	public JTextField NameField = new JTextField();
	public JTextField EmailField = new JTextField();
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

		btn.setBounds(200, 400, 300, 45);

		IdOverlapbtn = new JButton("�ߺ�Ȯ��");
		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		add(IdOverlapbtn);

		NameOverlapbtn = new JButton("�ߺ�Ȯ��");
		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		add(NameOverlapbtn);

		EmailOverlapbtn = new JButton("�ߺ�Ȯ��");
		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		add(EmailOverlapbtn);

		add(p);

		setSize(700, 600);
		setVisible(true);

//		IdOverlapbtn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				try {
//
//					JOptionPane.showMessageDialog(null, "�� ���̵� �ߺ� ���� ~~ ");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "�ٸ� ���̵� �Է����ּ���");
//				}
//			}
//		});
//		// TODO Auto-generated method stub
//		btn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
//					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
//				}
//			}
//
//		});
	}
	public void addButtonActionListener(ActionListener listener) {
		IdOverlapbtn.addActionListener(listener);
		btn.addActionListener(listener);
	}
}
