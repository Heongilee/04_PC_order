package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import View.ProdManager;

public class Product_DAO implements DAO_Interface{
	public static ProdManager PM = ProdManager.getInstance();
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
	
	public void SQL_SHOW(boolean f, int id) {
		String sql = "SELECT * FROM PRODUCTS";
		String sql2 = "SELECT pNAME, pPRICE, pMANUF FROM PRODUCTS WHERE pID = ?";
		try {
			conn = getConnection();
			
			if(f == true) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				Product_DTO dto = new Product_DTO();
				
				String str = "";
				PM.ta.setText("관리번호\t상품명\t단가\t제조사\n");
				PM.prodCombo.removeAllItems();
				PM.prodCombo.addItem("전체");	//"전체"
				while(rs.next()) {
					dto.setpID(rs.getInt(1));
					System.out.println("[1] : "+dto.getpID());
					str += String.valueOf(dto.getpID());
					str += "\t";
					dto.setpNAME(rs.getString(2));
					str += dto.getpNAME();
					str += "\t";
					dto.setpPrice(rs.getInt(3));
					str += String.valueOf(dto.getpPrice());
					str += "\t";
					//pTYPE은 생략
					dto.setpMANUF(rs.getString(5));
					str += dto.getpMANUF();
					str += "\n";
					
					PM.v.add(dto); //벡터에 추가.
					PM.prodCombo.addItem(String.valueOf(dto.getpID()));
				}
				PM.ta.append(str);
			}
			else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					PM.prodtf[0].setText(rs.getString(1));
					PM.prodtf[1].setText(String.valueOf(rs.getInt(2)));
					PM.prodtf[2].setText(rs.getString(3));
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch(Exception e2) {
			e2.printStackTrace();
		} finally {
			Product_DAO.closeJDBC(conn, pstmt, pstmt, rs);
		}
		
		return;
	}
	public void SQL_INSERT(boolean f, int id) {
		String sql = "INSERT";
		
	}
	public void SQL_UPDATE() {
		
	}
	public void SQL_DELETE() {
		
	}
}
