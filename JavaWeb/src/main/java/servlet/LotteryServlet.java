package servlet;
import java.io.IOException;
import java.util.*;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/lottery"})
public class LotteryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random=new Random();					 //放隨機數物件
		Set<Integer> lottery =new LinkedHashSet<>(); //放lottery容器
		while(lottery.size()<5) {
			int number =random.nextInt(39)+1;
			lottery.add(number);
		}
		

//		resp.getWriter().print("開獎\n");
//		resp.getWriter().print(lottery);
		
		
		
		//生成調度器
		RequestDispatcher rd =req.getRequestDispatcher("/lottery2.jsp");

	    // 導向 JSP 顯示畫面
		req.setAttribute("lottery", lottery);
	    rd.forward(req, resp);		
	}

	
	

}
