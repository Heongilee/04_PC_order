package com.PCorder;

import Controller.C_SignUp;
import Controller.C_login;
import Controller.PCController;
import Model.Customers_DAO;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
import View.GUIView;
import View.LoginView;
import View.ProdManager;
import View.SignUpView;

/////////////////////////////////////
// Test Bench
/////////////////////////////////////
public class App 
{
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
								new PCChatData(), new PCChatData()
								);
		
		//고객 DAO객체 생성
		dao = Customers_DAO.getInstance();
		
		app.appMain();
	}
}
