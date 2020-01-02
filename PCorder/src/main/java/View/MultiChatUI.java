package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MultiChatUI extends JFrame{
<<<<<<< HEAD
	private JPanel loginPanel;		// ·Î±×ÀÎ ÆÐ³Î
	private JPanel logoutPanel;		// ·Î±×¾Æ¿ô ÆÐ³Î
	
	public CardLayout cardLayout;
	public Container tab = null;	// È­¸é ±¸¼º ÀüÈ¯À» À§ÇÑ Ä«µå ·¹ÀÌ¾Æ¿ô
=======
	private JPanel loginPanel;		// ë¡œê·¸ì¸ íŒ¨ë„
	private JPanel logoutPanel;		// ë¡œê·¸ì•„ì›ƒ íŒ¨ë„
	
	public CardLayout cardLayout;
	public Container tab = null;	// í™”ë©´ êµ¬ì„± ì „í™˜ì„ ìœ„í•œ ì¹´ë“œ ë ˆì´ì•„ì›ƒ
>>>>>>> origin/project1
	
	public JPanel msgPanel = new JPanel();
	public JButton loginButton;
	public JLabel inLabel;
	public JLabel outLabel;
	public JTextField idInput;
	public JButton logoutButton;
	public JTextField msgInput = new JTextField(15);
	public JButton exitButton;
	public JTextArea msgOut = new JTextArea();
	public String id = "";
	public MultiChatUI() {
		setTitle(":: MultiChat ::");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		
		idInput = new JTextField(15);
<<<<<<< HEAD
		loginButton = new JButton("·Î±×ÀÎ");
		inLabel = new JLabel("´ëÈ­¸í");
=======
		loginButton = new JButton("ë¡œê·¸ì¸");
		inLabel = new JLabel("ëŒ€í™”ëª…");
>>>>>>> origin/project1
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		outLabel = new JLabel();
<<<<<<< HEAD
		logoutButton = new JButton("·Î±×¾Æ¿ô");
=======
		logoutButton = new JButton("ë¡œê·¸ì•„ì›ƒ");
>>>>>>> origin/project1
		
		logoutPanel.add(outLabel, BorderLayout.WEST);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
<<<<<<< HEAD
		exitButton = new JButton("Á¾·á");
=======
		exitButton = new JButton("ì¢…ë£Œ");
>>>>>>> origin/project1
		msgPanel.setLayout(new BorderLayout());
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		
		tab = new JPanel();
		
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		msgOut = new JTextArea("", 10, 30);
		msgOut.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		c.add(tab, BorderLayout.NORTH);
		c.add(jsp, BorderLayout.CENTER);
		c.add(msgPanel, BorderLayout.SOUTH);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	public void addButtonActionListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);
	}
}