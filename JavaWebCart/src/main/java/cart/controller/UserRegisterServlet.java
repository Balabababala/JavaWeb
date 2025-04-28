package cart.controller;

import java.io.IOException;
import cart.service.*;
import cart.service.Impl.UserRegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet{
	private UserRegisterService userRegisterService=new UserRegisterServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/cart/user_register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email =req.getParameter("email");
		userRegisterService.addUser(username,password,email);
		req.getRequestDispatcher("/WEB-INF/view/cart/login.jsp");
		
	}

	
	
}
