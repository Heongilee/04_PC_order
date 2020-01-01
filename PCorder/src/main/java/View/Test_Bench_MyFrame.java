package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.I_Login;

public class Test_Bench_MyFrame extends JFrame{
//	private JButton[] btn = new JButton[3];	//리스너 핸들러를 작동시킬 3개의 JButton
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
//				btn[i].setText("Submit() 버튼 이에오");
//				break;
//			case 1:
//				btn[i].setText("Register() 버튼 이에오");
//				break;
//			case 2:
//				btn[i].setText("Mode_Check() 버튼 이에오");
//				break;
//			}
//			btn[i].addActionListener(new MyActionListener());
//			c.add(btn[i]);		
//		}
//		c.addMouseListener(new MyActionListener());
//		
//		setSize(700, 150);
//		//this.pack();	//컴포넌트 사이즈에 맞게 프레임의 크기가 조절된다.
//		setVisible(true);
//		this.setFocusable(true);
//		this.requestFocus();
//	}
//	private class MyActionListener extends MouseAdapter implements ActionListener, I_Login{
//		//인터페이스 리스너 핸들러를 사용할 경우 다음과 같이 작성합니다.
//		//Alt + s, v 단축키를 이용해 자동 메소드 오버라이딩이 가능합니다.
//		
//		///////////////////////////////
//		// I_Login 인터페이스 메소드 오버라이딩
//		///////////////////////////////
//		@Override
//		public void Submit() {
//			System.out.println("Submit()버튼이 눌렀어여");
//		}
//
//		@Override
//		public void Register() {
//			System.out.println("Register()버튼이 눌렀어여");
//		}
//
//		@Override
//		public void Mode_Check() {
//			System.out.println("Mode_Check()버튼이 눌렀어여");
//		}
//
//		////////////////////////////////
//		// ActionListener 메소드 오버라이딩
//		////////////////////////////////
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton btn = (JButton)e.getSource();
//			if(btn.getText().equals("Submit() 버튼 이에오")) {
//				Submit();
//			}
//			else if(btn.getText().equals("Register() 버튼 이에오")) {
//				Register();
//			}
//			else { //Mode_Check() 버튼 이에오
//				Mode_Check();
//			}
//		}
//
//		///////////////////////////////
//		// MouseAdapter 메소드 오버라이딩
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
//		new Test_Bench_MyFrame();	//스윙 프레임 객체 생성
//	}
}