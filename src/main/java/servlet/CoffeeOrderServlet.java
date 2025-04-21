package servlet;

import java.io.IOException;
import model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;
import util.*;

@WebServlet("/coffeeOrder")
public class CoffeeOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String type=  req.getParameter("type");
		String size=  req.getParameter("size");
		String sugar= req.getParameter("sugar");
//		Map <String , Integer > coffeePrice =new TreeMap();
//		coffeePrice.put("Latte S",50);
//		coffeePrice.put("Latte M",70);
//		coffeePrice.put("Latte L",90);
//		coffeePrice.put("Mocha S",45);
//		coffeePrice.put("Mocha M",55);
//		coffeePrice.put("Mocha L",65);
//		coffeePrice.put("Americano S",40);
//		coffeePrice.put("Americano M",45);
//		coffeePrice.put("Americano L",60);
//		coffeePrice.put("Cappuccino S",55);
//		coffeePrice.put("Cappuccino M",80);
//		coffeePrice.put("Cappuccino L",100);
//		
//		String input = type+ " "+size;
//		String result="";
//		if(coffeePrice.containsKey(input)) {
//			resp.getWriter().print(String.format("您點了一杯%s杯%s咖啡(%s) 價格:%s" , size,type,(sugar.equals("yes"))?"加糖":"不加糖",coffeePrice.containsKey(input)));
//		}
		if(type==null ||size==null||sugar==null) {
			resp.getWriter().print("你媽");	
			return;
		}
		
		CoffeeOrder coco =new CoffeeOrder(type,size,sugar);
//		resp.getWriter().print(coco.coffeeToString());	
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coco);
		rd.forward(req, resp);
	}

}
