package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Model.Message;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

public class PCController implements Runnable {
	private final LoginView LV;
	private final CusManager CM;
	private final ProdManager PM;
	private final GUIView GUI;
	private final AdminView AV;
	private final SignUpView SUV;
	private final C_login cl;

	private final PCChatData chatData;
	private final PCChatData chatData2;

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

	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV,
			C_login cl, PCChatData chatData, PCChatData chatData2) {
		// �ΰ� ��ü �ʱ�ȭ
		logger = Logger.getLogger(this.getClass().getName());

		this.LV = LV;
		this.CM = CM;
		this.PM = PM;
		this.GUI = GUI;
		this.AV = AV;
		this.SUV = SUV;
		this.cl = cl;

		this.chatData = chatData;
		this.chatData2 = chatData2;
	}

	public void appMain() {
		// ������ ��ü���� ������ ��ȭ�� ó���� UI ��ü �߰�, ta2�� TextArea�̴�.
		chatData.addObjCus(CM.chatContent);
		chatData2.addObjGUI(GUI.ta2);

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
						connectServer();
					} else if (LV.user.isSelected()) { // user mode�� üũ �Ǿ����� ���
						LV.setVisible(false);
						LV.GV.getInstance().setVisible(true);
						cl.Mode_Check();
						/* ����� �α��� ���� ��� �̺�Ʈ ó�� */
						GUI.id = LV.loginTextField.getText();
						GUI.la[0].setText("���̵� : " + GUI.id);
						connectServer();
					} else {

					}
				} else if (obj == LV.SignUpbtn) { // ȸ������ ��ư�� ������ ���
					LV.cardLayout.show(LV.window, "signUp");
					cl.Mode_Check();
				} else if (obj == LV.previousBtn) { // ���� ���� ��ư�� ������ ���
					LV.cardLayout.show(LV.window, "layer");
					cl.Mode_Check();
				} else {

				}
			}
		});
		LV.adminView.addButtonActionListener(new ActionListener() { // ������ �� ���̾ƿ�
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // ������ �信�� ������ ��ư�� ������ ���
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
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
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
					cl.Mode_Check();
				} else if (obj == CM.previousBtn) { // ������ �信�� ���� ��ư�� ������ ���
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					cl.Mode_Check();
				} else if (obj == CM.logoutBtn) { // ������ �信�� �α׾ƿ� ��ư�� ������ ���
					CM.chatContent.setText("");
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					cl.Mode_Check();
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
		GUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == GUI.LogOutbtn) { // ��ǰ���� �信�� �α׾ƿ� ��ư�� ������ ���
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "")));
					cl.Mode_Check();
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

	public static void main(String[] args) {
		PCController app = new PCController(LoginView.getInstance(), CusManager.getInstance(),ProdManager.getInstance(), GUIView.getInstance(), new AdminView(), new SignUpView(), new C_login(), new PCChatData(), new PCChatData());
		app.appMain();
	}

}
