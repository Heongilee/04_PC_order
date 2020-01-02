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
	// ¼­¹ö ¼ÒÄÏ ¹× Å¬¶óÀÌ¾ğÆ® ¿¬°á ¼ÒÄÏ
	private ServerSocket ss = null;
	private Socket s = null;
	// ¿¬°áµÈ Å¬¶óÀÌ¾ğÆ® ½º·¹µå¸¦ °ü¸®ÇÏ´Â ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	int[] seatNum = new int[12];	
	int[] removeSeat = new int[12];
	// ·Î°Å °´Ã¼
=======
	// ì„œë²„ ì†Œì¼“ ë° í´ë¼ì´ì–¸íŠ¸ ì—°ê²° ì†Œì¼“
	private ServerSocket ss = null;
	private Socket s = null;
	private boolean completeSendFlag = false;
	// ì—°ê²°ëœ í´ë¼ì´ì–¸íŠ¸ ìŠ¤ë ˆë“œë¥¼ ê´€ë¦¬í•˜ëŠ” ArrayList
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();

//	ChatThread thread = new ChatThread();
	// ë¡œê±° ê°ì²´
>>>>>>> origin/project1
	Logger logger;

	public void start() {
		logger = Logger.getLogger(this.getClass().getName());

		try {
<<<<<<< HEAD
			// ¼­¹ö ¼ÒÄÏ »ı¼º
			ss = new ServerSocket(8888);
			logger.info("PC Server start");

			// ¹«ÇÑ ·çÇÁ¸¦ µ¹¸é¼­ Å¬¶óÀÌ¾ğÆ® ¿¬°áÀ» ±â´Ù¸°´Ù.
			while (true) {
				s = ss.accept();
				// ¿¬°áµÈ Å¬¶óÀÌ¾ğÆ®¿¡ ´ëÇØ ½º·¹µå Å¬·¡½º »ı¼º
				ChatThread chat = new ChatThread();
				// Å¬¶óÀÌ¾ğÆ® ¸®½ºÆ® Ãß°¡
				chatThreads.add(chat);
				// ½º·¹µå ½ÃÀÛ
				chat.start();
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception ¹ß»ı!!");
=======
			// ì„œë²„ ì†Œì¼“ ìƒì„±
			ss = new ServerSocket(8888);
			logger.info("PC Server start");

			// ë¬´í•œ ë£¨í”„ë¥¼ ëŒë©´ì„œ í´ë¼ì´ì–¸íŠ¸ ì—°ê²°ì„ ê¸°ë‹¤ë¦°ë‹¤.
			while (true) {
				s = ss.accept();
				// ì—°ê²°ëœ í´ë¼ì´ì–¸íŠ¸ì— ëŒ€í•´ ìŠ¤ë ˆë“œ í´ë˜ìŠ¤ ìƒì„±
				ChatThread chat = new ChatThread();
				// í´ë¼ì´ì–¸íŠ¸ ë¦¬ìŠ¤íŠ¸ ì¶”ê°€
				chatThreads.add(chat);
				// ìŠ¤ë ˆë“œ ì‹œì‘
				chat.start();
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]start() Exception ë°œìƒ!!");
>>>>>>> origin/project1
			e.printStackTrace();
		}

	} // start()

	class ChatThread extends Thread {
<<<<<<< HEAD
		// ¼ö½Å ¸Ş½ÃÁö ¹× ÆÄ½Ì ¸Ş½ÃÁö Ã³¸®¸¦ À§ÇÑ º¯¼ö ¼±¾ğ
=======
		// ìˆ˜ì‹  ë©”ì‹œì§€ ë° íŒŒì‹± ë©”ì‹œì§€ ì²˜ë¦¬ë¥¼ ìœ„í•œ ë³€ìˆ˜ ì„ ì–¸
>>>>>>> origin/project1
		String msg;

		boolean status = true;

<<<<<<< HEAD
		// ¸Ş½ÃÁö °´Ã¼ »ı¼º
		Message m = new Message();

		// JSON ÆÄ¼­ ÃÊ±âÈ­
		Gson gson = new Gson();

		// ÀÔÃâ·Â ½ºÆ®¸²
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
  
=======
		// ë©”ì‹œì§€ ê°ì²´ ìƒì„±
		Message m = new Message();

		// JSON íŒŒì„œ ì´ˆê¸°í™”
		Gson gson = new Gson();

		// ì…ì¶œë ¥ ìŠ¤íŠ¸ë¦¼
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
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "´ÔÀÌ Á¾·áÇß½À´Ï´Ù.", "server", "")));
						seatNum[Integer.parseInt(m.getSeat())-1] = 0;
