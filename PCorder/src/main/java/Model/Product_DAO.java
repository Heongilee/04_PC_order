package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product_DAO implements DAO_Interface{
	private static Product_DAO dao = Product_DAO.getInstance();
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static Statement stmt;
	public static ResultSet rs;
	
	private Product_DAO() {}
	
	public static Connection getConnection() throws Exception{
		conn = null;
		stmt = null;
		pstmt = null;
		rs = null;
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pw);
		return conn;
	}
	public static void closeJDBC(Connection conn, PreparedStatement pstmt, Statement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static Product_DAO getInstance() {
		if(dao == null) {
			dao = new Product_DAO();
		}
		return dao;
	}
	
	public void SQL_SHOW() {
		
	}
	public void SQL_INSERT() {
		
	}
	public void SQL_UPDATE() {
		
	}
	public void SQL_DELETE() {
		
	}
}
