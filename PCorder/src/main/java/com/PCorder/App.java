package com.PCorder;

import Controller.C_ProdManager;
import Controller.C_SignUp;
import Controller.C_login;
import Controller.PCController;
import Model.Customers_DAO;
<<<<<<< HEAD
import View.LoginView;
=======
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;
>>>>>>> origin/project1

/////////////////////////////////////
// Test Bench
/////////////////////////////////////
public class App 
{
<<<<<<< HEAD
	/////////////////////////////////////
	// Test Bench
	/////////////////////////////////////
    public static void main( String[] args) throws Exception{
    	//new LoginView(null);
    	//Customers_DAO.getInstance(); //ÇØÁàµµ µÇ°í ¾È ÇØÁàµµ µÊ. ¹Ù·Î ¸Þ¸ð¸® ÇÒ´ç ÇØ¹ö¸®±â ¶§¹®.
    	Customers_DAO.getConnection();
    	Customers_DAO.CUSTOMERS_FUNC_1();
    	Customers_DAO.closeJDBC(Customers_DAO.conn, Customers_DAO.pstmt, Customers_DAO.stmt, Customers_DAO.rs);
    }
=======
	public static PCController app;
	public static Customers_DAO dao;
	public static void main(String[] args) {
		System.out.println("App.javaì—ì„œ í”„ë¡œê·¸ëž¨ì„ ì‹œìž‘í•©ë‹ˆë‹¤...");
		////////////////////////////////////////////////////
		//			â€»	í”„ë¡œê·¸ëž¨ ì‹¤í–‰ ìˆœì„œ		â€»
		// -> Controller\PCServer.java
		// -> com.PCorder\App.java
		////////////////////////////////////////////////////
				
		//ì»¨íŠ¸ë¡¤ëŸ¬ ê°ì²´ ìƒì„±
		app = new PCController	(
								LoginView.getInstance(), CusManager.getInstance(), 
								ProdManager.getInstance(), GUIView.getInstance(),
								new AdminView(), new SignUpView(), 
								new C_login(), new C_SignUp(), 
								new C_ProdManager(), new PCChatData(), 
								new PCChatData()
								);
		
		//ê³ ê° DAOê°ì²´ ìƒì„±
		dao = Customers_DAO.getInstance();
		
		app.appMain();
	}
>>>>>>> origin/project1
}
