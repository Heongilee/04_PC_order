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

public class SignUpView extends JPanel {// 회원가입화면
	LoginView LV = LoginView.getInstance();
	public SignUpView() {
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JLabel SignUpLabel = new JLabel("회원가입");

		JLabel IdLabel = new JLabel("아이디");
		JLabel PassLabel = new JLabel("비밀번호");
		JLabel NameLabel = new JLabel("닉네임");
		JLabel EmailLabel = new JLabel("이메일");

		JButton IdOverlapbtn, NameOverlapbtn, EmailOverlapbtn;
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

		JTextField IdField = new JTextField();
		JTextField PassField = new JTextField();
		JTextField NameField = new JTextField();
		JTextField EmailField = new JTextField();

		add(IdField);
		add(PassField);
		add(NameField);
		add(EmailField);

		JButton btn = new JButton("완료");

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

		IdOverlapbtn = new JButton("중복확인");
		IdOverlapbtn.setBackground(Color.black);
		IdOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		IdOverlapbtn.setForeground(Color.WHITE);
		IdOverlapbtn.setBounds(450, 90, 100, 30);
		add(IdOverlapbtn);

		NameOverlapbtn = new JButton("중복확인");
		NameOverlapbtn.setBackground(Color.black);
		NameOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		NameOverlapbtn.setForeground(Color.WHITE);
		NameOverlapbtn.setBounds(450, 250, 100, 30);
		add(NameOverlapbtn);

		EmailOverlapbtn = new JButton("중복확인");
		EmailOverlapbtn.setBackground(Color.black);
		EmailOverlapbtn.setFont(new Font("고딕체", Font.PLAIN, 14));
		EmailOverlapbtn.setForeground(Color.WHITE);
		EmailOverlapbtn.setBounds(450, 330, 100, 30);
		add(EmailOverlapbtn);

		add(p);

		setSize(700, 600);
		setVisible(true);

		IdOverlapbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "이 아이디 중복 없돠 ~~ ");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "다른 아이디를 입력해주세요");
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
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
					else {
						//
						JOptionPane.showMessageDialog(null, "정보를 다시입력해주세요");
					}
					LoginView.getInstance().cardLayout.show(LoginView.getInstance().window, "layer");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
				}
			}
		});
	}
}
