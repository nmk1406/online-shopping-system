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
	public List<Product> getAllProducts(boolean all) {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products ";
		if (all == true) {
			sql += "where status = 1";
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

	// ham lay product theo id
	public Product getProductById(int id, boolean all) {
		String sql = "select * from products where id = ? ";
		if (all == true) {
			sql += "and status = 1";
		}

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
	
	// update product
	public void updateProduct(Product product) {
		String sql = "update products set name = ?, image = ?, quantity = ?, price = ?, description = ?, status = ?, category_id = ? where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setInt(3, product.getQuantity());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getStatus());
			ps.setInt(7, product.getCategory().getId());
			ps.setInt(8, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	// insert product
	public void insertProduct(Product product) {
		String sql = "insert into products (name, quantity, price, description, image, status, category_id) values (?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, product.getName());
			ps.setInt(2, product.getQuantity());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getImage());
			ps.setInt(6, product.getStatus());
			ps.setInt(7, product.getCategory().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
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
		
		// update product
		CategoryDao categoryDao = new CategoryDao();
		Category category = categoryDao.getCategoryById(1);
		Product product = new Product(1, "bbbbb", 10, 10.0, "aaaaa", "static/images/cloth_2.jpg", 1, category);
		productDao.updateProduct(product);
		
		// insert product
		CategoryDao categoryDao = new CategoryDao();
		Category category = categoryDao.getCategoryById(1);
		Product product = new Product();
		product.setName("bbbb");
		product.setQuantity(10);
		product.setPrice(10.0);
		product.setDescription("aaaa");
		product.setImage("static/images/cloth_2.jpg");
		product.setStatus(1);
		product.setCategory(category);
		productDao.insertProduct(product);
	}
	*/
}