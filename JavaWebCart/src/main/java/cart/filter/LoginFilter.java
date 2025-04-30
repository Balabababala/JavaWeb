package cart.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/list","/product/*"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判斷
		HttpSession session =request.getSession();
		if(session.getAttribute("userDTO")==null) {
//			response.sendRedirect("/JavaWebCart/user/login");
			
			request.setAttribute("resultTitle", "登錄好嗎");
			request.setAttribute("resultMessage", "登錄好嗎");
			request.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(request, response);
		}else {
			//pass
			chain.doFilter(request, response);
		}
	}
	
	
	
}
