package Controller;

<<<<<<< HEAD
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JButton;
>>>>>>> origin/project1
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;

=======
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Model.Customers_DAO;
>>>>>>> origin/project1
import Model.Message;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

public class PCController implements Runnable {
<<<<<<< HEAD
	private final LoginView LV;
	private final CusManager CM;
	private final ProdManager PM;
	private final GUIView GUI;
	private final AdminView AV;
	private final SignUpView SUV;
	private final C_login cl;

	private final PCChatData CMchatData;
	private final PCChatData GUIchatData;
	
//	ArrayList<>
	
//	JViewport jp = new JViewport();
//	JPanel panel = new JPanel();
//	CardLayout card = new CardLayout();
//	panel.setLayout(card);
//	panel.add(vp, "hoit");
//	panel.add(jp, "hosss");
//	
//	add(panel, BorderLayout.CENTER);
//	card.show(panel, "hoit");
	
	Gson gson = new Gson();

	// �޽��� Ŭ���� ���� ��ü
	Message m;
	// �ΰ� ��ü
	Logger logger;

=======
	public final LoginView LV;
	public final CusManager CM;
	public final ProdManager PM;
	public final GUIView GUI;
	public final AdminView AV;
	public final SignUpView SUV;
	public final C_login cl;
	public final C_SignUp cs;
	public final C_ProdManager cp;
	public final PCChatData chatData;
	public final PCChatData chatData2;
	public static Customers_DAO dao;

	Gson gson = new Gson();

	// 메시지 클래스 참조 객체
	Message m;
	// 로거 객체
	Logger logger;
>>>>>>> origin/project1
	String ip = "127.0.0.1";
	Socket socket;
	BufferedReader inMsg;
	PrintWriter outMsg;
	Thread thread;
	boolean status;
<<<<<<< HEAD

