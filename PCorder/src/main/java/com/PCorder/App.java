package com.PCorder;

import Model.Customers_DAO;

public class App 
{
	/////////////////////////////////////
	// Test Bench
	/////////////////////////////////////
    public static void main( String[] args) throws Exception{
    	//Customers_DAO.getInstance(); //해줘도 되고 안 해줘도 됨. 바로 메모리 할당 해버리기 때문.
    	Customers_DAO.getConnection();
    	
    	Customers_DAO.CUSTOMERS_FUNC_1();
    	
    	Customers_DAO.closeJDBC(Customers_DAO.conn, Customers_DAO.pstmt, Customers_DAO.stmt, Customers_DAO.rs);
    }
}
