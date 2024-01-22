package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dto.Category;

@WebServlet("/update-category")
public class UpdateCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		CategoryDao categoryDao = new CategoryDao();
		Category category = categoryDao.getCategoryById(id);
		request.setAttribute("category", category);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("edit-add-category.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRaw = request.getParameter("id");
		String name = request.getParameter("name");
		int id;
		
		try {
			id = Integer.parseInt(idRaw);
			Category category = new Category(id, name);
			
			CategoryDao categoryDao = new CategoryDao();
			categoryDao.updateCategory(category);
			
			response.sendRedirect("category-management");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}