	boolean comboFlag = false;
<<<<<<< HEAD
	
=======
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV,
			C_login cl, PCChatData CMchatData, PCChatData GUIchatData) {
		// �ΰ� ��ü �ʱ�ȭ
		logger = Logger.getLogger(this.getClass().getName());

		this.LV = LV;
		this.CM = CM;
		this.PM = PM;
		this.GUI = GUI;
		this.AV = AV;
		this.SUV = SUV;
		this.cl = cl;

		this.CMchatData = CMchatData;
		this.GUIchatData = GUIchatData;
	}

	public void appMain() {
		// ������ ��ü���� ������ ��ȭ�� ó���� UI ��ü �߰�, ta2�� TextArea�̴�.
		CMchatData.addObjCus(CM.chatContent);
		GUIchatData.addObjGUI(GUI.ta2);
		CMchatData.addObjCombo(CM.chatComboBox);
<<<<<<< HEAD
=======
		
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
		LV.addButtonActionListener(new ActionListener() { // �α��� �� ���̾ƿ�
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) { // �α��� ��ư�� ������ ��
					if (LV.server.isSelected()) { // server mode�� üũ �Ǿ����� ���
						LV.cardLayout.show(LV.window, "admin");
						CM.loginFlag = true;
						cl.Mode_Check();
						/* ������ �α��� ���� ��� �̺�Ʈ ó�� */
//						CM.chatContent
						connectServer();
<<<<<<< HEAD
=======
						
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
//						comboFlag = true;
					} else if (LV.user.isSelected()) { // user mode�� üũ �Ǿ����� ���
						LV.setVisible(false);
						LV.GV.getInstance().setVisible(true);
						cl.Mode_Check();
						/* ����� �α��� ���� ��� �̺�Ʈ ó�� */
						GUI.id = LV.loginTextField.getText();
						GUI.la[0].setText("���̵� : " + GUI.id);
						connectServer();
						
//						comboFlag = true;
						
//						dm.addElement(m.getSeat());
//						CM.chatComboBox.setModel(dm);
//						dm.setSelectedItem(m.getSeat());
//						CM.chatComboBox.addItem(m.getSeat());
//						CM.seatPanel.add(CM.chatComboBox);
//						CMchatData.refreshData(CM.chatComboBox);
					} else {

					}
				} else if (obj == LV.SignUpbtn) { // ȸ������ ��ư�� ������ ���
					LV.cardLayout.show(LV.window, "signUp");
					cl.Mode_Check();
				} else if (obj == LV.previousBtn) { // ���� ���� ��ư�� ������ ���
					LV.cardLayout.show(LV.window, "layer");
					cl.Mode_Check();
=======
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV, C_login cl, C_SignUp cs, C_ProdManager cp, PCChatData chatData, PCChatData chatData2) {
		// 로거 객체 초기화
		logger = Logger.getLogger(this.getClass().getName());
		
		this.LV = LV;				// LoginView 참조객체 연결
		this.CM = CM;				// CusManager 참조객체 연결
		this.PM = PM;				// ProdManager 참조객체 연결
		this.GUI = GUI;				// GUIView 참조객체 연결
		this.AV = AV;				// AdminView 참조객체 연결
		this.SUV = SUV;				// SignUpView 참조객체 연결
		this.cl = cl;				// C_login 참조객체 연결
		this.cs = cs;				// C_SignUp 참조객체 연결
		this.cp = cp;				// C_ProdManager 참조객체 연결
		this.chatData = chatData;	// PCChatData 참조객체 연결
		this.chatData2 = chatData2;	// PCChatData2 참조객체 연결
	}

	public void appMain() {
		// 데이터 객체에서 데이터 변화를 처리할 UI 객체 추가, ta2는 TextArea이다.
		chatData.addObjCus(CM.chatContent);
		chatData2.addObjGUI(GUI.ta2);
		
		// 로그인 뷰 이벤트 처리
		LV.addButtonActionListener(new ActionListener() { // 로그인 뷰 레이아웃
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) { // 로그인 버튼을 눌렀을 때
					if (LV.server.isSelected()) { // server mode에 체크 되어있을 경우 (관리자 cMODE : 0)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 0)) {
							// ------- 로그인 성공!! -------
							LV.cardLayout.show(LV.window, "admin");
							CM.loginFlag = true;
							
							/* 관리자 로그인 들어갔을 경우 이벤트 처리 */
							connectServer();
						}
						else {
							// ------- 로그인 실패... -------
							return;
						}
						
					} else if (LV.user.isSelected()) { // user mode에 체크 되어있을 경우 (사용자 cMODE : 1)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 1)) {
							// ------- 로그인 성공!! -------
							
							/*	화면 전환	*/
							LV.setVisible(false);
							LV.GV.getInstance().setVisible(true);
							
							/*	사용자 로그인 들어갔을 경우 이벤트 처리	*/
							String id = LV.loginTextField.getText();
							
							GUI.la[0].setText("아이디 : " + id);
							GUI.la[2].setText("포인트 : "+ dao.getInstance().getCash(id));
							connectServer();
						}
						else {
							// ------- 로그인 실패... -------
							return;
						}
					} else {}
				} else if (obj == LV.SignUpbtn) { // 회원가입 버튼을 눌렀을 경우
					LV.cardLayout.show(LV.window, "signUp");
				} else if (obj == LV.previousBtn) { // 툴바 이전 버튼을 눌렀을 경우
					System.out.println("PREV TEST");
					LV.cardLayout.show(LV.window, "layer");
>>>>>>> origin/project1
				} else {

				}
			}
		});
<<<<<<< HEAD
		LV.adminView.addButtonActionListener(new ActionListener() { // ������ �� ���̾ƿ�
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // ������ �信�� ������ ��ư�� ������ ���
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
					
//					comboFlag = true;
				} else if (obj == LV.adminView.pm_btn) { // ������ �信�� ��ǰ���� ��ư�� ������ ���
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
				}
			}
		});
		LV.signUpView.addButtonActionListener(new ActionListener() { // ȸ������ ��
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.signUpView.IdOverlapbtn) { // ȸ������ �信�� �ߺ�Ȯ�� ��ư�� ������ ���
					try {
						JOptionPane.showMessageDialog(null, "�� ���̵� �ߺ� ���� ~~ ");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "�ٸ� ���̵� �Է����ּ���");
					}
					cl.Mode_Check();
				} else if (obj == LV.signUpView.btn) { // ȸ������ �信�� �Ϸ� ��ư�� ������ ���
					try {
						JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
						LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
					}
					cl.Mode_Check();
				}
			}
		});
		CM.addButtonActionListener(new ActionListener() { // ������ ��
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) { // ������ �信�� ä��
					outMsg.println(gson.toJson(new Message("ī����", CM.id, "", CM.chatInput.getText(), "admin", "sendtoall")));
					CM.chatInput.setText("");
					cl.Mode_Check();
				} else if (obj == CM.previousBtn) { // ������ �信�� ���� ��ư�� ������ ���
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					cl.Mode_Check();
				} else if (obj == CM.logoutBtn) { // ������ �信�� �α׾ƿ� ��ư�� ������ ���
=======
		
		//로그인 뷰->관리자 뷰 이벤트 처리
		LV.adminView.addButtonActionListener(new ActionListener() { // 관리자 뷰 레이아웃
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // 관리자 뷰에서 고객관리 버튼을 눌렀을 경우
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				} else if (obj == LV.adminView.pm_btn) { // 관리자 뷰에서 상품관리 버튼을 눌렀을 경우
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				}
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
		
		//고객 관리 뷰 이벤트 처리
		CM.addButtonActionListener(new ActionListener() { // 고객관리 뷰
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) { // 고객관리 뷰에서 채팅
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
				} else if (obj == CM.previousBtn) { // 고객관리 뷰에서 이전 버튼을 눌렀을 경우
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == CM.logoutBtn) { // 고객관리 뷰에서 로그아웃 버튼을 눌렀을 경우
>>>>>>> origin/project1
					CM.chatContent.setText("");
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
<<<<<<< HEAD
					cl.Mode_Check();
				} else if (obj == CM.chatComboBox){
					/*������ â �޺��ڽ� �̺�Ʈ ó��*/
					if(CM.chatComboBox.getSelectedIndex() == 0) {
						
					}
				} else {
					
				}
			}
		});
		PM.addButtonActionListener(new ActionListener() { // ��ǰ���� ��
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == PM.previousBtn) { // ��ǰ���� �信�� ���� ��ư�� ������ ���
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					cl.Mode_Check();
				} else if (obj == PM.logoutBtn) { // ��ǰ���� �信�� �α׾ƿ� ��ư�� ������ ���
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					cl.Mode_Check();
				} else {

				}
			}
		});
