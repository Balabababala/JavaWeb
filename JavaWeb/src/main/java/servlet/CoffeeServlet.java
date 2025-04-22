package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import model.coffee.Coffee2;

@WebServlet("/coffee")
public class CoffeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/coffee_form.jsp");
		rd.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String milk   =req.getParameter("milk");
		String coffee =req.getParameter("coffee");
		
		Coffee2 userCoffee=new Coffee2(milk,coffee);
		
		req.setAttribute("coffee", userCoffee);
		
	
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/coffee_result.jsp");
		rd.forward(req, resp);
	}

}
