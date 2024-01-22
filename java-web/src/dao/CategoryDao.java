package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Category;
import utils.DBUtils;

public class CategoryDao {
	
	// ham lay tat ca category
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		String sql = "select * from categories";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				
				categories.add(category);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return categories;
	}
	
	// ham lay category theo id
	public Category getCategoryById(int id) {
		String sql = "select * from categories where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				
				return category;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	// ham insert category
	public void insertCategory(Category category) {
		String sql = "insert into categories (name) values (?)";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	// ham update category theo id
	public void updateCategory(Category category) {
		String sql = "update categories set name = ? where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	/*
	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDao();
		
		// test ham lay tat ca category
		List<Category> categories = categoryDao.getAllCategories();
		System.out.println(categories);
		
		// test ham lay category theo id
		Category category = categoryDao.getCategoryById(1);
		System.out.println(category);
		
		// test ham insert category
		Category category = new Category();
		category.setName("aaa");
		categoryDao.insertCategory(category);
		
		// test ham update category theo id
		Category category = new Category();
		category.setId(4);
		category.setName("bbb");
		categoryDao.updateCategory(category);
	}
	*/	
}