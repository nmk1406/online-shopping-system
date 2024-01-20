package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;
import dto.OrderDetail;

@WebServlet("/order-detail")
public class OrderDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailByOrderId(orderId);
		
		request.setAttribute("orderDetails", orderDetails);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("order-detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}