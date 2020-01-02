package Model;

import java.sql.*;

public interface DAO_Interface {
	String driver = "com.mysql.jdbc.Driver"; 
	String url = "jdbc:mysql://localhost:3306/pc_order_db?serverTimezone=Asia/Seoul&useSSL=false";
	String user = "root";
	String pw = "1111";
}
