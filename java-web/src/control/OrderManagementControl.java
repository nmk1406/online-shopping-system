package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dto.Order;

@WebServlet("/OrderManagementControl")
public class OrderManagementControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		List<Order> list = orderDao.getAllOrders();
		
		// phan trang
		String pageRaw = request.getParameter("page");
		int page;
		if (pageRaw == null) {
			page = 1;
		} else {
			page = Integer.parseInt(pageRaw);
		}
		
		int num;
		int numPerPage = 6;
		int size = list.size();
		
		if (size % numPerPage == 0) {
			num = size / numPerPage;
		} else {
			num = (size / numPerPage) + 1;
		}
		
		int start = (page - 1) * numPerPage;
		int end = Math.min(page * numPerPage, size);
		List<Order> orders = orderDao.getOrderByPage(list, start, end);
		
		request.setAttribute("orders", orders);
		request.setAttribute("num", num);
		request.setAttribute("page", page);

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("product-management.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}