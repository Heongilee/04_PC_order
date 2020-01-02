package Controller;

<<<<<<< HEAD
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JButton;
>>>>>>> origin/project1
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;

=======
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Model.Customers_DAO;
>>>>>>> origin/project1
import Model.Message;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

public class PCController implements Runnable {
<<<<<<< HEAD
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

	// ¸Þ½ÃÁö Å¬·¡½º ÂüÁ¶ °´Ã¼
	Message m;
	// ·Î°Å °´Ã¼
	Logger logger;

=======
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

	// ë©”ì‹œì§€ í´ëž˜ìŠ¤ ì°¸ì¡° ê°ì²´
	Message m;
	// ë¡œê±° ê°ì²´
	Logger logger;
>>>>>>> origin/project1
	String ip = "127.0.0.1";
	Socket socket;
	BufferedReader inMsg;
	PrintWriter outMsg;
	Thread thread;
	boolean status;
<<<<<<< HEAD

	boolean comboFlag = false;
<<<<<<< HEAD
	
=======
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV,
			C_login cl, PCChatData CMchatData, PCChatData GUIchatData) {
		// ·Î°Å °´Ã¼ ÃÊ±âÈ­
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
		// µ¥ÀÌÅÍ °´Ã¼¿¡¼­ µ¥ÀÌÅÍ º¯È­¸¦ Ã³¸®ÇÒ UI °´Ã¼ Ãß°¡, ta2´Â TextAreaÀÌ´Ù.
		CMchatData.addObjCus(CM.chatContent);
		GUIchatData.addObjGUI(GUI.ta2);
		CMchatData.addObjCombo(CM.chatComboBox);
<<<<<<< HEAD
=======
		
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
		LV.addButtonActionListener(new ActionListener() { // ·Î±×ÀÎ ºä ·¹ÀÌ¾Æ¿ô
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) { // ·Î±×ÀÎ ¹öÆ°À» ´­·¶À» ¶§
					if (LV.server.isSelected()) { // server mode¿¡ Ã¼Å© µÇ¾îÀÖÀ» °æ¿ì
						LV.cardLayout.show(LV.window, "admin");
						CM.loginFlag = true;
						cl.Mode_Check();
						/* °ü¸®ÀÚ ·Î±×ÀÎ µé¾î°¬À» °æ¿ì ÀÌº¥Æ® Ã³¸® */
//						CM.chatContent
						connectServer();
<<<<<<< HEAD
=======
						
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
//						comboFlag = true;
					} else if (LV.user.isSelected()) { // user mode¿¡ Ã¼Å© µÇ¾îÀÖÀ» °æ¿ì
						LV.setVisible(false);
						LV.GV.getInstance().setVisible(true);
						cl.Mode_Check();
						/* »ç¿ëÀÚ ·Î±×ÀÎ µé¾î°¬À» °æ¿ì ÀÌº¥Æ® Ã³¸® */
						GUI.id = LV.loginTextField.getText();
						GUI.la[0].setText("¾ÆÀÌµð : " + GUI.id);
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
				} else if (obj == LV.SignUpbtn) { // È¸¿ø°¡ÀÔ ¹öÆ°À» ´­·¶À» °æ¿ì
					LV.cardLayout.show(LV.window, "signUp");
					cl.Mode_Check();
				} else if (obj == LV.previousBtn) { // Åø¹Ù ÀÌÀü ¹öÆ°À» ´­·¶À» °æ¿ì
					LV.cardLayout.show(LV.window, "layer");
					cl.Mode_Check();
=======
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, GUIView GUI, AdminView AV, SignUpView SUV, C_login cl, C_SignUp cs, C_ProdManager cp, PCChatData chatData, PCChatData chatData2) {
		// ë¡œê±° ê°ì²´ ì´ˆê¸°í™”
		logger = Logger.getLogger(this.getClass().getName());
		
		this.LV = LV;				// LoginView ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.CM = CM;				// CusManager ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.PM = PM;				// ProdManager ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.GUI = GUI;				// GUIView ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.AV = AV;				// AdminView ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.SUV = SUV;				// SignUpView ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.cl = cl;				// C_login ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.cs = cs;				// C_SignUp ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.cp = cp;				// C_ProdManager ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.chatData = chatData;	// PCChatData ì°¸ì¡°ê°ì²´ ì—°ê²°
		this.chatData2 = chatData2;	// PCChatData2 ì°¸ì¡°ê°ì²´ ì—°ê²°
	}

	public void appMain() {
		// ë°ì´í„° ê°ì²´ì—ì„œ ë°ì´í„° ë³€í™”ë¥¼ ì²˜ë¦¬í•  UI ê°ì²´ ì¶”ê°€, ta2ëŠ” TextAreaì´ë‹¤.
		chatData.addObjCus(CM.chatContent);
		chatData2.addObjGUI(GUI.ta2);
		
		// ë¡œê·¸ì¸ ë·° ì´ë²¤íŠ¸ ì²˜ë¦¬
		LV.addButtonActionListener(new ActionListener() { // ë¡œê·¸ì¸ ë·° ë ˆì´ì•„ì›ƒ
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) { // ë¡œê·¸ì¸ ë²„íŠ¼ì„ ëˆŒë €ì„ ë•Œ
					if (LV.server.isSelected()) { // server modeì— ì²´í¬ ë˜ì–´ìžˆì„ ê²½ìš° (ê´€ë¦¬ìž cMODE : 0)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 0)) {
							// ------- ë¡œê·¸ì¸ ì„±ê³µ!! -------
							LV.cardLayout.show(LV.window, "admin");
							CM.loginFlag = true;
							
							/* ê´€ë¦¬ìž ë¡œê·¸ì¸ ë“¤ì–´ê°”ì„ ê²½ìš° ì´ë²¤íŠ¸ ì²˜ë¦¬ */
							connectServer();
						}
						else {
							// ------- ë¡œê·¸ì¸ ì‹¤íŒ¨... -------
							return;
						}
						
					} else if (LV.user.isSelected()) { // user modeì— ì²´í¬ ë˜ì–´ìžˆì„ ê²½ìš° (ì‚¬ìš©ìž cMODE : 1)
						if(cl.Mode_Check(LV.loginTextField.getText(), LV.passwordField.getText(), 1)) {
							// ------- ë¡œê·¸ì¸ ì„±ê³µ!! -------
							
							/*	í™”ë©´ ì „í™˜	*/
							LV.setVisible(false);
							LV.GV.getInstance().setVisible(true);
							
							/*	ì‚¬ìš©ìž ë¡œê·¸ì¸ ë“¤ì–´ê°”ì„ ê²½ìš° ì´ë²¤íŠ¸ ì²˜ë¦¬	*/
							String id = LV.loginTextField.getText();
							
							GUI.la[0].setText("ì•„ì´ë”” : " + id);
							GUI.la[2].setText("í¬ì¸íŠ¸ : "+ dao.getInstance().getCash(id));
							connectServer();
						}
						else {
							// ------- ë¡œê·¸ì¸ ì‹¤íŒ¨... -------
							return;
						}
					} else {}
				} else if (obj == LV.SignUpbtn) { // íšŒì›ê°€ìž… ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					LV.cardLayout.show(LV.window, "signUp");
				} else if (obj == LV.previousBtn) { // íˆ´ë°” ì´ì „ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					System.out.println("PREV TEST");
					LV.cardLayout.show(LV.window, "layer");
>>>>>>> origin/project1
				} else {

				}
			}
		});
<<<<<<< HEAD
		LV.adminView.addButtonActionListener(new ActionListener() { // °ü¸®ÀÚ ºä ·¹ÀÌ¾Æ¿ô
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // °ü¸®ÀÚ ºä¿¡¼­ °í°´°ü¸® ¹öÆ°À» ´­·¶À» °æ¿ì
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
					
//					comboFlag = true;
				} else if (obj == LV.adminView.pm_btn) { // °ü¸®ÀÚ ºä¿¡¼­ »óÇ°°ü¸® ¹öÆ°À» ´­·¶À» °æ¿ì
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
				}
			}
		});
		LV.signUpView.addButtonActionListener(new ActionListener() { // È¸¿ø°ü¸® ºä
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.signUpView.IdOverlapbtn) { // È¸¿ø°ü¸® ºä¿¡¼­ Áßº¹È®ÀÎ ¹öÆ°À» ´­·¶À» °æ¿ì
					try {
						JOptionPane.showMessageDialog(null, "ÀÌ ¾ÆÀÌµð Áßº¹ ¾øµÂ ~~ ");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "´Ù¸¥ ¾ÆÀÌµð¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
					}
					cl.Mode_Check();
				} else if (obj == LV.signUpView.btn) { // È¸¿ø°ü¸® ºä¿¡¼­ ¿Ï·á ¹öÆ°À» ´­·¶À» °æ¿ì
					try {
						JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔÀ» ÃàÇÏÇÕ´Ï´Ù!!");
						LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					}
					cl.Mode_Check();
				}
			}
		});
		CM.addButtonActionListener(new ActionListener() { // °í°´°ü¸® ºä
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) { // °í°´°ü¸® ºä¿¡¼­ Ã¤ÆÃ
					outMsg.println(gson.toJson(new Message("Ä«¿îÅÍ", CM.id, "", CM.chatInput.getText(), "admin", "sendtoall")));
					CM.chatInput.setText("");
					cl.Mode_Check();
				} else if (obj == CM.previousBtn) { // °í°´°ü¸® ºä¿¡¼­ ÀÌÀü ¹öÆ°À» ´­·¶À» °æ¿ì
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					cl.Mode_Check();
				} else if (obj == CM.logoutBtn) { // °í°´°ü¸® ºä¿¡¼­ ·Î±×¾Æ¿ô ¹öÆ°À» ´­·¶À» °æ¿ì
=======
		
		//ë¡œê·¸ì¸ ë·°->ê´€ë¦¬ìž ë·° ì´ë²¤íŠ¸ ì²˜ë¦¬
		LV.adminView.addButtonActionListener(new ActionListener() { // ê´€ë¦¬ìž ë·° ë ˆì´ì•„ì›ƒ
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) { // ê´€ë¦¬ìž ë·°ì—ì„œ ê³ ê°ê´€ë¦¬ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				} else if (obj == LV.adminView.pm_btn) { // ê´€ë¦¬ìž ë·°ì—ì„œ ìƒí’ˆê´€ë¦¬ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
				}
			}
		});
		
		//ë¡œê·¸ì¸ ë·°->íšŒì›ê°€ìž… ë·° ì´ë²¤íŠ¸ ì²˜ë¦¬
		LV.signUpView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				//SignUpViewì—ì„œ setNameí•œ ê°’ì„ ê°€ì§€ê³  if-elseë¬¸ìœ¼ë¡œ ë¶„ê¸°ì¡°ê±´ì„ ì£¼ì—ˆë‹¤.
				if(btn.getName().equals("IdOverlapbtn")) {
					cs.Valid_Check(0);
				}
				else if(btn.getName().equals("NameOverlapbtn")) {
					cs.Valid_Check(1);
				}
				else if(btn.getName().equals("EmailOverlapbtn")) {
					cs.Valid_Check(2);
				}
				else { //íšŒì›ê°€ìž… ì œì¶œ ë²„íŠ¼ (btn)
					try {
						cs.Register_Complete();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		//ê³ ê° ê´€ë¦¬ ë·° ì´ë²¤íŠ¸ ì²˜ë¦¬
		CM.addButtonActionListener(new ActionListener() { // ê³ ê°ê´€ë¦¬ ë·°
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) { // ê³ ê°ê´€ë¦¬ ë·°ì—ì„œ ì±„íŒ…
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
				} else if (obj == CM.previousBtn) { // ê³ ê°ê´€ë¦¬ ë·°ì—ì„œ ì´ì „ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == CM.logoutBtn) { // ê³ ê°ê´€ë¦¬ ë·°ì—ì„œ ë¡œê·¸ì•„ì›ƒ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
>>>>>>> origin/project1
					CM.chatContent.setText("");
					CM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
<<<<<<< HEAD
					cl.Mode_Check();
				} else if (obj == CM.chatComboBox){
					/*°í°´°ü¸® Ã¢ ÄÞº¸¹Ú½º ÀÌº¥Æ® Ã³¸®*/
					if(CM.chatComboBox.getSelectedIndex() == 0) {
						
					}
				} else {
					
				}
			}
		});
		PM.addButtonActionListener(new ActionListener() { // »óÇ°°ü¸® ºä
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == PM.previousBtn) { // »óÇ°°ü¸® ºä¿¡¼­ ÀÌÀü ¹öÆ°À» ´­·¶À» °æ¿ì
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					cl.Mode_Check();
				} else if (obj == PM.logoutBtn) { // »óÇ°°ü¸® ºä¿¡¼­ ·Î±×¾Æ¿ô ¹öÆ°À» ´­·¶À» °æ¿ì
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
					cl.Mode_Check();
				} else {

				}
			}
		});
