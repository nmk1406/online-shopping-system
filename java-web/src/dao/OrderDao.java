package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.Cart;
import dto.Item;
import dto.Order;
import dto.User;
import utils.DBUtils;

public class OrderDao {
	
	// ham insert order
	public void insertOrder(User user, Cart cart, Order order) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		
		String sql1 = "insert into orders (order_date, total_money, fullname, address, email, phone, user_id) values (?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "select id from orders order by id desc limit 1";
		String sql3 = "insert into order_details (order_id, product_id, quantity, price) values (?, ?, ?, ?)";
		String sql4 = "update products set quantity = quantity - ? where id = ?";
		String sql5 = "select id from products where quantity = 0";
		String sql6 = "update products set status = 0 where id = ?";
		
		try (Connection connection = new DBUtils().getConnection()) {
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			ps1.setString(1, date);
			ps1.setDouble(2, cart.getTotalMoney());
			ps1.setString(3, order.getFullname());
			ps1.setString(4, order.getAddress());
			ps1.setString(5, order.getEmail());
			ps1.setString(6, order.getPhone());
			ps1.setInt(7, user.getId());
			ps1.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				for (Item item : cart.getItems()) {
					PreparedStatement ps3 = connection.prepareStatement(sql3);
					ps3.setInt(1, rs2.getInt("id"));
					ps3.setInt(2, item.getProduct().getId());
					ps3.setInt(3, item.getQuantity());
					ps3.setDouble(4, item.getPrice());
					ps3.executeUpdate();
				}
			}
			
			PreparedStatement ps4 = connection.prepareStatement(sql4);
			for (Item item : cart.getItems()) {
				ps4.setInt(1, item.getQuantity());
				ps4.setInt(2, item.getProduct().getId());
				ps4.executeUpdate();
			}
			
			PreparedStatement ps5 = connection.prepareStatement(sql5);
			ResultSet rs5 = ps5.executeQuery();
			while (rs5.next()) {
				PreparedStatement ps6 = connection.prepareStatement(sql6);
				ps6.setInt(1, rs5.getInt("id"));
				ps6.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	// ham lay order theo userId
	public List<Order> getOrderByUserId(int userId) {
		List<Order> orders = new ArrayList<>();
		String sql = "select * from orders where user_id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setTotalMoney(rs.getDouble("total_money"));
				order.setFullname(rs.getString("fullname"));
				order.setAddress(rs.getString("address"));
				order.setEmail(rs.getString("email"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getInt("status"));
				order.setUserId(rs.getInt("user_id"));
				
				orders.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orders;
	}
	
	// ham lay order theo id
	public Order getOrderById(int id) {
		String sql = "select * from orders where id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setTotalMoney(rs.getDouble("total_money"));
				order.setFullname(rs.getString("fullname"));
				order.setAddress(rs.getString("address"));
				order.setEmail(rs.getString("email"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getInt("status"));
				order.setUserId(rs.getInt("user_id"));
				
				return order;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/*
	public static void main(String[] args) {
		OrderDao orderDao = new OrderDao();
		
//		// test ham lay order theo id
//		Order order = orderDao.getOrderById(4);
//		System.out.println(order);
//		
//		// test ham lay order theo userId
//		List<Order> orders = orderDao.getOrderByUserId(3);
//		System.out.println(orders);
		
		// test ham them du lieu bang order
		UserDao userDao = new UserDao();
		User user = userDao.validate("c@gmail.com", "c");
		
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts();
		
		String txt = "5:2/6:3/"; // 2 product voi id=5, 3 product voi id=6
		Cart cart = new Cart(txt, products);
		
		Order order = new Order();
		order.setFullname("k");
		order.setAddress("hcm");
		order.setEmail("k@gmail.com");
		order.setPhone("012345678");
		
		orderDao.insertOrder(user, cart, order);
	}
	*/
}