=======
				} else {

				}
			}
		});
		
		//상품 관리 이벤트 처리
		PM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == PM.previousBtn) { // 상품관리 뷰에서 이전 버튼을 눌렀을 경우
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == PM.logoutBtn) { // 상품관리 뷰에서 로그아웃 버튼을 눌렀을 경우
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				} else if(obj == PM.btn[0]){  //등록
					cp.insertion();
				} else if(obj == PM.btn[1]) { //조회
					cp.show();
				} else if(obj == PM.btn[2]) { //삭제
					cp.deletion();
				} else {}
			}
		});
		
>>>>>>> origin/project1
		GUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
<<<<<<< HEAD
				
<<<<<<< HEAD
				if (obj == GUI.LogOutbtn) { // ����� �信�� �α׾ƿ� ��ư�� ������ ���
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "adminlogin")));
					GUI.msgInput.setText("");
=======
				if (obj == GUI.LogOutbtn) { // ��ǰ���� �信�� �α׾ƿ� ��ư�� ������ ���
					outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "", "logout", "")));
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
					cl.Mode_Check();
=======
				if (obj == GUI.LogOutbtn) { // 상품관리 뷰에서 로그아웃 버튼을 눌렀을 경우
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "")));
>>>>>>> origin/project1
					try {
						outMsg.close();
						inMsg.close();
						socket.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
<<<<<<< HEAD
					status = false;
					System.exit(0);
				} else if (obj == GUI.msgInput) {
<<<<<<< HEAD
					String test = gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "admins"));
					outMsg.println(test);
					System.out.println(test);
=======
					outMsg.println(gson.toJson(new Message(m.getSeat(), GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "")));
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
					GUI.msgInput.setText("");
				}
			}
		});
		