=======
				} else {

				}
			}
		});
		
		//ìƒí’ˆ ê´€ë¦¬ ì´ë²¤íŠ¸ ì²˜ë¦¬
		PM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == PM.previousBtn) { // ìƒí’ˆê´€ë¦¬ ë·°ì—ì„œ ì´ì „ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
				} else if (obj == PM.logoutBtn) { // ìƒí’ˆê´€ë¦¬ ë·°ì—ì„œ ë¡œê·¸ì•„ì›ƒ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					PM.setVisible(false);
					LV.getInstance().setVisible(true);
					LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				} else if(obj == PM.btn[0]){  //ë“±ë¡
					cp.insertion();
				} else if(obj == PM.btn[1]) { //ì¡°íšŒ
					cp.show();
				} else if(obj == PM.btn[2]) { //ì‚­ì œ
					cp.deletion();
				} else {}
			}
		});
		
>>>>>>> origin/project1
		GUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
<<<<<<< HEAD
				
<<<<<<< HEAD
				if (obj == GUI.LogOutbtn) { // »ç¿ëÀÚ ºä¿¡¼­ ·Î±×¾Æ¿ô ¹öÆ°À» ´­·¶À» °æ¿ì
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "adminlogin")));
					GUI.msgInput.setText("");
=======
				if (obj == GUI.LogOutbtn) { // »óÇ°°ü¸® ºä¿¡¼­ ·Î±×¾Æ¿ô ¹öÆ°À» ´­·¶À» °æ¿ì
					outMsg.println(gson.toJson(new Message(m.getSeat(), m.getId(), "", "", "logout", "")));
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
					cl.Mode_Check();
=======
				if (obj == GUI.LogOutbtn) { // ìƒí’ˆê´€ë¦¬ ë·°ì—ì„œ ë¡œê·¸ì•„ì›ƒ ë²„íŠ¼ì„ ëˆŒë €ì„ ê²½ìš°
					outMsg.println(gson.toJson(new Message(GUI.seat, GUI.id, "", "", "logout", "")));
>>>>>>> origin/project1
					try {
						outMsg.close();
						inMsg.close();
						socket.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
<<<<<<< HEAD
					status = false;
					System.exit(0);
				} else if (obj == GUI.msgInput) {
<<<<<<< HEAD
					String test = gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "admins"));
					outMsg.println(test);
					System.out.println(test);
=======
					outMsg.println(gson.toJson(new Message(m.getSeat(), GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "")));
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
					GUI.msgInput.setText("");
				}
			}
		});
		
