package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private String jdbcURL = "jdbc:mysql://localhost:3306/script";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1111";
	protected Connection connection;
	
	public DBContext() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}