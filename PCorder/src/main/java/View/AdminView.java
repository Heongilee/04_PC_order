package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminView {
	public static class AdminMain extends JFrame {
		//Login_Panel_Component
		JButton cm_btn = new JButton("������");
		JButton pm_btn = new JButton("��ǰ����");
		private LoginPanel LP = new LoginPanel();
		
		private static Container c;
		JPanel panel = new JPanel();
		public AdminMain() {
			super("������ Login");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			c = getContentPane();
			c.setLayout(new BorderLayout());
			
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
			cm_btn.addActionListener(new MyActionListener());
			pm_btn.addActionListener(new MyActionListener());
			LP.add(cm_btn);
			LP.add(pm_btn);
			panel.add(LP);
			c.add(panel, BorderLayout.CENTER);
			setSize(300,300);
			//setLocationRelativeTo(null); //?? 
			setVisible(true);
		}

		public class LoginPanel extends JPanel {
			public LoginPanel() {
				setLayout(new GridLayout(2,1,100,22));
			}
		}	
		private class MyActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton)e.getSource();
				
				if(btn.getText().equals("������")) {
					new CusManager();
				} else { // ��ǰ����
					new ProdManager();
				}
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
