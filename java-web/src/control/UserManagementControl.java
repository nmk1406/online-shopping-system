package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/user-management")
public class UserManagementControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		List<User> list = userDao.getAllUsers();
		
		// phan trang
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
		List<User> users = userDao.getUsersByPage(list, start, end);
		
		request.setAttribute("users", users);
		request.setAttribute("num", num);
		request.setAttribute("page", page);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("user-management.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}