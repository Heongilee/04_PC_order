package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gson.Gson;

import Model.Message;

public class PCServer {
	// ���� ���� �� Ŭ���̾�Ʈ ���� ����
	private ServerSocket ss = null;
	private Socket s = null;
	// ����� Ŭ���̾�Ʈ �����带 �����ϴ� ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	int[] seatNum = new int[12];	
	int[] removeSeat = new int[12];
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
					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �����߽��ϴ�.", "server", "")));
						seatNum[Integer.parseInt(m.getSeat())-1] = 0;
						status = false;
					} else if (m.getType().equals("login")) {
						boolean flag = false;
						int i = 0;
						for(i=0; i<12; i++) {
							if(seatNum[i] == 0) {
								seatNum[i] = i+1;
								break;
							}
						}
						m.setSeat(Integer.toString(seatNum[i]));
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
					} else if (m.getType().equals("adminlogin") ) {
						outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
					} else if (m.getType().equals("sendtoadmin")) {
						System.out.println(m);
						System.out.println(msg);
						msgSendToAdmin(msg);
					} else if (m.getType().equals("admin")) {
						msgSendAll(msg);
					} else {
						
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
			outMsg.println(msg);
			for (ChatThread ct : chatThreads) {
				if (ct.m.getId().equals("������")) {
					ct.outMsg.println(msg);
				}
			}
		}
		void msgSendAll(String msg) {
			for(ChatThread ct : chatThreads) {
				ct.outMsg.println(msg);
			}
		}
	}
	public static void main(String[] args) {
		PCServer server = new PCServer();
		server.start();
	}
}