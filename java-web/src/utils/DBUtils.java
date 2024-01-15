package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private String jdbcURL = "jdbc:mysql://localhost:3306/script";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1111";
	
	public Connection getConnection() {
        Connection connection = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
        return connection;
    }
	
//	public static void main(String[] args) {
//		DBUtils dbUtils = new DBUtils();
//		System.out.println(dbUtils.getConnection());
//	}
}