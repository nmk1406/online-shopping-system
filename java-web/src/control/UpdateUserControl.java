package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/update-user")
public class UpdateUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(id);
		request.setAttribute("user", user);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("edit-user.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(id);
		user.setStatus(status);
		user.setRoleId(roleId);
		
		userDao.updateUser(user);
		
		response.sendRedirect("user-management");
	}
}