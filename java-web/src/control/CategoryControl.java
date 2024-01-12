package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import dto.Category;
import dto.Product;

@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRaw = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idRaw);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getProductByCategoryId(id);
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.getAllCategories();

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}