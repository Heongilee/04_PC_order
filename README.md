# 04_PC_order
## ObjectOriented
###04조_객체지향설계기술_PC방 푸드 오더 시스템 및 서버 클라이언트 채팅

since 2019.12.29

##Git 사용방법
로컬/원격 브랜치 조회
>git branch [-r]
r옵션은 원격지 브랜치를 조회할 수 있다.

원격지 브랜치 삭제하기
>git push origin --delete [브랜치명]

원격지 브랜치 변경 사항(아직 로컬에 존재)을 진짜 원격지에 반영하기
>git remote prune origin


[이벤트_처리_인터페이스_링크](https://github.com/Heongilee/04_PC_order/tree/master/PCorder/src/main/java/Controller)

--  위 path의 'I_Login'인터페이스를 예로 들겠습니다.
```java
public interface I_Login {
	// 리스너 핸들러에서 호출시킬 메소드
	void Submit();		//리스너 핸들러에서 JButton 로그인을 눌렀을 때 사용자 뷰/관리자 뷰로 이동.  
	void Register();	//리스너 핸들러에서 JButton 회원가입을 눌렀을 때 회원가입 페이지로 이동
	void Mode_Check();	//관리자 모드인지 사용자 모드인지 체크하는 함수.
}
```

다음과 같은 스윙 프레임을 상속한 하나의 프레임을 예로 들겠습니다.
```java
public class Test_Bench_MyFrame extends JFrame{
	private JButton[] btn = new JButton[3];	//리스너 핸들러를 작동시킬 3개의 JButton
	public Test_Bench_MyFrame() {
		super("My TestBench");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
	
	
		for(int i=0;i<3;i++) {
			switch(i) {
			case 0:
				btn[i].setText("Submit() 버튼 이에오");
				break;
			case 1:
				btn[i].setText("Register() 버튼 이에오");
				break;
			case 2:
				btn[i].setText("Mode_Check() 버튼 이에오");
				break;
			}
			btn[i].addActionListener(new AL());
			c.add(btn[i]);		
		}
		
		setSize(700, 600);
		setVisible(true);
	}
	//////////////////////////
	// 이 부분에 인터페이스와 리스너 핸들러를 구현한 클래스를 정의해줍니다. 
	//////////////////////////
}
```

이와 같이 있다고 했을 때 굵은 주석 부분에 다음과 같이 작성할 수 있습니다.
```java
import Controller.I_Login;

	private class MyActionListener extends MouseAdapter implements ActionListener, I_Login{
		//인터페이스 리스너 핸들러를 사용할 경우 다음과 같이 작성합니다.
		//Alt + s, v 단축키를 이용해 자동 메소드 오버라이딩이 가능합니다.
		
		///////////////////////////////
		// I_Login 인터페이스 메소드 오버라이딩
		///////////////////////////////
		@Override
		public void Submit() {}

		@Override
		public void Register() {}

		@Override
		public void Mode_Check() {}

		////////////////////////////////
		// ActionListener 메소드 오버라이딩
		////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) {
		}

		///////////////////////////////
		// MouseAdapter 메소드 오버라이딩
		////////////////////////////////
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
    }
```

최종적으로 코드를 작성하면 다음과 같이 됩니다.
```java
public class Test_Bench_MyFrame extends JFrame{
	private JButton[] btn = new JButton[3];	//리스너 핸들러를 작동시킬 3개의 JButton
	public Test_Bench_MyFrame() {
		super("My TestBench");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
	
	
		for(int i=0;i<3;i++) {
			btn[i] = new JButton();
			switch(i) {
			case 0:
				btn[i].setText("Submit() 버튼 이에오");
				break;
			case 1:
				btn[i].setText("Register() 버튼 이에오");
				break;
			case 2:
				btn[i].setText("Mode_Check() 버튼 이에오");
				break;
			}
			btn[i].addActionListener(new MyActionListener());
			c.add(btn[i]);		
		}
		c.addMouseListener(new MyActionListener());
		
		setSize(700, 150);
		//this.pack();	//컴포넌트 사이즈에 맞게 프레임의 크기가 조절된다.
		setVisible(true);
		this.setFocusable(true);
		this.requestFocus();
	}
	private class MyActionListener extends MouseAdapter implements ActionListener, I_Login{
		//인터페이스 리스너 핸들러를 사용할 경우 다음과 같이 작성합니다.
		//Alt + s, v 단축키를 이용해 자동 메소드 오버라이딩이 가능합니다.
		
		///////////////////////////////
		// I_Login 인터페이스 메소드 오버라이딩
		///////////////////////////////
		@Override
		public void Submit() {
			System.out.println("Submit()버튼이 눌렀어여");
		}

		@Override
		public void Register() {
			System.out.println("Register()버튼이 눌렀어여");
		}

		@Override
		public void Mode_Check() {
			System.out.println("Mode_Check()버튼이 눌렀어여");
		}

		////////////////////////////////
		// ActionListener 메소드 오버라이딩
		////////////////////////////////
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("Submit() 버튼 이에오")) {
				Submit();
			}
			else if(btn.getText().equals("Register() 버튼 이에오")) {
				Register();
			}
			else { //Mode_Check() 버튼 이에오
				Mode_Check();
			}
		}

		///////////////////////////////
		// MouseAdapter 메소드 오버라이딩
		////////////////////////////////
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			System.out.println("getX() : "+e.getX()+", getY() : "+e.getY());
		}
	}
	
	public static void main(String[] args) {
		new Test_Bench_MyFrame();	//스윙 프레임 객체 생성
	}
}
```
