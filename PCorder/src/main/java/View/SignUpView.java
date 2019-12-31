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

import Model.Customer_DTO;
import Model.Customers_DAO;

public class SignUpView extends JPanel {// ȸ������ȭ��
	LoginView LV = LoginView.getInstance();
	public SignUpView() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JLabel SignUpLabel = new JLabel("ȸ������");

		JLabel IdLabel = new JLabel("���̵�");
		JLabel PassLabel = new JLabel("��й�ȣ");
		JLabel NameLabel = new JLabel("�г���");
		JLabel EmailLabel = new JLabel("�̸���");

		JButton IdOverlapbtn, NameOverlapbtn, EmailOverlapbtn;
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

		JTextField IdField = new JTextField();
		JTextField PassField = new JTextField();
		JTextField NameField = new JTextField();
		JTextField EmailField = new JTextField();

		add(IdField);
		add(PassField);
		add(NameField);
		add(EmailField);

		JButton btn = new JButton("�Ϸ�");

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

		IdOverlapbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "�� ���̵� �ߺ� ���� ~~ ");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "�ٸ� ���̵� �Է����ּ���");
				}
			}
		});
		// TODO Auto-generated method stub
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Customer_DTO dto = new Customer_DTO(IdField.getText(), PassField.getText(), NameField.getText(), EmailField.getText(), 1, 0);
					Customers_DAO dao = Customers_DAO.getInstance();
					if(dao.insert(dto))
						JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
					else {
						//
						JOptionPane.showMessageDialog(null, "������ �ٽ��Է����ּ���");
					}
					LoginView.getInstance().cardLayout.show(LoginView.getInstance().window, "layer");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
				}
			}
		});
	}
}
