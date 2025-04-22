package servlet;

import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import model.*;

@WebServlet("/guestbook")
public class GuestBookServlet extends HttpServlet{
	
	private static final List<GuestBook> guestBooks=new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/guestbook_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = req.getParameter("message");
		
		GuestBook guestBook=new GuestBook(message);
		
		guestBooks.add(guestBook);
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/guestbook_result.jsp");
		req.setAttribute("message",message);
		req.setAttribute("guestBooks", guestBooks);
		

		rd.forward(req, resp);
		
	}

	
	
	
}
