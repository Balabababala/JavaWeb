package cart.controller;



import java.io.IOException;
import cart.service.*;
import cart.service.Impl.UserRegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//要接收使用者於信件中所按下的確認連結
//http://localhost:8080/JavaWebCart/email/confirm?username=John
//http://localhost:8080/JavaWebCart/email/confirm?username=Mary
@WebServlet("/email/confirm")
public class EmailConfirmServlet extends HttpServlet{
	private UserRegisterService userRegisterService=new UserRegisterServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		userRegisterService.emailConfirmOK(username);
		
		String resultTitle = "Email驗證結果";
		String resultMessage = "用戶名稱: " + username + "<p />Email驗證成功";
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		
		
		// 重導到 result.jsp
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
		
	}
	
}