=======
					
//					System.out.println(msg);
					m = gson.fromJson(msg, Message.class);
//					if(m.getSeat().equals("")) {
//						System.out.println("°ø¹éÀÌ³ß?");
//					}
//					System.out.println(m);
					if (m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "´ÔÀÌ Á¾·áÇß½À´Ï´Ù.", "server", "")));
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
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "´ÔÀÌ ·Î±×ÀÎÇß½À´Ï´Ù.", "server", "")));
					} else if (m.getType().equals("adminlogin") ) {
						outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "´ÔÀÌ ·Î±×ÀÎÇß½À´Ï´Ù.", "server", "")));
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
//								ct.outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "´ÔÀÌ ·Î±×ÀÎÇß½À´Ï´Ù.", "server", "")));
//								break;
//							}
//						}
						msgSendToAdmin(gson.toJson(new Message(Integer.toString(seatNum[i]), m.getId(), "", "´ÔÀÌ ·Î±×ÀÎÇß½À´Ï´Ù.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						outMsg.println(gson.toJson(new Message("ÀüÃ¼", "°ü¸®ÀÚ", "", "´ÔÀÌ ·Î±×ÀÎÇß½À´Ï´Ù.", "server", "")));
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
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "ë‹˜ì´ ì¢…ë£Œí–ˆìŠµë‹ˆë‹¤.", "server", "")));
						status = false;
					} else if (m.getType().equals("login")) {
						msgSendToAdmin(gson.toJson(new Message(m.getSeat(), m.getId(), "", "ë‹˜ì´ ë¡œê·¸ì¸í–ˆìŠµë‹ˆë‹¤.", "server", "")));
					} else if (m.getType().equals("adminlogin")) {
						MyThread(gson.toJson(new Message("TopSeat", "ê´€ë¦¬ì", "", "ë‹˜ì´ ë¡œê·¸ì¸í–ˆìŠµë‹ˆë‹¤.", "server", "")));
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
//									.println(gson.toJson(new Message(m.getId(), "", "ê·“ì†ë§ ìƒëŒ€ë¥¼ ì°¾ì„ ìˆ˜ ì—†ìŠµë‹ˆë‹¤.", "none", "")));
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
				// ·çÇÁ¸¦ ¹ş¾î³ª¸é Å¬¶óÀÌ¾ğÆ® ¿¬°áÀÌ Á¾·áµÇ¹Ç·Î ½º·¹µå ÀÎÅÍ·´Æ®
				this.interrupt();
				logger.info(this.getName() + " Á¾·áµÊ!!");
			}
		}
		void msgSendToAdmin(String msg) {
			outMsg.println(msg);
			for (ChatThread ct : chatThreads) {
<<<<<<< HEAD
				if (ct.m.getId().equals("°ü¸®ÀÚ")) {
=======
				if (ct.m.getType().equals("adminlogin")) {
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
=======
				// ë£¨í”„ë¥¼ ë²—ì–´ë‚˜ë©´ í´ë¼ì´ì–¸íŠ¸ ì—°ê²°ì´ ì¢…ë£Œë˜ë¯€ë¡œ ìŠ¤ë ˆë“œ ì¸í„°ëŸ½íŠ¸
				this.interrupt();
				logger.info(this.getName() + " ì¢…ë£Œë¨!!");
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