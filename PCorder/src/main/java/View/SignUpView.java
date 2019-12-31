package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

public class SignUpView extends JPanel {// ȸ������ȭ��
	JPanel p = new JPanel();
	JLabel SignUpLabel = new JLabel("ȸ������");
	JLabel IdLabel = new JLabel("���̵�");
	JLabel PassLabel = new JLabel("��й�ȣ");
	JLabel NameLabel = new JLabel("�г���");
	JLabel EmailLabel = new JLabel("�̸���");
	JTextField IdField = new JTextField();
	JTextField PassField = new JTextField();
	JTextField NameField = new JTextField();
	JTextField EmailField = new JTextField();
	JButton btn = new JButton("�Ϸ�");
	
	JButton IdOverlapbtn = new JButton("�ߺ�Ȯ��");		// ���̵� �ߺ� Ȯ��
	JButton NameOverlapbtn = new JButton("�ߺ�Ȯ��");		// �г��� �ߺ� Ȯ��
	JButton EmailOverlapbtn = new JButton("�ߺ�Ȯ��");		// �̸��� �ߺ� Ȯ��
	
	public SignUpView() {
		this.setLayout(new BorderLayout());
		
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

		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		add(IdOverlapbtn);

		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		add(NameOverlapbtn);

		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("���ü", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		add(EmailOverlapbtn);

		add(p);

		setSize(700, 600);
		setVisible(true);
//		setTitle("ȸ������");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ�����.txt", true));
//					bos.write(IdField.getText() + "/");
//					bos.write(PassField.getText() + "/");
//					bos.write(NameField.getText() + "/");
//					bos.write(EmailField.getText() + "/");
//					bos.close();
//					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
//					//dispose();
//				} catch (Exception ex) {
//					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
//				}
//			}
//
//		});
	}
	
	public void addButtonActionListener(ActionListener lis) {
		btn.addActionListener(lis);				// Submit ��ư
		IdOverlapbtn.addActionListener(lis);	// ���̵� �ߺ� üũ
		NameOverlapbtn.addActionListener(lis);	// �г��� �ߺ� üũ
		EmailOverlapbtn.addActionListener(lis);	// �̸��� �ߺ� üũ
	}

	public static void main(String[] args) {
		new SignUpView();

	}
	
}
