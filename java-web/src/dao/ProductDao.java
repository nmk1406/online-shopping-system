package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Category;
import dto.Product;
import utils.DBUtils;

public class ProductDao {

	// ham lay tat ca product
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products where status = 1";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
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

	// ham lay product theo id
	public Product getProductById(int id) {
		String sql = "select * from products where status = 1 and id = ?";

		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
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
	
	// ham lay product theo category_id
	public List<Product> getProductByCategoryId(int categoryId) {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products where status = 1 and category_id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
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

	// ham phan trang
	public List<Product> getProductsByPage(List<Product> products, int start, int end) {
		List<Product> list = new ArrayList<>();
		for (int i = start; i < end; i++) {
			list.add(products.get(i));
		}
		return list;
	}
	
	// ham search theo name
	public List<Product> search(String txt) {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products where status = 1 ";
		
		if (txt != null && !txt.equals("")) {
			sql += "and name like '%" + txt + "%'"; 
		}
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
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

	/*
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		
		// test ham lay tat ca product
		List<Product> products = productDao.getAllProducts();
		System.out.println(products);
		
		// test ham lay product theo id
		Product product = productDao.getProductById(4);
		System.out.println(product);
		
		// test search theo name
		List<Product> products = productDao.search("ao nam");
		System.out.println(products);
		
		// test ham lay product theo category_id
		List<Product> products = productDao.getProductByCategoryId(1);
		System.out.println(products);
	}
	*/
}