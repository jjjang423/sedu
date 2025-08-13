package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberLocalServlet
 */
@WebServlet("/memberlocal") // URL 매핑정보
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int local_v = 0;
		member_v++;
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}

}
