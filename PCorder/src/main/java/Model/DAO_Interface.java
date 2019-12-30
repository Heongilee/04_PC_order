package Model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public interface DAO_Interface {
	static final String url = "jdbc:mysql://localhost:3306/mytest_db";
	static final String user = "root";
	static final String pw = "1111";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException;
	public Object getInstance();
	//Add Constructor
}
