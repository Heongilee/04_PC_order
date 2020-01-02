package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class AdminView extends JPanel {
	// Login_Panel_Component
	protected CardLayout cardLayout;
	protected Container tab;
<<<<<<< HEAD
	public JButton cm_btn = new JButton("��������");
	public JButton pm_btn = new JButton("��ǰ����");
	private LoginPanel LP = new LoginPanel();
	JLabel title = new JLabel("Server Mode");
	private static Container c;
	JButton Previousbtn = new JButton("< ����");
	JButton LogOutbtn = new JButton("�α׾ƿ�");
=======
	public JButton cm_btn = new JButton("고객관리");
	public JButton pm_btn = new JButton("상품관리");
	private LoginPanel LP = new LoginPanel();
	JLabel title = new JLabel("Server Mode");
	private static Container c;
	JButton Previousbtn = new JButton("< 이전");
	JButton LogOutbtn = new JButton("로그아웃");
>>>>>>> origin/project1
	JPanel window;
	LoginView LV = LoginView.getInstance();
	CusManager CM = CusManager.getInstance();
	ProdManager PM = ProdManager.getInstance();
	
	public AdminView() {

		
		JLayeredPane layeredpane = new JLayeredPane();
		layeredpane.setBounds(0, 0, 700, 600);
		layeredpane.setLayout(null);

		setLayout(new BorderLayout());

		cm_btn.setBackground(Color.black);
<<<<<<< HEAD
		cm_btn.setFont(new Font("����ü", Font.BOLD, 19));
		cm_btn.setForeground(Color.WHITE);

		pm_btn.setBackground(Color.black);
		pm_btn.setFont(new Font("����ü", Font.BOLD, 19));
		pm_btn.setForeground(Color.WHITE);

		title.setFont(new Font("����ü", Font.BOLD, 29));
=======
		cm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
		cm_btn.setForeground(Color.WHITE);

		pm_btn.setBackground(Color.black);
		pm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
		pm_btn.setForeground(Color.WHITE);

		title.setFont(new Font("고딕체", Font.BOLD, 29));
>>>>>>> origin/project1
		title.setForeground(Color.BLACK);

		cm_btn.setBounds(200, 200, 300, 60);
		pm_btn.setBounds(200, 300, 300, 60);
		title.setBounds(270, 100, 300, 60);

		layeredpane.add(cm_btn);
		layeredpane.add(pm_btn);
		layeredpane.add(title);
		

		add(layeredpane);
		setSize(700, 600);
		setVisible(true);
		
	}

	public class LoginPanel extends JPanel {
		public LoginPanel() {
			setLayout(new GridLayout(2, 1, 100, 22));
		}
	}

	public void addButtonActionListener(ActionListener listener) {
		cm_btn.addActionListener(listener);
		pm_btn.addActionListener(listener);
	}
}