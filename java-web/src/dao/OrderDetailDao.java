package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Order;
import dto.OrderDetail;
import dto.Product;
import utils.DBUtils;

public class OrderDetailDao {
	
	// ham lay orderDetail theo orderId
	public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
		List<OrderDetail> orderDetails = new ArrayList<>();
		String sql = "select * from order_details where order_id = ?";
		
		try (Connection connection = new DBUtils().getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				
				OrderDao orderDao = new OrderDao();
				Order order = orderDao.getOrderById(rs.getInt("order_id"));
				orderDetail.setOrder(order);
				
				ProductDao productDao = new ProductDao();
				Product product = productDao.getProductById(rs.getInt("product_id"));
				orderDetail.setProduct(product);
				
				orderDetail.setQuantity(rs.getInt("quantity"));
				orderDetail.setPrice(rs.getDouble("price"));
				
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return orderDetails;
	}
	
	/*
	public static void main(String[] args) {
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		
		// test ham lay orderDetail theo orderId
		List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailByOrderId(4);
		System.out.println(orderDetails);
	}
	*/
}