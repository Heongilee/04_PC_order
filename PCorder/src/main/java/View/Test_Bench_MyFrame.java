package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.I_Login;

public class Test_Bench_MyFrame extends JFrame{
//	private JButton[] btn = new JButton[3];	//������ �ڵ鷯�� �۵���ų 3���� JButton
//	public Test_Bench_MyFrame() {
//		super("My TestBench");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = getContentPane();
//		c.setLayout(new FlowLayout());
//	
//	
//		for(int i=0;i<3;i++) {
//			btn[i] = new JButton();
//			switch(i) {
//			case 0:
//				btn[i].setText("Submit() ��ư �̿���");
//				break;
//			case 1:
//				btn[i].setText("Register() ��ư �̿���");
//				break;
//			case 2:
//				btn[i].setText("Mode_Check() ��ư �̿���");
//				break;
//			}
//			btn[i].addActionListener(new MyActionListener());
//			c.add(btn[i]);		
//		}
//		c.addMouseListener(new MyActionListener());
//		
//		setSize(700, 150);
//		//this.pack();	//������Ʈ ����� �°� �������� ũ�Ⱑ �����ȴ�.
//		setVisible(true);
//		this.setFocusable(true);
//		this.requestFocus();
//	}
//	private class MyActionListener extends MouseAdapter implements ActionListener, I_Login{
//		//�������̽� ������ �ڵ鷯�� ����� ��� ������ ���� �ۼ��մϴ�.
//		//Alt + s, v ����Ű�� �̿��� �ڵ� �޼ҵ� �������̵��� �����մϴ�.
//		
//		///////////////////////////////
//		// I_Login �������̽� �޼ҵ� �������̵�
//		///////////////////////////////
//		@Override
//		public void Submit() {
//			System.out.println("Submit()��ư�� �����");
//		}
//
//		@Override
//		public void Register() {
//			System.out.println("Register()��ư�� �����");
//		}
//
//		@Override
//		public void Mode_Check() {
//			System.out.println("Mode_Check()��ư�� �����");
//		}
//
//		////////////////////////////////
//		// ActionListener �޼ҵ� �������̵�
//		////////////////////////////////
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton btn = (JButton)e.getSource();
//			if(btn.getText().equals("Submit() ��ư �̿���")) {
//				Submit();
//			}
//			else if(btn.getText().equals("Register() ��ư �̿���")) {
//				Register();
//			}
//			else { //Mode_Check() ��ư �̿���
//				Mode_Check();
//			}
//		}
//
//		///////////////////////////////
//		// MouseAdapter �޼ҵ� �������̵�
//		////////////////////////////////
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			super.mouseClicked(e);
//			
//			System.out.println("getX() : "+e.getX()+", getY() : "+e.getY());
//		}
//	}
//	
//	public static void main(String[] args) {
//		new Test_Bench_MyFrame();	//���� ������ ��ü ����
//	}
}