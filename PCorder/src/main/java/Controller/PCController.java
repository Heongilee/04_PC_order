package Controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

	String ip = "127.0.0.1";
	Socket socket;
	BufferedReader inMsg;
	PrintWriter outMsg;
	Thread thread;
	boolean status;

	boolean comboFlag = false;
	
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
					CM.chatContent.setText("");
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
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
		GUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if (obj == GUI.LogOutbtn) { // ����� �信�� �α׾ƿ� ��ư�� ������ ���
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "adminlogin")));
					GUI.msgInput.setText("");
					cl.Mode_Check();
					try {
						outMsg.close();
						inMsg.close();
						socket.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					status = false;
					System.exit(0);
				} else if (obj == GUI.msgInput) {
					String test = gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "admins"));
					outMsg.println(test);
					System.out.println(test);
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
			if (CM.loginFlag) {
				m = new Message("ī����", CM.id, "", "", "adminlogin", "");
			} else {
				m = new Message("0", GUI.id, "", "", "login", "adminlogin");
			}
			outMsg.println(gson.toJson(m));
			// �޽��� ������ ���� ������ ����
			thread = new Thread(this);
			thread.start();
			
			// ����� �信 ��Ʈ ��ȣ ����
//			GUI.seat = m.getSeat();
//			GUI.id = m.getId();
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

}