=======
					System.exit(0);
					status = false;
				} else if (obj == GUI.msgInput) {
					outMsg.println(
							gson.toJson(new Message(GUI.seat, GUI.id, "", GUI.msgInput.getText(), "sendtoadmin", "")));
					GUI.msgInput.setText("");
				}
				else if(obj == GUI.sumb) {
					int value = Integer.parseInt(GUI.Cashl.getText());
					if(dao.getInstance().Cash_Check(LV.loginTextField.getText(), value)){
						JOptionPane.showMessageDialog(null, "ê²°ì œê°€ ë˜ì—ˆìŠµë‹ˆë‹¤.");
						GUI.la[2].setText("í¬ì¸íŠ¸ : " + Integer.toString(Integer.parseInt(dao.getInstance().getCash(LV.loginTextField.getText()))-value));
					}
					else
						JOptionPane.showMessageDialog(null, "í¬ì¸íŠ¸ê°€ ë¶€ì¡±í•©ë‹ˆë‹¤.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
>>>>>>> origin/project1
	}

	public void connectServer() {
		try {
<<<<<<< HEAD
			// ¼ÒÄÏ »ý¼º
			socket = new Socket(ip, 8888);
			logger.info("[Client]Server ¿¬°á ¼º°ø!!");

			// ÀÔÃâ·Â ½ºÆ®¸² »ý¼º
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);

			// ¼­¹ö¿¡ ·Î±×ÀÎ ¸Þ½ÃÁö Àü´Þ
<<<<<<< HEAD
			if (CM.loginFlag) {
				m = new Message("Ä«¿îÅÍ", CM.id, "", "", "adminlogin", "");
			} else {
				m = new Message("0", GUI.id, "", "", "login", "adminlogin");
			}
			outMsg.println(gson.toJson(m));
=======
			if (CM.loginFlag == true) {
				m = new Message("0", GUI.id, "", "", "adminlogin", "");
			} else {
				m = new Message("0", GUI.id, "", "", "login", "");
			}
			outMsg.println(gson.toJson(m));
			

>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
			// ¸Þ½ÃÁö ¼ö½ÅÀ» À§ÇÑ ½º·¹µå »ý¼º
			thread = new Thread(this);
			thread.start();
			
<<<<<<< HEAD
=======
			
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
			// »ç¿ëÀÚ ºä¿¡ ½ÃÆ® ¹øÈ£ ÀúÀå
//			GUI.seat = m.getSeat();
//			GUI.id = m.getId();
		} catch (Exception e) {
			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception ¹ß»ý!!");
=======
			// ì†Œì¼“ ìƒì„±
			socket = new Socket(ip, 8888);
			logger.info("[Client]Server ì—°ê²° ì„±ê³µ!!");

			// ìž…ì¶œë ¥ ìŠ¤íŠ¸ë¦¼ ìƒì„±
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(), true);

			// ì„œë²„ì— ë¡œê·¸ì¸ ë©”ì‹œì§€ ì „ë‹¬
			if (CM.loginFlag == true) {
				m = new Message("", LV.id, "", "", "adminlogin", "");
			} else {
				m = new Message("", LV.id, "", "", "login", "");
			}
			outMsg.println(gson.toJson(m));

			// ë©”ì‹œì§€ ìˆ˜ì‹ ì„ ìœ„í•œ ìŠ¤ë ˆë“œ ìƒì„±
			thread = new Thread(this);
			thread.start();
		} catch (Exception e) {
			logger.log(Level.WARNING, "[MultiChatUI]connectServer() Exception ë°œìƒ!!");
>>>>>>> origin/project1
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
<<<<<<< HEAD
		// ¼ö½Å ¸Þ½ÃÁö¸¦ Ã³¸®ÇÏ´Â µ¥ ÇÊ¿äÇÑ º¯¼ö ¼±¾ð
		String msg;
		status = true;
		while (status) {
			try {
				// ¸Þ½ÃÁö ¼ö½Å ¹× ÆÄ½Ì
				msg = inMsg.readLine();
<<<<<<< HEAD
				Message m_temp = gson.fromJson(msg, Message.class);
				System.out.println(msg);
//				System.out.println(m.getSeat());
				if(m.getSeat() == "0" && GUI.seat == "") {
					System.out.println("TEST");
					GUI.seat = m_temp.getSeat();
					m.setSeat(m_temp.getSeat());
				}
				// comboBox °»½Å
//				if(comboFlag == true) {
//				CMchatData.comboRefreshData(m.getSeat());
//					comboFlag = false;
//				}
				// MultiChatData °´Ã¼·Î µ¥ÀÌÅÍ °»½Å
				if(CM.loginFlag)
				{	
					System.out.println("°ü¸®ÀÚ ÄÚµå");
					CMchatData.refreshData(GUI.seat + " ÁÂ¼®(" + m_temp.getId() + "):" + m_temp.getMsg() + "\n");
					CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
				}
				else {
					System.out.println("»ç¿ëÀÚ ÄÚµå");
				GUIchatData.refreshData(GUI.seat + " ÁÂ¼®(" + m_temp.getId() + "):" + m_temp.getMsg() + "\n");
=======
				m = gson.fromJson(msg, Message.class);
 
				// comboBox °»½Å
//				if(comboFlag == true) {
				CMchatData.comboRefreshData(m.getSeat());
//					comboFlag = false;
//				}
				// MultiChatData °´Ã¼·Î µ¥ÀÌÅÍ °»½Å
				CMchatData.refreshData(m.getSeat() + "¹ø ÁÂ¼®(" + m.getId() + "):" + m.getMsg() + "\n");
				GUIchatData.refreshData(m.getSeat() + "¹ø ÁÂ¼®(" + m.getId() + "):" + m.getMsg() + "\n");
				// Ä¿¼­¸¦ ÇöÀç ´ëÈ­ ¸Þ½ÃÁö¿¡ Ç¥½Ã
				CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
>>>>>>> 0dc03679d7d637e8d09dc6b4506f4b2e92edcc2f
				GUI.ta2.setCaretPosition(GUI.ta2.getDocument().getLength());
				}
				// Ä¿¼­¸¦ ÇöÀç ´ëÈ­ ¸Þ½ÃÁö¿¡ Ç¥½Ã
			} catch (IOException e) {
				logger.log(Level.WARNING, "[MultiChatUI]¸Þ½ÃÁö ½ºÆ®¸² Á¾·á!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " ¸Þ½ÃÁö ¼ö½Å ½º·¹µå Á¾·áµÊ!!");
	} // run()
	
	public static void main(String[] args) {
		PCController app = new PCController(LoginView.getInstance(), CusManager.getInstance(),ProdManager.getInstance(), GUIView.getInstance(), new AdminView(), new SignUpView(), new C_login(), new PCChatData(), new PCChatData());
		app.appMain();
	}
=======
		// ìˆ˜ì‹  ë©”ì‹œì§€ë¥¼ ì²˜ë¦¬í•˜ëŠ” ë° í•„ìš”í•œ ë³€ìˆ˜ ì„ ì–¸
		String msg;
		status = true;

		while (status) {
			try {
				// ë©”ì‹œì§€ ìˆ˜ì‹  ë° íŒŒì‹±
				msg = inMsg.readLine();
				m = gson.fromJson(msg, Message.class);
				String whisperMsg = "";

				// MultiChatData ê°ì²´ë¡œ ë°ì´í„° ê°±ì‹ 
				chatData.refreshData(m.getSeat() + "ë²ˆ ì¢Œì„" + m.getId() + ":" + m.getMsg() + "\n");
				chatData2.refreshData(m.getSeat() + "ë²ˆ ì¢Œì„" + m.getId() + ":" + m.getMsg() + "\n");
				// ì»¤ì„œë¥¼ í˜„ìž¬ ëŒ€í™” ë©”ì‹œì§€ì— í‘œì‹œ
				CM.chatContent.setCaretPosition(CM.chatContent.getDocument().getLength());
				GUI.ta2.setCaretPosition(GUI.ta2.getDocument().getLength());
			} catch (IOException e) {
				logger.log(Level.WARNING, "[MultiChatUI]ë©”ì‹œì§€ ìŠ¤íŠ¸ë¦¼ ì¢…ë£Œ!!");
			}
		}
		logger.info("[MultiChatUI]" + thread.getName() + " ë©”ì‹œì§€ ìˆ˜ì‹  ìŠ¤ë ˆë“œ ì¢…ë£Œë¨!!");
	} // run()
>>>>>>> origin/project1

}
