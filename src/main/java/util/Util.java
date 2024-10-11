package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagementsystemdb?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";
	
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
			return connection;
		} catch (Exception ex) {
			ex.getMessage();
		}
		return connection;
	}

}

	



