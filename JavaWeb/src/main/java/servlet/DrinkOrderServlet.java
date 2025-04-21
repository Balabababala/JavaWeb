package servlet;

import java.io.IOException;

import model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/drink")
public class DrinkOrderServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		if(req.getParameter("type")==null||req.getParameter("size").toUpperCase()==null||req.getParameter("ice").toLowerCase()==null) {
			resp.getWriter().print("你媽");
			return;	
		}
		
		String type=req.getParameter("type");
		String size=req.getParameter("size").toUpperCase();
		String ice=req.getParameter("ice").toLowerCase();
		
		
		
		DrinkOrder coco= new DrinkOrder(type,size,ice);
		
		RequestDispatcher rd= req.getRequestDispatcher("/drink_order.jsp");
		req.setAttribute("drinkOrder", coco);
		rd.forward(req,resp);
		
	}
}
