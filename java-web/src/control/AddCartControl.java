package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dto.Cart;
import dto.Item;
import dto.Product;

@WebServlet("/add-cart")
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProducts(true);
		
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
		
		String quantity = request.getParameter("quantity");
		String id = request.getParameter("id");
		
		txt += id + ":" + quantity + "/";
		
		Cookie cookie = new Cookie("cart", txt);
		cookie.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(cookie);
		
		Cart cart = new Cart(txt, products);
		List<Item> items = cart.getItems();
		
		int size = 0;
		if (items != null) {
			size = items.size();
		}
		HttpSession session = request.getSession();
		session.setAttribute("size", size);
		
		response.sendRedirect("product?id=" + id);
	}
}