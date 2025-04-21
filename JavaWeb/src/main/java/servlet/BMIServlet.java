package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 接收參數
		// 例如: http://localhost:8080/JavaWeb/bmi?h=170&w=60
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		
		if(!Util.isDouble(height)||(!Util.isDouble(weight))) {
			resp.getWriter().print("有事嗎");
		}else {
			double h=Double.parseDouble(height);
			double w=Double.parseDouble(weight);
			double bmiValue= getBMIvalue(h,w);
			String result = getBMIResult(bmiValue);
			resp.getWriter().print(String.format("BMI值 : %.2f(%s) ", bmiValue ,result));
		}
	}
	private double getBMIvalue(double h,double w) {
		return w/Math.pow(h/100,2);
	}
	private String getBMIResult(double bmiValue) {
		return bmiValue<=18?"過輕":(bmiValue>23? "過重":"正常");
	}
	
}