package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.validate(email, password);
		if (user == null) {
			request.setAttribute("error", "password error");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("shop");
		}
	}
}