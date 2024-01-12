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

@WebServlet("/shop")
public class ShopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.getAllProducts();
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> categories = categoryDao.getAllCategories();
		
		int page, numerpage = 6;
		int num = (list.size() == 0 ? (list.size()/numerpage) : ((list.size()/numerpage) + 1));
		String xpage = request.getParameter("page");
		if (xpage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(xpage);
		}
		int start = (page - 1) * numerpage;
		int end = Math.min(page * numerpage, list.size());
		List<Product> products = productDao.getProductsByPage(list, start, end);
		
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.setAttribute("num", num);
		request.setAttribute("page", page);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}