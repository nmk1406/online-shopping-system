package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		if (txt.isEmpty()) {
			txt = id + ":" + quantity;
		} else {
			txt += "/" + id + ":" + quantity;
		}
		
		Cookie cookie = new Cookie("cart", txt);
		cookie.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(cookie);
		
		response.sendRedirect("product-detail?id=" + id);
	}
}