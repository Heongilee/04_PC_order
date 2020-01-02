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
<<<<<<< HEAD
					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �����߽��ϴ�.", "server", "")));
						seatNum[Integer.parseInt(m.getSeat())-1] = 0;
=======
					
//					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
//					if(m.getSeat().equals("")) {
//						System.out.println("�����̳�?");
//					}
//					System.out.println(m);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �����߽��ϴ�.", "server", "")));
						removeSeat[Integer.parseInt(m.getSeat())-1] = Integer.parseInt(m.getSeat()); 
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
						status = false;
//						m.setSeat("0");
//						seatNum[Integer.parseInt(m.getSeat())-1] = 0;
					} else if (m.getType().equals("login")) {
<<<<<<< HEAD
						boolean flag = false;
						int i = 0;
						for(i=0; i<12; i++) {
=======
						ChatThread ctTmp = null;
						boolean flag = false;
						int i = 0;
						for(i=0; i<12; i++) {
							for(int j=0; j<12;j++) {
								if(removeSeat[j] != 0) {
									seatNum[j] = j+1;
									removeSeat[j] = 0;
									i=j;
									flag = true;
									break;
								}
							}
							if(flag == true)	break;
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
							if(seatNum[i] == 0) {
								seatNum[i] = i+1;
								break;
							}
						}
<<<<<<< HEAD
						m.setSeat(Integer.toString(seatNum[i]));
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
					} else if (m.getType().equals("adminlogin") ) {
						outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
=======
//						for(ChatThread ct : chatThreads) {
//							if(ct.m.getId().equals(m.getId())) {
//								ctTmp = ct;
//								ct.m.setSeat(Integer.toString(seatNum[i]));
//								break;
//							}
//						}
//						chatThreads.get(chatThreads.size()-1).m.setSeat(Integer.toString(seatNum[i]));
						
//						outMsg.println(msg);
//						int i=0;
//						for(i=0;i<12;i++) {
//							
//						}
//						for(ChatThread ct : chatThreads) {
//							i++;
//							if(ct.m.getSeat().equals("0")) {
//								m.setSeat(Integer.toString(i));
//								
//								ct.outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
//								break;
//							}
//						}
						msgSendToAdmin(gson.toJson(new Message(Integer.toString(seatNum[i]), m.getId(), "", "���� �α����߽��ϴ�.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						outMsg.println(gson.toJson(new Message("��ü", "������", "", "���� �α����߽��ϴ�.", "server", "")));
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
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
<<<<<<< HEAD
				if (ct.m.getId().equals("������")) {
=======
				if (ct.m.getType().equals("adminlogin")) {
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
					ct.outMsg.println(msg);
				}
			}
		}
<<<<<<< HEAD
		void msgSendAll(String msg) {
			for(ChatThread ct : chatThreads) {
				ct.outMsg.println(msg);
			}
		}
=======
//		void MyThread(String msg) {
//			chatThreads.get(chatThreads.size()-1).outMsg.println(msg);
//		}
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
	}
	public static void main(String[] args) {
		PCServer server = new PCServer();
		server.start();
	}
}