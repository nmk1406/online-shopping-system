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

import dao.ProductDao;
import dto.Cart;
import dto.Item;
import dto.Product;

@WebServlet("/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts();

		Cookie[] cookies = request.getCookies();
		String txt = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart")) {
					txt += cookie.getValue();
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		Cart cart = new Cart(txt, products);
		List<Item> items = cart.getItems();

		/*
		 * neu sl san pham trong gio hang lon hon sl san pham trong db
		 * se gan sl san pham trong gio hang thanh so luong san pham trong db
		 * cap nhat lai txt cho cookie
		 */
		String out= "";
		if (items.size() > 0) {
			for (Item item : items) {
				if (item.getQuantity() < item.getProduct().getQuantity()) {
					item.setQuantity(item.getQuantity());
				} else {
					item.setQuantity(item.getProduct().getQuantity());
				}
				out += item.getProduct().getId() + ":" + item.getQuantity() + "/";
			}
		}
		
		if (!out.isEmpty()) {
			Cookie cookie = new Cookie("cart", out);
			cookie.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie);
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}