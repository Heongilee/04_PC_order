package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.concurrent.Flow;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	private JLabel l = new JLabel("TEST");
	public MyFrame() {
		super("MVC Modeling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(l);
		
		setSize(700, 600);
		setVisible(true);
	}
}
