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
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.getProductByCategoryId(categoryId);
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.getAllCategories();
		
		// phan trang
		String pageRaw = request.getParameter("page");
		int page;
		if (pageRaw == null) {
			page = 1;
		} else {
			page = Integer.parseInt(pageRaw);
		}
		
		int num;
		int numPerPage = 6;
		int size = list.size();
		
		if (size % numPerPage == 0) {
			num = size / numPerPage;
		} else {
			num = (size / numPerPage) + 1;
		}
		
		int start = (page - 1) * numPerPage;
		int end = Math.min(page * numPerPage, size);
		List<Product> products = productDao.getProductsByPage(list, start, end);
		
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.setAttribute("num", num);
		request.setAttribute("page", page);
		
		String url = request.getServletPath();
		request.setAttribute("url", url);
		request.setAttribute("categoryId", categoryId);
        
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}