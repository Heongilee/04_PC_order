package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Login;

public class MyFrame extends JFrame{
	private JButton btn = new JButton("test");
	public MyFrame() {
		super("MVC Modeling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btn.addActionListener(new AL());
		c.add(btn);
		
		setSize(300, 300);
		setVisible(true);
	}
	public class AL implements ActionListener, Login{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("test")) {
				System.out.println("[1] : 정상 작동");
				this.Submit();
			}
		}
		@Override
		public void Submit() {
			System.out.println("[2] : 정상 작동");
		}
		@Override
		public void Register() {
		}
	}
}