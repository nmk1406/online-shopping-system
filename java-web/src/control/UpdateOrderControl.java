package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dto.Order;

@WebServlet("/update-order")
public class UpdateOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		OrderDao orderDao = new OrderDao();
		Order order = orderDao.getOrderById(id);
		request.setAttribute("order", order);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("edit-order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));

		OrderDao orderDao = new OrderDao();
		Order order = orderDao.getOrderById(id);
		order.setStatus(status);
		
		orderDao.updateStatus(order);
		
		response.sendRedirect("order");
	}
}