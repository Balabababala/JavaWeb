package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;


@WebServlet("/user")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/user_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//接收表單資料
		//編碼
		req.setCharacterEncoding("UTF-8");
		//接收參數
		String name=req.getParameter("userName");
		String gender=req.getParameter("gender");
		String age=req.getParameter("age");
		String height=req.getParameter("height");
		String weight=req.getParameter("weight");
		//將資料參數丟到model
		User user =new User(name,gender,age,height,weight);
		
		resp.getWriter().print(user.toString());
		RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/user_result.jsp");
		req.setAttribute("user", user);
		rd.forward(req, resp);
		
		
	}
	
	
	
}
