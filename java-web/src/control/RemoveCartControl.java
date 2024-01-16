package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/remove-cart")
public class RemoveCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
		
		String id = request.getParameter("id");
		
		String out = "";
		String[] txt1 = txt.split("/");
		for (String txt2 : txt1) {
			String[] txt3 = txt2.split(":");
			if (!txt3[0].equals(id)) {
				out += txt2 + "/";
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