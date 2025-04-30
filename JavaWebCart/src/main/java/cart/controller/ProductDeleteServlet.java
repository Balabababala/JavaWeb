package cart.controller;

import java.io.IOException;

import cart.service.ProductService;
import cart.service.Impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet{
	private ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productID=Integer.parseInt(req.getParameter("productID"));
		productService.delete(productID);
		resp.sendRedirect(req.getContextPath() + "/product/list");
	}
	
	
}
