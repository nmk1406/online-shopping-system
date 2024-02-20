package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Order;
import dto.User;

@WebServlet("/order-management")
public class OrderManagementControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("order-management.jsp");
			rd.forward(request, response);
		} else {
			OrderDao orderDao = new OrderDao();
			List<Order> list;
			
			if (user.getRoleId() == 1) {
				list = orderDao.getAllOrders();
			} else {
				list = orderDao.getOrderByUserId(user.getId());
			}
			
			String pageRaw = request.getParameter("page");
			int page;
			if (pageRaw == null) {
				page = 1;
			} else {
				page = Integer.parseInt(pageRaw);
			}
			
			int num;
			int numPerPage = 5;
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
			rd = request.getRequestDispatcher("order-management.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}