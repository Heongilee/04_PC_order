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
    	//Customers_DAO.getInstance(); //해줘도 되고 안 해줘도 됨. 바로 메모리 할당 해버리기 때문.
    	Customers_DAO.getConnection();
    	Customers_DAO.CUSTOMERS_FUNC_1();
    	Customers_DAO.closeJDBC(Customers_DAO.conn, Customers_DAO.pstmt, Customers_DAO.stmt, Customers_DAO.rs);
    }
=======
	public static PCController app;
	public static Customers_DAO dao;
	public static void main(String[] args) {
		System.out.println("App.java�뿉�꽌 �봽濡쒓렇�옩�쓣 �떆�옉�빀�땲�떎...");
		////////////////////////////////////////////////////
		//			���	�봽濡쒓렇�옩 �떎�뻾 �닚�꽌		���
		// -> Controller\PCServer.java
		// -> com.PCorder\App.java
		////////////////////////////////////////////////////
				
		//而⑦듃濡ㅻ윭 媛앹껜 �깮�꽦
		app = new PCController	(
								LoginView.getInstance(), CusManager.getInstance(), 
								ProdManager.getInstance(), GUIView.getInstance(),
								new AdminView(), new SignUpView(), 
								new C_login(), new C_SignUp(), 
								new C_ProdManager(), new PCChatData(), 
								new PCChatData()
								);
		
		//怨좉컼 DAO媛앹껜 �깮�꽦
		dao = Customers_DAO.getInstance();
		
		app.appMain();
	}
>>>>>>> origin/project1
}
