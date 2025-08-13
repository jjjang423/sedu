package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (request.getParameter("name") == null || request.getParameter("name").trim().isEmpty()) ? "없음" : request.getParameter("name");	
		String userNumber = (request.getParameter("number") == null || request.getParameter("name").trim().isEmpty()) ? "없음" : request.getParameter("number");
		String userId = (request.getParameter("ID") == null || request.getParameter("name").trim().isEmpty()) ? "없음" : request.getParameter("ID");
		String userPassword = (request.getParameter("password") == null || request.getParameter("name").trim().isEmpty()) ? "없음" : request.getParameter("password");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserName(userName);
		dto.setUserNumber(userNumber);
		dto.setId(userId);
		dto.setPassWord(userPassword);
		
		request.setAttribute("memberreq", dto);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
		
	}
}
