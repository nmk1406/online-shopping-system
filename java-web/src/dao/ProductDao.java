package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Category;
import dto.Product;

public class ProductDao extends DBContext{
	
	// ham nay de lay tat ca product
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				product.setStatus(rs.getInt("status"));
				
				CategoryDao categoryDao = new CategoryDao();
				Category category = categoryDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return products;
	}
	
	// test chuc nang cho ham lay tat ca product
//	public static void main(String[] args) {
//		ProductDao productDao = new ProductDao();
//		List<Product> products = productDao.getAllProduct();
//		System.out.println(products);
//	}
	
	// ham nay de lay product theo id
	public Product getProductById(int id) {
		String sql = "select * from products where id = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				product.setImage(rs.getString("image"));
				product.setStatus(rs.getInt("status"));
				
				CategoryDao categoryDao = new CategoryDao();
				Category category = categoryDao.getCategoryById(rs.getInt("category_id"));
				product.setCategory(category);
				
				return product;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	// test chuc nang cho ham lay product theo id
//	public static void main(String[] args) {
//		ProductDao productDao = new ProductDao();
//		Product products = productDao.getProductById(13);
//		System.out.println(products);
//	}
}