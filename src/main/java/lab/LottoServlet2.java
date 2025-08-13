package lab;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		Integer tryCount = (Integer) session.getAttribute("tryCount");
		if (tryCount == null)
			tryCount = 0;

		Boolean isWin = (Boolean) session.getAttribute("isWin");
		if (isWin == null)
			isWin = false;

		if (tryCount >= 3 || isWin) {
			request.getRequestDispatcher("/clientexam/impossible.html").forward(request, response);
			return;
		}

		String n1 = request.getParameter("lotto");
		int lottoNum = Integer.parseInt(n1);
		Random rand = new Random();
		int randNum = rand.nextInt(6) + 1;

		System.out.println("전달된값 : " + lottoNum + " 추출된 값 : " + randNum);

		tryCount++;
		session.setAttribute("tryCount", tryCount);

		if (lottoNum == randNum) {
			session.setAttribute("isWin", true);
			request.getRequestDispatcher("/clientexam/success.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/clientexam/fail.html").forward(request, response);
		}
	}
}
