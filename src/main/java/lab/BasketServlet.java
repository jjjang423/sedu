package lab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String pid = request.getParameter("pid");
		String redirectPath = "/jspexam/basketResult.jsp";

		if ("clear".equals(action)) {
			session.removeAttribute("basket");
		}
		else if (pid != null) {
			@SuppressWarnings("unchecked")
			Map<String, Integer> basket = (Map<String, Integer>) session.getAttribute("basket");
			if (basket == null) {
				basket = new HashMap<>();
				session.setAttribute("basket", basket);
			}

			basket.put(pid, basket.getOrDefault(pid, 0) + 1);
		}

		response.sendRedirect(request.getContextPath() + redirectPath);
	}
}
