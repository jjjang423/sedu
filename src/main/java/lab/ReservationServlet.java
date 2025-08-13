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

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("name");
		String userRoom = request.getParameter("room");
		String[] foods = request.getParameterValues("food");
		String reservDate = request.getParameter("reservDate");
		LocalDate date = LocalDate.parse(reservDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String formattedDate = date.format(formatter);

		out.print("<h1 style='color: blue;'>" + userName + "님의 예약 내용" + "</h1>");
		out.print("<hr>");
		out.print("<ul>");
		out.print("<li>" + "선택한 룸 : " + userRoom + "</li>");
		if (foods != null) {
            String foodList = String.join(", ", foods);
            out.print("<li>추가 요청사항 : " + foodList + "</li>");
        } else {
            out.print("<li>추가 요청사항 : 없음</li>");
        }
		
		out.print("<li>예약 날짜 : " + formattedDate + "</li>");
		out.print("</ul>");
	}

}
