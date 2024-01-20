package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import utils.DBUtils;

public class UserDao {
	
	// ham authentication user 
	public User validate(String email, String password) {
		String sql = "select * from users where email = ? and password = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setStatus(rs.getInt("status"));
				user.setRoleId(rs.getInt("role_id"));
				
				return user;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/*
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = userDao.validate("c@gmail.com", "c");
		System.out.println(user);
	}
	*/
}