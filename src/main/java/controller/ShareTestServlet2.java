package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CountDTO;

@WebServlet("/sharetest2")
public class ShareTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));	
		HttpSession session = request.getSession();
		if(session.getAttribute("objsession") == null) {
			session.setAttribute("objsession", new CountDTO());
		}
		CountDTO dto = (CountDTO)session.getAttribute("objsession");
		dto.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share2.jsp").
		forward(request, response);
	}
}
