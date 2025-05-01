package cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cart.model.dto.*;
import cart.service.ProductService;
import cart.service.Impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product/order/add/cart")
public class OrderAddCartServlet extends HttpServlet{
	private ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String quantity=req.getParameter("quantity");
		List<ProductDTO> cart=null;
		if(session.getAttribute("cart")==null) {
			cart=new ArrayList<>();
		}else {
			cart= (List<ProductDTO>)session.getAttribute("cart");
		}
		
		
		//
		//取 要買的商品
		Integer productId=Integer.parseInt(req.getParameter("productId"));
		//
		Optional<ProductDTO> optProductDTO=productService.findAllProducts()
															.stream()
															.filter(dto->dto.getProductId().equals(productId))
															.findFirst();
		
		if(optProductDTO.isPresent()) {
			optProductDTO.get().setQty(Integer.parseInt(quantity));
			cart.add(optProductDTO.get());	
			session.setAttribute("cart", cart);
		}
		//System.out.println(session.getAttribute("cart"));
		resp.sendRedirect("/JavaWebCart/product/order");
	}
	
}
