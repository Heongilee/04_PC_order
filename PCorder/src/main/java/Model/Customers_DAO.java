package Model;

import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class Customers_DAO implements DAO_Interface{
	//private static Customers_DAO dao;
	//1. �ٷ� �޸� �Ҵ��ϴ� ����� ���.
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
		
		//1-1. DBMS�� �°� ����̹��� �ε�.
		Class.forName(driver);
		
		//1-2. DriverManager�� Connection�� ����
		conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
	//2. Connection, PrepareStatement, ResultSet ��� close�Ѵ�.
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
	//3. �ܺ��� �ν��Ͻ�ȭ�� ���´�.
	private Customers_DAO() {}
	
	//4. Customers_DAO�� �ν��Ͻ��� ��� ����� getInstance() �ϳ� ���̴�.
	public static Customers_DAO getInstance() {
		if(dao == null) {
			dao = new Customers_DAO();
		}
		return dao;
	}
	
	//��ȿ�� �˻簡 ���� ȸ���� ȸ������ ��Ŀ� ���� dto��ü�� ���� INSERT���� �����Ѵ�.
	public void CUSTOMERS_FUNC1(Customer_DTO dto) throws SQLException {
		System.out.println(dto.toString());
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO CUSTOMERS(CUSTOMERS.cNAME, CUSTOMERS.cPW, CUSTOMERS.cNICKNAME, CUSTOMERS.cEMAIL) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCname());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCnickname());
			pstmt.setString(4, dto.getCemail());
			int r = pstmt.executeUpdate();
			if(r > 0) {	//���� ����
				JOptionPane.showMessageDialog(null, "�l�l¹���� ȸ������ �ƴ� ���غ��� �ڵ��ϴ� �� �λ� ������ �Ф�");
			}
		} catch(MySQLIntegrityConstraintViolationException e3) {
			JOptionPane.showMessageDialog(null, "ERROR : ȸ�����Կ� �����߽��ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR : ȸ�����Կ� �����߽��ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
			
		} catch(Exception e1){
			e1.printStackTrace();
			
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
			
			//�ʱ�ȭ������ ���ư��� ��ɾ�.
		}
		
		return;
	}
	//���Թ� ������ �߻��ϸ� �� �޼ҵ带 ȣ���ؼ� cID�Ӽ� ������ ������ �ʿ䰡 �ִ�.
	public void Renewal_cID() {
		String sql1 = "SET @CNT = 0";
		String sql2 = "UPDATE CUSTOMERS SET CUSTOMERS.cID = @CNT:=@CNT+1";
		int r;
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			r = stmt.executeUpdate(sql1);
			
			stmt = conn.createStatement();
			r = stmt.executeUpdate(sql2);
			
		} catch(SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
		}
	}
	public boolean Idselect(String id) {//id �ߺ�üũ �޼ҵ�
		boolean ok = false;
		try {
			conn = getConnection();
			String sql = "SELECT cNAME FROM CUSTOMERS WHERE cNAME= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				ok = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
		}
		
		return ok;
	}
	public boolean Nickselect(String Nick) {//�г��� �ߺ�üũ �޼ҵ�
		boolean ok = false;
		try {
			conn = getConnection();
			String sql = "SELECT cNICKNAME FROM CUSTOMERS WHERE cNICKNAME= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Nick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ok = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
		}
		return ok;
	}
	
	public boolean Emailselect(String email) {//email �ߺ�üũ �޼ҵ�
		boolean ok = false;
		try {
			conn = getConnection();
			String sql = "SELECT cEMAIL FROM CUSTOMERS WHERE cEMAIL= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ok = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
		}
		return ok;
	}
	
	public boolean Try_Login(String id, String pw, int f) {
		boolean RET = false;
		String sql  = "SELECT cNAME, cPW, cMODE FROM CUSTOMERS WHERE cNAME = ?";
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { //Ʃ���� ���� -> ���̵� ��ȸ ����!
				if((rs.getString(2).equals(pw))&&(rs.getInt(3) == f)) { //��й�ȣ�� ��� ������ ��ġ�ϴٸ�...
					RET = true;
				}
				else if(!(rs.getString(2).equals(pw))) {	//��й�ȣ�� �ٸ��ٸ�...
					JOptionPane.showMessageDialog(null, "ERROR", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", JOptionPane.ERROR_MESSAGE);
					RET = false;
				}
				else if(rs.getInt(3) != f) {	//��й�ȣ�� �´µ� ��� ������ �ٸ��ٸ�...
					JOptionPane.showMessageDialog(null, "ACESS DENIED", "�߸��� �����Դϴ�.", JOptionPane.ERROR_MESSAGE);
					RET = false;
				}
				else {}
			}
			else { //Ʃ���� ���� -> ���� �޽��� ���(���� ���̵� �Դϴ�...)
				JOptionPane.showMessageDialog(null, "ERROR", "���� ���̵� �Դϴ�.", JOptionPane.ERROR_MESSAGE);
				RET = false;
			}
		} catch(SQLException e1) {
			JOptionPane.showMessageDialog(null, "SQLException", "SQLException()�� �߻��Ǿ����ϴ�.", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Customers_DAO.closeJDBC(conn, pstmt, stmt, rs);
		}
		
		return RET;
	}
	
	//public void ...
}
