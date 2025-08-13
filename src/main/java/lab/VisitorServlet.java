package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		PrintWriter out = response.getWriter();
        String userName = request.getParameter("name");
        String userMemo = request.getParameter("memo");
        
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String dateStr = today.format(formatter);
        
        out.print("<h1>" + userName + "님이 " + dateStr + "에 남긴 글 입니다</h1>");
        out.print("<hr>");
        out.print("<h2>" + userMemo + "</h2>");
        
	}
}

