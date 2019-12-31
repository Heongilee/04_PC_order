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
	
	// �޽��� Ŭ���� ���� ��ü
	Message m;
	// �ΰ� ��ü
	Logger logger;
	
	String ip = "127.0.0.1";
	Socket socket;
	BufferedReader inMsg;
	PrintWriter outMsg;
	Thread thread;
	boolean status;
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, AdminView AV, SignUpView SUV, C_login cl, C_SignUp cs, PCChatData chatData) {
		// �ΰ� ��ü �ʱ�ȭ
		logger = Logger.getLogger(this.getClass().getName());
		
		this.LV = LV;				// LoginView ������ü ����
		this.CM = CM;				// CusManager ������ü ����
		this.PM = PM;				// ProdManager ������ü ����
		this.AV = AV;				// AdminView ������ü ����
		this.SUV = SUV;				// SignUpView ������ü ����
		this.cl = cl;				// C_login ������ü ����
		this.cs = cs;				// C_SignUp ������ü ����
		
		this.chatData = chatData;	// PCChatData ������ü ����
	}
	public void appMain() {
		
		//�α��� �� �̺�Ʈ ó��
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
		
		//�α��� ��->������ �� �̺�Ʈ ó��		
		LV.adminView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});
		
		//�α��� ��->ȸ������ �� �̺�Ʈ ó��
		LV.signUpView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				//SignUpView���� setName�� ���� ������ if-else������ �б������� �־���.
				if(btn.getName().equals("IdOverlapbtn")) {
					cs.Valid_Check(0);
				}
				else if(btn.getName().equals("NameOverlapbtn")) {
					cs.Valid_Check(1);
				}
				else if(btn.getName().equals("EmailOverlapbtn")) {
					cs.Valid_Check(2);
				}
				else { //ȸ������ ���� ��ư (btn)
					try {
						cs.Register_Complete();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		//�� ���� �̺�Ʈ ó��
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
		
		//��ǰ ���� �̺�Ʈ ó��
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
//			// ���� ����
//			socket = new Socket(ip, 8888);
//			logger.info("[Client]Server ���� ����!!");
//			
//			// ����� ��Ʈ�� ����
//			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			outMsg = new PrintWriter(socket.getOutputStream(), true);
//			
//			// ������ �α��� �޽��� ����
//			m = new Message(v.id, "", "", "login", "");
//			outMsg.println(gson.toJson(m));
//			
//			// �޽��� ������ ���� ������ ����
//			thread = new Thread(this);
//			thread.start();
//		} catch (Exception e) {
//			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception �߻�!!");
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public void run() {
//		// ���� �޽����� ó���ϴ� �� �ʿ��� ���� ����
//		String msg;
//		status = true;
//		
//		while(status) {
//			try {
//				// �޽��� ���� �� �Ľ�
//				msg = inMsg.readLine();
//				m = gson.fromJson(msg, Message.class);
//				String whisperMsg = "";
//				
//				// MultiChatData ��ü�� ������ ����
//				chatData.refreshData(m.getId() + ">" + m.getMsg() + "\n");
//				// Ŀ���� ���� ��ȭ �޽����� ǥ��
//				v.msgOut.setCaretPosition(v.msgOut.getDocument().getLength());
//			} catch (IOException e) {
//				logger.log(Level.WARNING, "[MultiChatUI]�޽��� ��Ʈ�� ����!!");
//			}
//		}
//		logger.info("[MultiChatUI]" + thread.getName() + " �޽��� ���� ������ �����!!");
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
