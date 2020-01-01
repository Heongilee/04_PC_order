package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JButton;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Model.Customers_DAO;
import Model.Message;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

public class PCController implements Runnable {
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
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV, C_login cl, C_SignUp cs, C_ProdManager cp, PCChatData chatData, PCChatData chatData2) {
		// �ΰ� ��ü �ʱ�ȭ
		logger = Logger.getLogger(this.getClass().getName());
		
		this.LV = LV;				// LoginView ������ü ����
		this.CM = CM;				// CusManager ������ü ����
		this.PM = PM;				// ProdManager ������ü ����
		this.GUI = GUI;				// GUIView ������ü ����
		this.AV = AV;				// AdminView ������ü ����
		this.SUV = SUV;				// SignUpView ������ü ����
		this.cl = cl;				// C_login ������ü ����
		this.cs = cs;				// C_SignUp ������ü ����
		this.cp = cp;				// C_ProdManager ������ü ����
		this.chatData = chatData;	// PCChatData ������ü ����
		this.chatData2 = chatData2;	// PCChatData2 ������ü ����
	}

	public void appMain() {
		// ������ ��ü���� ������ ��ȭ�� ó���� UI ��ü �߰�, ta2�� TextArea�̴�.
		chatData.addObjCus(CM.chatContent);
		chatData2.addObjGUI(GUI.ta2);
		
		// �α��� �� �̺�Ʈ ó��
		LV.addButtonActionListener(new ActionListener() { // �α��� �� ���̾ƿ�
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) { // �α��� ��ư�� ������ ��
					if (LV.server.isSelected()) { // server mode�� üũ �Ǿ����� ��� (������ cMODE : 0)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 0)) {
							// ------- �α��� ����!! -------
							LV.cardLayout.show(LV.window, "admin");
							CM.loginFlag = true;
							
							/* ������ �α��� ���� ��� �̺�Ʈ ó�� */
							connectServer();
						}
						else {
							// ------- �α��� ����... -------
							return;
						}
						
					} else if (LV.user.isSelected()) { // user mode�� üũ �Ǿ����� ��� (����� cMODE : 1)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 1)) {
							// ------- �α��� ����!! -------
							
							/*	ȭ�� ��ȯ	*/
							LV.setVisible(false);
							LV.GV.getInstance().setVisible(true);
							
							/*	����� �α��� ���� ��� �̺�Ʈ ó��	*/
							GUI.id = LV.loginTextField.getText();
							GUI.la[0].setText("���̵� : " + GUI.id);
							connectServer();
						}
						else {
							// ------- �α��� ����... -------
							return;
						}
					} else {}
				} else if (obj == LV.SignUpbtn) { // ȸ������ ��ư�� ������ ���
					LV.cardLayout.show(LV.window, "signUp");
				} else if (obj == LV.previousBtn) { // ���� ���� ��ư�� ������ ���
					System.out.println("PREV TEST");
					LV.cardLayout.show(LV.window, "layer");
				} else {

				}
			}
		});
		
		//�α��� ��->������ �� �̺�Ʈ ó��
		LV.adminView.addButtonActionListener(new ActionListener() { // ������ �� ���̾ƿ�
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // ������ �信�� ������ ��ư�� ������ ���
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				} else if (obj == LV.adminView.pm_btn) { // ������ �信�� ��ǰ���� ��ư�� ������ ���
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				}
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
		
		//�� ���� �� �̺�Ʈ ó��
		CM.addButtonActionListener(new ActionListener() { // ������ ��
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) { // ������ �信�� ä��
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
				} else if (obj == CM.previousBtn) { // ������ �信�� ���� ��ư�� ������ ���
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == CM.logoutBtn) { // ������ �信�� �α׾ƿ� ��ư�� ������ ���
					CM.chatContent.setText("");
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				} else {

				}
			}
		});
		
		//��ǰ ���� �̺�Ʈ ó��
		PM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == PM.previousBtn) { // ��ǰ���� �信�� ���� ��ư�� ������ ���
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == PM.logoutBtn) { // ��ǰ���� �信�� �α׾ƿ� ��ư�� ������ ���
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				} else if(obj == PM.btn[0]){  //���
					cp.insertion();
				} else if(obj == PM.btn[1]) { //��ȸ
					cp.show();
				} else if(obj == PM.btn[2]) { //����
					cp.deletion();
				} else {}
			}
		});
		
		GUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == GUI.LogOutbtn) { // ��ǰ���� �信�� �α׾ƿ� ��ư�� ������ ���
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "")));
					try {
						outMsg.close();
						inMsg.close();
						socket.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					System.exit(0);
					status = false;
				} else if (obj == GUI.msgInput) {
					outMsg.println(
							gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "")));
					GUI.msgInput.setText("");
				}
			}
		});
	}

	public void connectServer() {
		try {
			// ���� ����
			socket = new Socket(ip, 8888);
			logger.info("[Client]Server ���� ����!!");

			// ����� ��Ʈ�� ����
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);

			// ������ �α��� �޽��� ����
			if (CM.loginFlag == true) {
				m = new Message("", LV.id, "", "", "adminlogin", "");
			} else {
				m = new Message("", LV.id, "", "", "login", "");
			}
			outMsg.println(gson.toJson(m));

			// �޽��� ������ ���� ������ ����
			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception �߻�!!");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// ���� �޽����� ó���ϴ� �� �ʿ��� ���� ����
		String msg;
		status = true;

		while (status) {
			try {
				// �޽��� ���� �� �Ľ�
				msg = inMsg.readLine();
				m = gson.fromJson(msg, Message.class);
				String whisperMsg = "";

				// MultiChatData ��ü�� ������ ����
				chatData.refreshData(m.getSeat() + "�� �¼�" + m.getId() + ":" + m.getMsg() + "\n");
				chatData2.refreshData(m.getSeat() + "�� �¼�" + m.getId() + ":" + m.getMsg() + "\n");
				// Ŀ���� ���� ��ȭ �޽����� ǥ��
				CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
				GUI.ta2.setCaretPosition(GUI.ta2.getDocument().getLength());
			} catch (IOException e) {
				logger.log(Level.WARNING, "[MultiChatUI]�޽��� ��Ʈ�� ����!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " �޽��� ���� ������ �����!!");
	} // run()

}
