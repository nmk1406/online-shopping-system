package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.Cart;
import dto.Item;
import dto.Order;
import dto.User;
import utils.DBUtils;

public class OrderDao {
	public void addOrder(User user, Cart cart, Order order) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();
		
		String sql1 = "insert into orders (order_date, total_money, fullname, address, email, phone, status, user_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
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
			ps1.setInt(7, order.getStatus());
			ps1.setInt(8, user.getId());
			ps1.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ResultSet rs = ps2.executeQuery();
			
			if (rs.next()) {
				int orderId = rs.getInt("id");
				for (Item item : cart.getItems()) {
					PreparedStatement ps3 = connection.prepareStatement(sql3);
					ps3.setInt(1, orderId);
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
			ResultSet rs2 = ps5.executeQuery();
			while (rs2.next()) {
				PreparedStatement ps6 = connection.prepareStatement(sql6);
				ps6.setInt(1, rs2.getInt("id"));
				ps6.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}