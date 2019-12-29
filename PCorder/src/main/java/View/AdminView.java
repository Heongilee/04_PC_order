package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class AdminView {
	public static class AdminMain extends JFrame {
		private LoginPanel LP = new LoginPanel();
		private static Container c;
		JPanel panel = new JPanel();
		JButton customerManagement = new JButton("������");
		JButton productManagement = new JButton("��ǰ����");
		JLabel title = new JLabel("Server Mode");
		public AdminMain() {
			super("������ ���");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLayeredPane layeredpane = new JLayeredPane();
			layeredpane.setBounds(0, 0, 700, 600);
			layeredpane.setLayout(null);

		//	c = getContentPane();
		//	c.setLayout(new BorderLayout());
			
			c = getContentPane();
			c.setLayout(new BorderLayout());
			
			
			panel.add(title);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 38));
			panel.add(LP);
			c.add(panel, BorderLayout.CENTER);
			setSize(300,300);
			setLocationRelativeTo(null);
			setVisible(true);
		}

		public class LoginPanel extends JPanel {
			JButton customerManagement = new JButton("������");
			JButton productManagement = new JButton("��ǰ����");
			public LoginPanel() {
				setLayout(new GridLayout(2,1,100,22));
				add(customerManagement);
				add(productManagement);
			}
		}	
	}
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton)e.getSource();
			
			if(btn.getText().equals("������")) {
				
			} else { // ��ǰ����
				
			}
		}
	}
//	public class MyWinExit extends WindowAdapter {
//        public void windowClosing(WindowEvent we) {
//            System.exit(0); // ���� ����
//        }
//    }
//	public static class CustomerWindow extends JFrame {
//		private static Container c;
//		JPanel panel = new JPanel();
//		public CustomerWindow() {
//			super("������â");
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			
//			c = getContentPane();
//			c.setLayout(new BorderLayout());
//			
//			
//			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
//			panel.add(LP);
//			c.add(panel, BorderLayout.CENTER);
//			setSize(300,300);
//			setLocationRelativeTo(null);
//			setVisible(true);
//		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminMain();
	}

}
