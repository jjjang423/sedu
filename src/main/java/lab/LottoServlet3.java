package lab;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lotto3")
public class LottoServlet3 extends HttpServlet {
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
			request.setAttribute("msg", "더 이상 응모할 수 없어요… 브라우저를 재기동한 후에는 가능하답니다.");
			request.setAttribute("imginfo", "https://cdn.imweb.me/thumbnail/20191109/07493697eb058.png");
			request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
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
			request.setAttribute("msg", "당첨~~~ 추카추카");
			request.setAttribute("imginfo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX4-L07q7vW55sjlwz1bZqhLUJ7HXuSvwGBA&s");
		} else {
			request.setAttribute("msg", "실패~~~ 아쉽아쉽");
			request.setAttribute("imginfo", "https://cdn.imweb.me/thumbnail/20191109/07493697eb058.png");
		}

		request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
	}

}
