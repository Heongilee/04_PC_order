package com.PCorder;

import Controller.C_SignUp;
import Controller.C_login;
import Controller.PCController;
import Model.Customers_DAO;
import Model.PCChatData;
import View.AdminView;
import View.CusManager;
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
		System.out.println("App.java���� ���α׷��� �����մϴ�...");
		
		//��Ʈ�ѷ� ��ü ����
		app = new PCController(
				LoginView.getInstance(), CusManager.getInstance(), 
				ProdManager.getInstance(), new AdminView(), 
				new SignUpView(), new C_login(), 
				new C_SignUp(), new PCChatData()
				);
		
		//�� DAO��ü ����
		dao = Customers_DAO.getInstance();
		
		app.appMain();
	}
}
