package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;
import model.dto.ProductDTO;
import service.OrderService;
import service.ProductService;

@WebServlet("/order/update")
public class OrderUpdateServlet extends HttpServlet {
	
	private OrderService orderService = new OrderService();
	private ProductService productService=new ProductService();
	// 根據 index 呈現修改表單(update.jsp)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		
		// 重導到指定 jsp 並帶上 index
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/update.jsp");
		req.setAttribute("index", index);
		List<ProductDTO> productDTOs= productService.findAll();
		req.setAttribute("productDTOs", productDTOs);
		rd.forward(req, resp);
	}

	// 修改表單
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String index = req.getParameter("index");
		String item = req.getParameter("item");
		String quality = req.getParameter("quality"); 
		OrderDTO orderDTO = orderService.updateOrder(index, item,quality);
		
		// 重導到指定 jsp 並帶上歷史反饋資料(OrderDTO)
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/result.jsp");
		req.setAttribute("orderDTO", orderDTO);
		rd.forward(req, resp);
	}
}
