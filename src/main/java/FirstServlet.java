

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/first1","/first2"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF8"); //이 서블릿의 응답은 html이다 라는걸 의미, 이걸 안주면 한글이 깨진다
		PrintWriter out  = response.getWriter();
		String name = request.getParameter("myname");
		out.println("<H1>현재 시간 : "+ new java.util.Date() + "</H1>");
		out.println("<H2>반가워요 "+ name + "님!! </H2>");
		System.out.println("서블릿에서 표준출력해요~");
		out.close();
	}

}
