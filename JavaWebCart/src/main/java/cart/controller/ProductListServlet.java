package cart.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cart.model.dto.ProductDTO;
import cart.service.*;
import cart.service.Impl.*;
@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
	private ProductService productListService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有商品
		List<ProductDTO> productDTOs= productListService.findAllProducts();
		req.setAttribute("productDTOs", productDTOs);
		req.getRequestDispatcher("/WEB-INF/view/cart/product_list.jsp").forward(req, resp);
		
	}
	
}