package controller;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.TodoDTO;
import service.TodoListServiceImpl;

@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet{
	TodoListServiceImpl service=new TodoListServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo= req.getPathInfo();
		switch (pathInfo) {
		case "/": 			//首頁
		case "/*":
			List<TodoDTO> todos=service.findAllTodo();
	
			RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/view/todolist.jsp");
			req.setAttribute("todos", todos);
			rd.forward(req, resp);
			return;
		case "/update":		//更新
			String id=req.getParameter("id");
			String completed=req.getParameter("checked");
			String text=req.getParameter("text");
			
			if(completed!=null) {
				//修 Todo completed 狀態
				service.updateToComplete(Integer.parseInt(id), Boolean.getBoolean(completed));
			}else if(text!=null) {
				//修 Todo text 內容
				service.updateToText(Integer.parseInt(id), text);
			}

			break;
		case "/delete":		//刪除
			
			break;
		default:
			resp.getWriter().print("path error");
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo= req.getPathInfo();
		if (!pathInfo.equals("/add")) {
			return;
		}
		String text=req.getParameter("text");
		Boolean completed=false;
		service.addTodo(text, completed);
		//重跑首頁
		resp.sendRedirect("/JavaWebTodoList/todolist");
	}
}
