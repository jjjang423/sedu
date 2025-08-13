package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String n1 = request.getParameter("num1");
		String n2 = request.getParameter("num2");
		String operator = request.getParameter("calculator");
		int calNum1 = Integer.parseInt(n1);
		int calNum2 = Integer.parseInt(n2);
		int result = 0;
		
		switch(operator) {
			case "+":
				result = calNum1+ calNum2;
				break;
			case "-":
				result = calNum1 - calNum2;
				break;
			case "*":
				result = calNum1 * calNum2;
				break;
			case "/":
				result = calNum1 / calNum2;
		}
		out.print("<h1>"+"GET 방식으로 요청한 사칙 연산"+"</h1>");
		out.print("<hr>");
		out.print("<h2>"+"결과: " + result + "</h2>");
		out.print("<a href='" + request.getContextPath() + "/clientexam/calcForm.html'>입력화면으로</a>");
		out.close();
	}

}
