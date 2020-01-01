package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.gson.Gson;

import Model.Message;

public class PCServer {
	// ���� ���� �� Ŭ���̾�Ʈ ���� ����
	private ServerSocket ss = null;
	private Socket s = null;
	private boolean completeSendFlag = false;
	// ����� Ŭ���̾�Ʈ �����带 �����ϴ� ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();

//	ChatThread thread = new ChatThread();
	// �ΰ� ��ü
	Logger logger;

	public void start() {
		logger = Logger.getLogger(this.getClass().getName());

		try {
			// ���� ���� ����
			ss = new ServerSocket(8888);
			logger.info("PC Server start");

			// ���� ������ ���鼭 Ŭ���̾�Ʈ ������ ��ٸ���.
			while (true) {
				s = ss.accept();
				// ����� Ŭ���̾�Ʈ�� ���� ������ Ŭ���� ����
				ChatThread chat = new ChatThread();
				// Ŭ���̾�Ʈ ����Ʈ �߰�
				chatThreads.add(chat);
				// ������ ����
				chat.start();
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception �߻�!!");
			e.printStackTrace();
		}

	} // start()

	class ChatThread extends Thread {
		// ���� �޽��� �� �Ľ� �޽��� ó���� ���� ���� ����
		String msg;

		boolean status = true;

		// �޽��� ��ü ����
		Message m = new Message();

		// JSON �ļ� �ʱ�ȭ
		Gson gson = new Gson();

		// ����� ��Ʈ��
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;

		@Override
		public void run() {
			try {
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(), true);

				while (status) {
					msg = inMsg.readLine();

					m = gson.fromJson(msg, Message.class);

					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �����߽��ϴ�.", "server", "")));
						status = false;
					} else if (m.getType().equals("login")) {
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						MyThread(gson.toJson(new Message("TopSeat", "������", "", "���� �α����߽��ϴ�.", "server", "")));
//						completeSendFlag = false;
//						ChatThread ctTmp = null;
//						for (ChatThread ct : chatThreads) {
//							if (ct.m.getId().equals(m.getReceiveId())) {
//								completeSendFlag = true;
//							} else if (ct.m.getId().equals(m.getId())) {
//								ctTmp = ct;
//							}
//						}
//						if (completeSendFlag == true) {
//							msgSendWhisper(msg);
//						} else {
//							ctTmp.outMsg
//									.println(gson.toJson(new Message(m.getId(), "", "�ӼӸ� ��븦 ã�� �� �����ϴ�.", "none", "")));
//						}
					} else if (m.getType().equals("sendtoadmin")) {
						msgSendToAdmin(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// ������ ����� Ŭ���̾�Ʈ ������ ����ǹǷ� ������ ���ͷ�Ʈ
				this.interrupt();
				logger.info(this.getName() + " �����!!");
			}
		}
		void msgSendToAdmin(String msg) {
			for (ChatThread ct : chatThreads) {
				if (ct.m.getType().equals("adminlogin") || ct.m.getId().equals(m.getId())) {
					ct.outMsg.println(msg);
				}
			}
		}
		void MyThread(String msg) {
			chatThreads.get(chatThreads.size()-1).outMsg.println(msg);
		}
	}
	public static void main(String[] args) {
		PCServer server = new PCServer();
		server.start();
	}
}