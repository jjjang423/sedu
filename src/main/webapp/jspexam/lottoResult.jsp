<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	String imginfo = (String) request.getAttribute("imginfo");
	%>
	<h2><%=msg%></h2>
	<%
	if (imginfo != null && !imginfo.isEmpty()) {
	%>
		<img src="<%=imginfo%>" alt="결과 이미지">
	<%
	}
	%>
	<br>
	<br>
	<%
	if (msg != null && msg.contains("실패")) {
	%>
		<a href="/sedu/clientexam/lottoForm3.html">다시 도전하기</a>
	<%
	}
	%>
</body>
</html>