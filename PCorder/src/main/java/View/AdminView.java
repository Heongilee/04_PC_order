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
		//Login_Panel_Component
		JButton cm_btn = new JButton("고객관리");
		JButton pm_btn = new JButton("상품관리");
		private LoginPanel LP = new LoginPanel();
		/////////////////////이전 버튼 추가 ///////////////////
		JLabel title = new JLabel("Server Mode");
		private static Container c;
	//	JPanel panel = new JPanel();
		public AdminMain() {
			super("관리자 Login");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLayeredPane layeredpane = new JLayeredPane();
			layeredpane.setBounds(0, 0, 700, 600);
			layeredpane.setLayout(null);

		//	c = getContentPane();
		//	c.setLayout(new BorderLayout());
			
			//panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 80));
		
			cm_btn.setBackground(Color.black);
			cm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
			cm_btn.setForeground(Color.WHITE);
			cm_btn.addActionListener(new MyActionListener());
			
			
			
			pm_btn.setBackground(Color.black);
			pm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
			pm_btn.setForeground(Color.WHITE);
			pm_btn.addActionListener(new MyActionListener());
			
			
			title.setFont(new Font("고딕체", Font.BOLD, 29));
			title.setForeground(Color.BLACK);
	
			
			
			cm_btn.setBounds(200, 200, 300, 60);
	        pm_btn.setBounds(200, 300, 300, 60);
	        title.setBounds(270, 100, 300, 60);
		     
	        
	        layeredpane.add(cm_btn);
	        layeredpane.add(pm_btn);
	        layeredpane.add(title);
		//	panel.add(layeredpane);]
	        pm_btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new ProdManager();
					dispose();
					
				}});
	    
			add(layeredpane);
			//c.add(panel, BorderLayout.CENTER);
		    setSize(700, 600);
			setLocationRelativeTo(null); //?? 
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
				
				if(btn.getText().equals("고객관리")) {
					new CusManager();
				} else { // 상품관리
					new ProdManager();
				}
			}
		}
	}
//	public class MyWinExit extends WindowAdapter {
//        public void windowClosing(WindowEvent we) {
//            System.exit(0); // 윈도 종료
//        }
//    }
//	public static class CustomerWindow extends JFrame {
//		private static Container c;
//		JPanel panel = new JPanel();
//		public CustomerWindow() {
//			super("고객관리창");
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
