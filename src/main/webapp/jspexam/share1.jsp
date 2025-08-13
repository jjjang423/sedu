<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CountDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿이 전달한 객체(request)-스크립팅</h2>
<%
	CountDTO dto = (CountDTO)request.getAttribute("objreq");
	if(dto != null){		
%>
		추출된 값 : <%=dto.getNumber() %><br>
<% 
	} else {
%>
		추출된 객체가 없어
<%
	}
%>
<hr>
<h2>서블릿이 전달한 객체(request)-EL</h2>
추출된 값: ${objreq.number}
</body>
</html>