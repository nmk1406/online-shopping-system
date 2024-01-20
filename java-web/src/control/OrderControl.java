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

@WebServlet("/order")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			OrderDao orderDao = new OrderDao();
			List<Order> orders = orderDao.getOrder(user);
			request.setAttribute("orders", orders);
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("order.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}