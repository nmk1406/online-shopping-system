package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Category;
import dto.Product;

public class ProductDao extends DBContext {

	// ham nay de lay tat ca product
	public List<Product> getAllProducts() {
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
//		List<Product> products = productDao.getAllProducts();
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

	public List<Product> getProductsByPage(List<Product> products, int start, int end) {
		ArrayList<Product> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(products.get(i));
		}
		return arr;
	}
	
	public List<Product> search(String txt) {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products where status = 1 ";
		
		if (txt != null && !txt.equals("")) {
			sql += "and name like '%" + txt + "%'"; 
		}
		
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

//	public static void main(String[] args) {
//		ProductDao productDao = new ProductDao();
//		List<Product> products = productDao.search("ao nam");
//		System.out.println(products);
//	}
	
	public List<Product> getProductByCategoryId(int categoryId) {
		List<Product> products = new ArrayList<>();
		String sql = "select * from products where status = 1 ";
		
		if (categoryId != 0) {
			sql += "and category_id = " + categoryId; 
		}
		
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
	
//	public static void main(String[] args) {
//		ProductDao productDao = new ProductDao();
//		List<Product> products = productDao.getProductByCategoryId(1);
//		System.out.println(products);
//	}
}