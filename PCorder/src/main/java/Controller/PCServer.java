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
	// 서버 소켓 및 클라이언트 연결 소켓
	private ServerSocket ss = null;
	private Socket s = null;
	// 연결된 클라이언트 스레드를 관리하는 ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	int[] seatNum = new int[12];	
	int[] removeSeat = new int[12];
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
<<<<<<< HEAD
					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 종료했습니다.", "server", "")));
						seatNum[Integer.parseInt(m.getSeat())-1] = 0;
=======
					
//					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
//					if(m.getSeat().equals("")) {
//						System.out.println("공백이넹?");
//					}
//					System.out.println(m);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 종료했습니다.", "server", "")));
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
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 로그인했습니다.", "server", "")));
					} else if (m.getType().equals("adminlogin") ) {
						outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 로그인했습니다.", "server", "")));
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
//								ct.outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "님이 로그인했습니다.", "server", "")));
//								break;
//							}
//						}
						msgSendToAdmin(gson.toJson(new Message(Integer.toString(seatNum[i]), m.getId(), "", "님이 로그인했습니다.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						outMsg.println(gson.toJson(new Message("전체", "관리자", "", "님이 로그인했습니다.", "server", "")));
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
				// 루프를 벗어나면 클라이언트 연결이 종료되므로 스레드 인터럽트
				this.interrupt();
				logger.info(this.getName() + " 종료됨!!");
			}
		}
		void msgSendToAdmin(String msg) {
			outMsg.println(msg);
			for (ChatThread ct : chatThreads) {
<<<<<<< HEAD
				if (ct.m.getId().equals("관리자")) {
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