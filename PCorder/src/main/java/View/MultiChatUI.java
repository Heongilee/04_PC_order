package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MultiChatUI extends JFrame{
	private JPanel loginPanel;		// �α��� �г�
	private JPanel logoutPanel;		// �α׾ƿ� �г�
	
	public CardLayout cardLayout;
	public Container tab = null;	// ȭ�� ���� ��ȯ�� ���� ī�� ���̾ƿ�
	
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
		loginButton = new JButton("�α���");
		inLabel = new JLabel("��ȭ��");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		outLabel = new JLabel();
		logoutButton = new JButton("�α׾ƿ�");
		
		logoutPanel.add(outLabel, BorderLayout.WEST);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
		exitButton = new JButton("����");
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