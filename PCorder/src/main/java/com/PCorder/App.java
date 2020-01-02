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
    	//Customers_DAO.getInstance(); //���൵ �ǰ� �� ���൵ ��. �ٷ� �޸� �Ҵ� �ع����� ����.
    	Customers_DAO.getConnection();
    	Customers_DAO.CUSTOMERS_FUNC_1();
    	Customers_DAO.closeJDBC(Customers_DAO.conn, Customers_DAO.pstmt, Customers_DAO.stmt, Customers_DAO.rs);
    }
=======
	public static PCController app;
	public static Customers_DAO dao;
	public static void main(String[] args) {
		System.out.println("App.java에서 프로그램을 시작합니다...");
		////////////////////////////////////////////////////
		//			※	프로그램 실행 순서		※
		// -> Controller\PCServer.java
		// -> com.PCorder\App.java
		////////////////////////////////////////////////////
				
		//컨트롤러 객체 생성
		app = new PCController	(
								LoginView.getInstance(), CusManager.getInstance(), 
								ProdManager.getInstance(), GUIView.getInstance(),
								new AdminView(), new SignUpView(), 
								new C_login(), new C_SignUp(), 
								new C_ProdManager(), new PCChatData(), 
								new PCChatData()
								);
		
		//고객 DAO객체 생성
		dao = Customers_DAO.getInstance();
		
		app.appMain();
	}
>>>>>>> origin/project1
}
