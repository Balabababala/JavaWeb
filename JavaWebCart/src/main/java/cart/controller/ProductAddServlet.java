package cart.controller;

import java.io.IOException;
import java.util.Base64;

import cart.service.ProductService;
import cart.service.Impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10) //圖片大小上限 10M
public class ProductAddServlet extends HttpServlet{

	private ProductService productService=new ProductServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收表單
		String productName=req.getParameter("productName");
		String price=req.getParameter("price");
		String qty=req.getParameter("qty");
		//接收上傳檔案資料
		Part productImage=req.getPart("productImage");
		//將 Part 物件轉 byte[] 轉字串 存資料表
		byte[] bytes = productImage.getInputStream().readAllBytes();
		String productImageBase64=Base64.getEncoder().encodeToString(bytes);
		
		productService.add(productName, price, qty, productImageBase64);
		
		String message=String.format("商品名稱:%s<br>商品價格:%s<br>商品庫存:%s<br>商品照片:<img src='data:image/png;base64,%s'><br>", 
				productName,price,qty,productImageBase64);
		req.setAttribute("resultTitle", "商品名稱");
		req.setAttribute("resultMessage", message);
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}
	
}