=======
					System.exit(0);
					status = false;
				} else if (obj == GUI.msgInput) {
					outMsg.println(
							gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "")));
					GUI.msgInput.setText("");
				}
				else if(obj == GUI.sumb) {
					int value = Integer.parseInt(GUI.Cashl.getText());
					if(dao.getInstance().Cash_Check(LV.loginTextField.getText(), value)){
						JOptionPane.showMessageDialog(null, "결제가 되었습니다.");
						GUI.la[2].setText("포인트 : " + Integer.toString(Integer.parseInt(dao.getInstance().getCash(LV.loginTextField.getText()))-value));
					}
					else
						JOptionPane.showMessageDialog(null, "포인트가 부족합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
>>>>>>> origin/project1
	}

	public void connectServer() {
		try {
<<<<<<< HEAD
			// ���� ����
			socket = new Socket(ip, 8888);
			logger.info("[Client]Server ���� ����!!");

			// ����� ��Ʈ�� ����
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);

			// ������ �α��� �޽��� ����
<<<<<<< HEAD
			if (CM.loginFlag) {
				m = new Message("ī����", CM.id, "", "", "adminlogin", "");
			} else {
				m = new Message("0", GUI.id, "", "", "login", "adminlogin");
			}
			outMsg.println(gson.toJson(m));
=======
			if (CM.loginFlag == true) {
				m = new Message("0", GUI.id, "", "", "adminlogin", "");
			} else {
				m = new Message("0", GUI.id, "", "", "login", "");
			}
			outMsg.println(gson.toJson(m));
			

>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
			// �޽��� ������ ���� ������ ����
			thread = new Thread(this);
			thread.start();
			
<<<<<<< HEAD
=======
			
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
			// ����� �信 ��Ʈ ��ȣ ����
//			GUI.seat = m.getSeat();
//			GUI.id = m.getId();
		} catch (Exception e) {
			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception �߻�!!");
=======
			// 소켓 생성
			socket = new Socket(ip, 8888);
			logger.info("[Client]Server 연결 성공!!");

			// 입출력 스트림 생성
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);

			// 서버에 로그인 메시지 전달
			if (CM.loginFlag == true) {
				m = new Message("", LV.id, "", "", "adminlogin", "");
			} else {
				m = new Message("", LV.id, "", "", "login", "");
			}
			outMsg.println(gson.toJson(m));

			// 메시지 수신을 위한 스레드 생성
			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception 발생!!");
>>>>>>> origin/project1
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
<<<<<<< HEAD
		// ���� �޽����� ó���ϴ� �� �ʿ��� ���� ����
		String msg;
		status = true;
		while (status) {
			try {
				// �޽��� ���� �� �Ľ�
				msg = inMsg.readLine();
<<<<<<< HEAD
				Message m_temp = gson.fromJson(msg, Message.class);
				System.out.println(msg);
//				System.out.println(m.getSeat());
				if(m.getSeat() == "0" && GUI.seat == "") {
					System.out.println("TEST");
					GUI.seat = m_temp.getSeat();
					m.setSeat(m_temp.getSeat());
				}
				// comboBox ����
//				if(comboFlag == true) {
//				CMchatData.comboRefreshData(m.getSeat());
//					comboFlag = false;
//				}
				// MultiChatData ��ü�� ������ ����
				if(CM.loginFlag)
				{	
					System.out.println("������ �ڵ�");
					CMchatData.refreshData(GUI.seat + " �¼�(" + m_temp.getId() + "):" + m_temp.getMsg() + "\n");
					CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
				}
				else {
					System.out.println("����� �ڵ�");
				GUIchatData.refreshData(GUI.seat + " �¼�(" + m_temp.getId() + "):" + m_temp.getMsg() + "\n");
=======
				m = gson.fromJson(msg, Message.class);
 
				// comboBox ����
//				if(comboFlag == true) {
				CMchatData.comboRefreshData(m.getSeat());
//					comboFlag = false;
//				}
				// MultiChatData ��ü�� ������ ����
				CMchatData.refreshData(m.getSeat() + "�� �¼�(" + m.getId() + "):" + m.getMsg() + "\n");
				GUIchatData.refreshData(m.getSeat() + "�� �¼�(" + m.getId() + "):" + m.getMsg() + "\n");
				// Ŀ���� ���� ��ȭ �޽����� ǥ��
				CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
				GUI.ta2.setCaretPosition(GUI.ta2.getDocument().getLength());
				}
				// Ŀ���� ���� ��ȭ �޽����� ǥ��
			} catch (IOException e) {
				logger.log(Level.WARNING, "[MultiChatUI]�޽��� ��Ʈ�� ����!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " �޽��� ���� ������ �����!!");
	} // run()
	
	public static void main(String[] args) {
		PCController app = new PCController(LoginView.getInstance(), CusManager.getInstance(),ProdManager.getInstance(), GUIView.getInstance(), new AdminView(), new SignUpView(), new C_login(), new PCChatData(), new PCChatData());
		app.appMain();
	}
=======
		// 수신 메시지를 처리하는 데 필요한 변수 선언
		String msg;
		status = true;

		while (status) {
			try {
				// 메시지 수신 및 파싱
				msg = inMsg.readLine();
				m = gson.fromJson(msg, Message.class);
				String whisperMsg = "";

				// MultiChatData 객체로 데이터 갱신
				chatData.refreshData(m.getSeat() + "번 좌석" + m.getId() + ":" + m.getMsg() + "\n");
				chatData2.refreshData(m.getSeat() + "번 좌석" + m.getId() + ":" + m.getMsg() + "\n");
				// 커서를 현재 대화 메시지에 표시
				CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
				GUI.ta2.setCaretPosition(GUI.ta2.getDocument().getLength());
			} catch (IOException e) {
				logger.log(Level.WARNING, "[MultiChatUI]메시지 스트림 종료!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " 메시지 수신 스레드 종료됨!!");
	} // run()
>>>>>>> origin/project1

}
