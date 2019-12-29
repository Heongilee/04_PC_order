package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GUIView extends JFrame{
	boolean toggle = true;
	JPanel np1 = new JPanel();//위쪽 전체 패널
	JPanel ninp = new JPanel();//위쪽 오른쪽 라벨 패털
	JPanel wp2 = new JPanel();//왼쪽 패널
	JPanel crp1 = new JPanel();//가운데 스크롤 패널
	JPanel crp2 = new JPanel();//가운데 오른쪽 패널
	JPanel crp3 = new JPanel();//가운데 아래 패널
	JPanel cp3 = new JPanel();//가운데 패널
	JPanel ctopp = new JPanel();//가운데 오른쪽 위쪽 패널
	JLabel cl1 = new JLabel("주문내역");
	JLabel cl2 = new JLabel("상품명                  가격                   개수");
	JTextArea ta1 = new JTextArea();//가운데 센터 텍스트
	JTextField tf1 = new JTextField("합계    ");//합계 텍스트 필드
	JButton sumb = new JButton("결제");
	JPanel ep4 = new JPanel();//오른쪽 채팅 패널
	JTextArea ta2 = new JTextArea();//오른쪽 텍스트
	JLabel cha = new JLabel("Chatting");
	String ca[] = {"BEST3", "라면류", "음료류", "간식류", "과자류"};
	JList<String> jl= new JList<String>();//왼쪽 패널 리스트
	JLabel wea = new JLabel("날씨");
	JLabel mess = new JLabel("메시지");
	JLabel pro = new JLabel("상품 분류");
	JPanel topp = new JPanel();//가운데 왼쪽 패널에 위 레이블 들
	JLabel Listl1 = new JLabel("상품이름");
	JLabel Listl2 = new JLabel("가격");
	String upin[] = {"아이디", "로그인 시간", "포인트"}; 
	ArrayList<String> menuList = new ArrayList<String>();//디비에서 가져온 메뉴 리스트
	
	GUIView(){
		setTitle("PC방 푸드 오더 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));
		
		//위쪽 패널 구성
		ninp.setLayout(new GridLayout(3,1));
		for(int i = 0; i<3;i++) {//위쪽 레이블
			ninp.add(new JLabel(upin[i]));
		}
		np1.setLayout(new BorderLayout(10, 10));
		mess.setHorizontalAlignment(JLabel.CENTER);
		mess.setFont(new Font("돋움", Font.PLAIN, 30));
		np1.add(mess, BorderLayout.NORTH);
		np1.add(ninp, BorderLayout.EAST);
		np1.add(wea, BorderLayout.WEST);
		if(toggle == true) 
			np1.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		//왼쪽 패널 구성
		
		wp2.setLayout(new GridLayout(6, 1));
		pro.setHorizontalAlignment(JLabel.CENTER);
		wp2.add(pro);
		for(int i = 0;i < 5;i++) {
			wp2.add(new JButton(ca[i]));
		}
		if(toggle == true) 
			wp2.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		//가운데 패널 구성
		cp3.setLayout(new BorderLayout(10, 10));
		crp1.setLayout(new BorderLayout());
		crp1.setPreferredSize(new Dimension(200, 10));
		crp2.setLayout(new BorderLayout());
		crp3.setLayout(new GridLayout(1, 2));
		topp.setLayout(new BorderLayout());
		ctopp.setLayout(new BorderLayout());
		
		Listl1.setHorizontalAlignment(JLabel.LEFT);
		Listl2.setHorizontalAlignment(JLabel.RIGHT);
		topp.add(Listl1,BorderLayout.WEST);
		topp.add(Listl2, BorderLayout.EAST);
	
		jl.add(new ScrollPane());
		crp1.add(topp, BorderLayout.NORTH);
		crp1.add(jl, BorderLayout.CENTER);
		
		
		ctopp.add(cl1, BorderLayout.NORTH);
		ctopp.add(cl2, BorderLayout.SOUTH);
		
		crp2.add(ctopp, BorderLayout.NORTH);
		crp2.add(ta1, BorderLayout.CENTER);
		crp2.add(crp3, BorderLayout.SOUTH);
		crp3.add(tf1);
		crp3.add(sumb);
		
		if(toggle == true) 
			crp1.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		if(toggle == true) 
			crp2.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		cp3.add(crp1, BorderLayout.WEST);
		cp3.add(crp2, BorderLayout.CENTER);
		
		//오른쪽 패널 구성
		ep4.setLayout(new BorderLayout(10,0));
		ep4.setPreferredSize(new Dimension(300, 10));
		cha.setHorizontalAlignment(JLabel.CENTER);
		ep4.add(cha, BorderLayout.NORTH);
		ep4.add(ta2, BorderLayout.CENTER);
		ep4.add(new JTextField(), BorderLayout.SOUTH);
		
		if(toggle == true) 
			ep4.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		c.add(np1, BorderLayout.NORTH);
		c.add(wp2, BorderLayout.WEST);
		c.add(cp3, BorderLayout.CENTER);
		c.add(ep4, BorderLayout.EAST);
		
		setSize(900, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIView();
	}

}