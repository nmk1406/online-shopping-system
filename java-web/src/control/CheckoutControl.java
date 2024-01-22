package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.ProductDao;
import dto.Cart;
import dto.Order;
import dto.Product;
import dto.User;

@WebServlet("/checkout")
public class CheckoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts(true);

		Cookie[] cookies = request.getCookies();
		String txt = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart")) {
					txt += cookie.getValue();
				}
			}
		}
		
		Cart cart = new Cart(txt, products);

		request.setAttribute("cart", cart);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		Order order = new Order();
		order.setFullname(fullname);
		order.setAddress(address);
		order.setEmail(email);
		order.setPhone(phone);
		
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts(true);
		
		Cookie[] cookies = request.getCookies();
		String txt = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart")) {
					txt += cookie.getValue();
				}
			}
		}
		
		Cart cart = new Cart(txt, products);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			OrderDao orderDao = new OrderDao();
			orderDao.insertOrder(user, cart, order);
			Cookie cookie = new Cookie("cart", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			response.sendRedirect("shop");
		}
	}
}