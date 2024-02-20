package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// ham lay tat ca user
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "select * from users";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setStatus(rs.getInt("status"));
				user.setRoleId(rs.getInt("role_id"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return users;
	}
	
	// ham lay user theo id
	public User getUserById(int id) {
		String sql = "select * from users where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
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
	
	// ham phan trang
	public List<User> getUsersByPage(List<User> users, int start, int end) {
		List<User> list = new ArrayList<>();
		for (int i = start; i < end; i++) {
			list.add(users.get(i));
		}
		return list;
	}
	
	// ham update user
	public void updateUser(User user) {
		String sql = "update users set status = ?, role_id = ? where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, user.getStatus());
			ps.setInt(2, user.getRoleId());
			ps.setInt(3, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	// ham insert user
	public void insertUser(User user) {
		String sql = "insert into users (email, password, phone) values (?, ?, ?)";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	/*
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		// test ham authentication user
		User user = userDao.validate("c@gmail.com", "c");
		System.out.println(user);
		
		// test ham lay tat ca user
		List<User> users = userDao.getAllUsers();
		System.out.println(users);
		
		// test ham lay user theo id
		User user = userDao.getUserById(1);
		System.out.println(user);
		
		// test ham update user
		User user = userDao.getUserById(4);
		user.setStatus(0);
		user.setRoleId(1);
		userDao.updateUser(user);
	}
	*/
}