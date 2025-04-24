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
import service.ProductService;


@WebServlet("/index")
public class IndexServlet extends HttpServlet{
	
	private ProductService productService=new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
		List<ProductDTO> productDTOs= productService.findAll();
		req.setAttribute("productDTOs", productDTOs);
		rd.forward(req, resp);
		
	}
	
}
