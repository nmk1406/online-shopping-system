package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

public class RoleFilter implements Filter {

	public RoleFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		
		if (session.getAttribute("user") == null) {
			resp.sendRedirect("login");
		} else {
			User user = (User)session.getAttribute("user");
			if (user.getRoleId() == 1) {
				chain.doFilter(req, resp);
			} else {
				resp.sendRedirect("shop");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}