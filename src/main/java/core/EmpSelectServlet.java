package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empselect")
public class EmpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			response.sendError(500, "ㅠㅠ JDBC 드라이버 오류");
			return;
		}
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//		String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
		String user = "SCOTT";
		String passwd = "TIGER";
		out.print("<h2>지원명단</h2><hr><ul>");
		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select ename, sal  from emp");){			
			while (rs.next()) {
				out.printf("<li>%10s(%d)</li>", rs.getString("ename"), rs.getInt("sal"));
			}
			out.print("</ul>");
		} catch(SQLException e) {
			response.sendError(500, "DB 연동 오류");
			return;	
		}		
	}
}
