package Model;

import java.sql.*;

public class Customers_DAO implements DAO_Interface{
	//private static Customers_DAO dao;
	//1. 바로 메모리 할당하는 방법을 사용.
	private static Customers_DAO dao = new Customers_DAO();
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static Statement stmt;
	public static ResultSet rs;
	
	public static Connection getConnection() throws Exception{
		conn = null;
		stmt = null;
		pstmt = null;
		rs = null;
		
		//1-1. DBMS에 맞게 드라이버를 로드.
		Class.forName(driver);
		
		//1-2. DriverManager를 Connection에 연결
		conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
	//2. Connection, PrepareStatement, ResultSet 모두 close한다.
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
		System.out.println("-- DataBase 연결을 해제합니다...");
	}
	//3. 외부의 인스턴스화를 막는다.
	private Customers_DAO() {}
	
	//4. Customers_DAO의 인스턴스를 얻는 방법은 getInstance() 하나 뿐이다.
	public static Customers_DAO getInstance() {
		if(dao == null) {
			dao = new Customers_DAO();
		}
		return dao;
	}
	
	public static void CUSTOMERS_FUNC_1() throws SQLException {
		Customer_DTO dto;
		
		String sql = "SELECT * FROM CUSTOMERS";
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			dto = new Customer_DTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
			
			/////////////
			// 
			/////////////
		}
		
		return;
	}
}
