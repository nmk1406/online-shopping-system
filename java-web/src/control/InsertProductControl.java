package control;

import java.io.IOException;

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

@WebServlet("/insert-product")
public class InsertProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("edit-add-product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String quantityRaw = request.getParameter("quantity");
		String priceRaw = request.getParameter("price");
		String description = request.getParameter("description");
		String statusRaw = request.getParameter("status");
		String categoryIdRaw = request.getParameter("categoryId");
		
		int quantity;
		double price;
		int status;
		int categoryId;
		
		try {
			quantity = Integer.parseInt(quantityRaw);
			price = Double.parseDouble(priceRaw);
			status = Integer.parseInt(statusRaw);
			categoryId = Integer.parseInt(categoryIdRaw);
			
			CategoryDao categoryDao = new CategoryDao();
			Category category = categoryDao.getCategoryById(categoryId);
			
			ProductDao productDao = new ProductDao();
			Product product = new Product(name, quantity, price, description, image, status, category);
			productDao.insertProduct(product);
			
			response.sendRedirect("product-management");
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}