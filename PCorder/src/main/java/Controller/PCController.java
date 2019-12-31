package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Model.Customers_DAO;
import Model.Message;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

public class PCController{
	private final LoginView LV;
	private final CusManager CM;
	private final ProdManager PM;
	private final AdminView AV;
	private final SignUpView SUV;
	private final C_login cl;
	private final C_SignUp cs;
	private final PCChatData chatData;
	private static Customers_DAO dao;
	
	Gson gson = new Gson();
	
	// 메시지 클래스 참조 객체
	Message m;
	// 로거 객체
	Logger logger;
	
	String ip = "127.0.0.1";
	Socket socket;
	BufferedReader inMsg;
	PrintWriter outMsg;
	Thread thread;
	boolean status;
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, AdminView AV, SignUpView SUV, C_login cl, C_SignUp cs, PCChatData chatData) {
		// 로거 객체 초기화
		logger = Logger.getLogger(this.getClass().getName());
		
		this.LV = LV;				// LoginView 참조객체 연결
		this.CM = CM;				// CusManager 참조객체 연결
		this.PM = PM;				// ProdManager 참조객체 연결
		this.AV = AV;				// AdminView 참조객체 연결
		this.SUV = SUV;				// SignUpView 참조객체 연결
		this.cl = cl;				// C_login 참조객체 연결
		this.cs = cs;				// C_SignUp 참조객체 연결
		
		this.chatData = chatData;	// PCChatData 참조객체 연결
	}
	public void appMain() {
		
		//로그인 뷰 이벤트 처리
		LV.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) {
					if (LV.server.isSelected()) {
						 LV.cardLayout.show(LV.window, "admin");
						 System.out.println("Server");
						 cl.Mode_Check();
					 } else if (LV.user.isSelected()) {
						 LV.setVisible(false);
						 LV.GV.getInstance().setVisible(true);
						 System.out.println("User");
						 cl.Mode_Check();
					 } else {
						 
					 }
				 } else if (obj == LV.SignUpbtn) {
					 LV.cardLayout.show(LV.window, "signUp");
				 } else if (obj == LV.previousBtn){
					 LV.cardLayout.show(LV.window, "layer");
				 } else {
					 
				 }
			}
		});
		
		//로그인 뷰->관리자 뷰 이벤트 처리		
		LV.adminView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		
		//로그인 뷰->회원가입 뷰 이벤트 처리
		LV.signUpView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				//SignUpView에서 setName한 값을 가지고 if-else문으로 분기조건을 주었다.
				if(btn.getName().equals("IdOverlapbtn")) {
					cs.Valid_Check(0);
				}
				else if(btn.getName().equals("NameOverlapbtn")) {
					cs.Valid_Check(1);
				}
				else if(btn.getName().equals("EmailOverlapbtn")) {
					cs.Valid_Check(2);
				}
				else { //회원가입 제출 버튼 (btn)
					try {
						cs.Register_Complete();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		//고객 관리 이벤트 처리
		CM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) {
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
					cl.Mode_Check();
				 } else if (obj == CM.previousBtn) {
					 CM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 cl.Mode_Check();
				 } else if (obj == CM.logoutBtn){
					 CM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					 cl.Mode_Check();
				 } else {
					 
				 }
			}
		});
		
		//상품 관리 이벤트 처리
		PM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				 if (obj == PM.previousBtn) {
					 PM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 cl.Mode_Check();
				 } else if (obj == PM.logoutBtn){
					 PM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					 cl.Mode_Check();
				 } else {
					 
				 }
			}
		});
	}
//	public void connectServer() {
//		try {
//			// 소켓 생성
//			socket = new Socket(ip, 8888);
//			logger.info("[Client]Server 연결 성공!!");
//			
//			// 입출력 스트림 생성
//			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			outMsg = new PrintWriter(socket.getOutputStream(), true);
//			
//			// 서버에 로그인 메시지 전달
//			m = new Message(v.id, "", "", "login", "");
//			outMsg.println(gson.toJson(m));
//			
//			// 메시지 수신을 위한 스레드 생성
//			thread = new Thread(this);
//			thread.start();
//		} catch (Exception e) {
//			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception 발생!!");
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public void run() {
//		// 수신 메시지를 처리하는 데 필요한 변수 선언
//		String msg;
//		status = true;
//		
//		while(status) {
//			try {
//				// 메시지 수신 및 파싱
//				msg = inMsg.readLine();
//				m = gson.fromJson(msg, Message.class);
//				String whisperMsg = "";
//				
//				// MultiChatData 객체로 데이터 갱신
//				chatData.refreshData(m.getId() + ">" + m.getMsg() + "\n");
//				// 커서를 현재 대화 메시지에 표시
//				v.msgOut.setCaretPosition(v.msgOut.getDocument().getLength());
//			} catch (IOException e) {
//				logger.log(Level.WARNING, "[MultiChatUI]메시지 스트림 종료!!");
//			}
//		}
//		logger.info("[MultiChatUI]" + thread.getName() + " 메시지 수신 스레드 종료됨!!");
//	} // run()
	
//	public static void main(String[] args) {
//		PCController app = new PCController(
//						LoginView.getInstance(), CusManager.getInstance(), 
//						ProdManager.getInstance(), new AdminView(), 
//						new SignUpView(), new C_login(), 
//						new C_SignUp(), new PCChatData()
//						);
//		dao = Customers_DAO.getInstance();
//		app.appMain();
//	}

}
