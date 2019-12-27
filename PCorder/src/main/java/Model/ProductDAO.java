package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
	private static String url = "jdbc:mysql://localhost:3306/mytest_db";
	private static String user = "root";
	private static String pw = "zzll230";
	
	public ProductDTO getProduct(Integer id) {
		ProductDTO p = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. DBMS�� �°� ����̹��� �ε�. (cj.jdbc���� ����)
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.DriverManager�� Connection�� ����
			conn = DriverManager.getConnection(url, user, pw);
			
			//3. ������ ����
			String sql = "SELECT * FROM users where id = ?";
			
			//4. DB�� sql ���� �����ϱ� ���� ��ü ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			//5. ���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int ID = rs.getInt(1);
				String USERNAME = rs.getString(2);
				String DEPT = rs.getString(3);
				String BIRTH = rs.getString(4);
				String EMAIL = rs.getString(5);
				
				p = new ProductDTO(ID, USERNAME, DEPT, BIRTH, EMAIL);
			}
			
			System.out.println("�ش� ��ü�� �����Խ��ϴ�.");
			System.out.println(p.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return p;
	}
}
