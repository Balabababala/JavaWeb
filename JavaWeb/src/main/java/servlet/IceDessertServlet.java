package servlet;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import model.ice.IceOrder;

//冰果店
@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet{
	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String mainDish=req.getParameter("mainDish");
		String[] toppings=req.getParameterValues("toppings");

		IceOrder iceOrder=new IceOrder(mainDish,toppings);
		iceOrders.add(iceOrder);

		req.setAttribute("iceOrders", iceOrders);

		RequestDispatcher rd =req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		rd.forward(req, resp);
		
		
	}

	
}
