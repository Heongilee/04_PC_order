package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
=======
>>>>>>> origin/project1
import java.util.logging.Logger;

import com.google.gson.Gson;

import Model.Message;

public class PCServer {
<<<<<<< HEAD
	// 서버 소켓 및 클라이언트 연결 소켓
	private ServerSocket ss = null;
	private Socket s = null;
	// 연결된 클라이언트 스레드를 관리하는 ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	int[] seatNum = new int[12];	
	int[] removeSeat = new int[12];
	// 로거 객체
=======
	// �꽌踰� �냼耳� 諛� �겢�씪�씠�뼵�듃 �뿰寃� �냼耳�
	private ServerSocket ss = null;
	private Socket s = null;
	private boolean completeSendFlag = false;
	// �뿰寃곕맂 �겢�씪�씠�뼵�듃 �뒪�젅�뱶瑜� 愿�由ы븯�뒗 ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();

//	ChatThread thread = new ChatThread();
	// 濡쒓굅 媛앹껜
>>>>>>> origin/project1
	Logger logger;

	public void start() {
		logger = Logger.getLogger(this.getClass().getName());

		try {
<<<<<<< HEAD
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
=======
			// �꽌踰� �냼耳� �깮�꽦
			ss = new ServerSocket(8888);
			logger.info("PC Server start");

			// 臾댄븳 猷⑦봽瑜� �룎硫댁꽌 �겢�씪�씠�뼵�듃 �뿰寃곗쓣 湲곕떎由곕떎.
			while (true) {
				s = ss.accept();
				// �뿰寃곕맂 �겢�씪�씠�뼵�듃�뿉 ����빐 �뒪�젅�뱶 �겢�옒�뒪 �깮�꽦
				ChatThread chat = new ChatThread();
				// �겢�씪�씠�뼵�듃 由ъ뒪�듃 異붽��
				chatThreads.add(chat);
				// �뒪�젅�뱶 �떆�옉
				chat.start();
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception 諛쒖깮!!");
>>>>>>> origin/project1
			e.printStackTrace();
		}

	} // start()

	class ChatThread extends Thread {
<<<<<<< HEAD
		// 수신 메시지 및 파싱 메시지 처리를 위한 변수 선언
=======
		// �닔�떊 硫붿떆吏� 諛� �뙆�떛 硫붿떆吏� 泥섎━瑜� �쐞�븳 蹂��닔 �꽑�뼵
>>>>>>> origin/project1
		String msg;

		boolean status = true;

<<<<<<< HEAD
		// 메시지 객체 생성
		Message m = new Message();

		// JSON 파서 초기화
		Gson gson = new Gson();

		// 입출력 스트림
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
  
=======
		// 硫붿떆吏� 媛앹껜 �깮�꽦
		Message m = new Message();

		// JSON �뙆�꽌 珥덇린�솕
		Gson gson = new Gson();

		// �엯異쒕젰 �뒪�듃由�
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;

>>>>>>> origin/project1
		@Override
		public void run() {
			try {
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(), true);

				while (status) {
					msg = inMsg.readLine();
<<<<<<< HEAD
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
						
=======

					m = gson.fromJson(msg, Message.class);

					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "�떂�씠 醫낅즺�뻽�뒿�땲�떎.", "server", "")));
						status = false;
					} else if (m.getType().equals("login")) {
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "�떂�씠 濡쒓렇�씤�뻽�뒿�땲�떎.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						MyThread(gson.toJson(new Message("TopSeat", "愿�由ъ옄", "", "�떂�씠 濡쒓렇�씤�뻽�뒿�땲�떎.", "server", "")));
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
//									.println(gson.toJson(new Message(m.getId(), "", "洹볦냽留� �긽���瑜� 李얠쓣 �닔 �뾾�뒿�땲�떎.", "none", "")));
//						}
					} else if (m.getType().equals("sendtoadmin")) {
						msgSendToAdmin(msg);
>>>>>>> origin/project1
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
<<<<<<< HEAD
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
=======
				// 猷⑦봽瑜� 踰쀬뼱�굹硫� �겢�씪�씠�뼵�듃 �뿰寃곗씠 醫낅즺�릺誘�濡� �뒪�젅�뱶 �씤�꽣�읇�듃
				this.interrupt();
				logger.info(this.getName() + " 醫낅즺�맖!!");
			}
		}
		void msgSendToAdmin(String msg) {
			for (ChatThread ct : chatThreads) {
				if (ct.m.getType().equals("adminlogin") || ct.m.getId().equals(m.getId())) {
>>>>>>> origin/project1
					ct.outMsg.println(msg);
				}
			}
		}
<<<<<<< HEAD
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
=======
		void MyThread(String msg) {
			chatThreads.get(chatThreads.size()-1).outMsg.println(msg);
		}
>>>>>>> origin/project1
	}
	public static void main(String[] args) {
		PCServer server = new PCServer();
		server.start();
	}
}