package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import javax.swing.JOptionPane;

=======
>>>>>>> origin/project1
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
<<<<<<< HEAD
				PM.ta.setText("°ü¸®¹øÈ£\t»óÇ°¸í\t´Ü°¡\tÁ¦Á¶»ç\n");
				PM.prodCombo.removeAllItems();
				PM.prodCombo.addItem("ÀüÃ¼");	//"ÀüÃ¼"
=======
				PM.ta.setText("ê´€ë¦¬ë²ˆí˜¸\tìƒí’ˆëª…\të‹¨ê°€\tì œì¡°ì‚¬\n");
				PM.prodCombo.removeAllItems();
				PM.prodCombo.addItem("ì „ì²´");	//"ì „ì²´"
>>>>>>> origin/project1
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
<<<<<<< HEAD
					//pTYPEÀº »ý·«
=======
					//pTYPEì€ ìƒëžµ
>>>>>>> origin/project1
					dto.setpMANUF(rs.getString(5));
					str += dto.getpMANUF();
					str += "\n";
					
<<<<<<< HEAD
					PM.v.add(dto); //º¤ÅÍ¿¡ Ãß°¡.
=======
					PM.v.add(dto); //ë²¡í„°ì— ì¶”ê°€.
>>>>>>> origin/project1
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
<<<<<<< HEAD
		String sql = "INSERT INTO PRODUCTS(PRODUCTS.pNAME, PRODUCTS.pPRICE, PRODUCTS.pTYPE, PRODUCTS.pMANUF) VALUES(?, ?, ?, ?)";
		String sql2 = "UPDATE PRODUCTS SET pNAME = ?, pPRICE = ?, pTYPE = ?, pMANUF = ? WHERE pID = ?";
		try {
			conn = getConnection();
			if(f == true) { // »ðÀÔ
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, PM.prodtf[0].getText());							// Á¦Ç° ÀÌ¸§
				pstmt.setInt(2, Integer.valueOf(PM.prodtf[1].getText()));			// Á¦Ç° °¡°Ý
				pstmt.setString(3, String.valueOf(PM.prodType.getSelectedItem()));	// Á¦Ç° Å¸ÀÔ
				pstmt.setString(4, PM.prodtf[2].getText());							// Á¦Ç° Á¦Á¶»ç
				int r = pstmt.executeUpdate();
				
				if(r > 0) {
					PM.stateText.setText("## ¸Þ½ÃÁö : ÇØ´ç Á¦Ç°ÀÇ »ðÀÔÀÌ Á¤»óÀûÀ¸·Î Ã³¸®µÇ¾ú½À´Ï´Ù.");
				}
				else {
					PM.stateText.setText("## ¸Þ½ÃÁö : Á¦Ç°À» Ãß°¡ÇÏ´Âµ¥ ½ÇÆÐÇß½À´Ï´Ù.");
				}
			}
			else {			// ¼öÁ¤
				
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			
		}
=======
		String sql = "INSERT";
>>>>>>> origin/project1
		
	}
	public void SQL_UPDATE() {
		
	}
	public void SQL_DELETE() {
		
	}
}
