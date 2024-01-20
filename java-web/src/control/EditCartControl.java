package control;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/edit-cart")
public class EditCartControl extends HttpServlet {
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
		
		String idRaw = request.getParameter("id");
		String quantityRaw = request.getParameter("quantity");
		int id, quantity;
		
		try {
			id = Integer.parseInt(idRaw);
			quantity = Integer.parseInt(quantityRaw);
			
			Product product = productDao.getProductById(id);
			int productQuantity = product.getQuantity();
			
			if (quantity == -1 && (cart.getQuantityById(id) <= 1)) {
				quantity = 0;
			} else {
				if (quantity == 1 && (cart.getQuantityById(id) >= productQuantity)) {
					quantity = 0;
				}
				double price = product.getPrice();
				Item item = new Item(product, quantity, price);
				
				cart.addItem(item);
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		List<Item> items = cart.getItems();
		
		String out = "";
		if (items.size() > 0) {
			for (Item item : items) {
				out += item.getProduct().getId() + ":" + item.getQuantity() + "/";
			}
		}
		
		if (!out.isEmpty()) {
			Cookie cookie = new Cookie("cart", out);
			cookie.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie);
		}
		
		response.sendRedirect("cart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}