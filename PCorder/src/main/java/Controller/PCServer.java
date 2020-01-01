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
	// 서버 소켓 및 클라이언트 연결 소켓
	private ServerSocket ss = null;
	private Socket s = null;
	private boolean completeSendFlag = false;
	// 연결된 클라이언트 스레드를 관리하는 ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();

//	ChatThread thread = new ChatThread();
	// 로거 객체
	Logger logger;

	public void start() {
		logger = Logger.getLogger(this.getClass().getName());

		try {
			// 서버 소켓 생성
			ss = new ServerSocket(8888);
			logger.info("PC Server start");

			// 무한 루프를 돌면서 클라이언트 연결을 기다린다.
			while (true) {
				s = ss.accept();
				// 연결된 클라이언트에 대해 스레드 클래스 생성
				ChatThread chat = new ChatThread();
				// 클라이언트 리스트 추가
				chatThreads.add(chat);
				// 스레드 시작
				chat.start();
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception 발생!!");
			e.printStackTrace();
		}

	} // start()

	class ChatThread extends Thread {
		// 수신 메시지 및 파싱 메시지 처리를 위한 변수 선언
		String msg;

		boolean status = true;

		// 메시지 객체 생성
		Message m = new Message();

		// JSON 파서 초기화
		Gson gson = new Gson();

		// 입출력 스트림
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
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 종료했습니다.", "server", "")));
						status = false;
					} else if (m.getType().equals("login")) {
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 로그인했습니다.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						MyThread(gson.toJson(new Message("TopSeat", "관리자", "", "님이 로그인했습니다.", "server", "")));
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
//									.println(gson.toJson(new Message(m.getId(), "", "귓속말 상대를 찾을 수 없습니다.", "none", "")));
//						}
					} else if (m.getType().equals("sendtoadmin")) {
						msgSendToAdmin(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 루프를 벗어나면 클라이언트 연결이 종료되므로 스레드 인터럽트
				this.interrupt();
				logger.info(this.getName() + " 종료됨!!");
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