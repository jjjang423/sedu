<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보</h1>
<hr>
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("memberreq");
	if(dto != null){
%>
		<ul>
			<li>회원 이름 : <%=dto.getUserName()%></li>
			<li>회원 계정 : <%=dto.getId()%></li>
			<li>회원 암호 : <%=dto.getPassWord()%></li>
			<li>회원 전화번호 : <%=dto.getUserNumber()%></li>
		</ul>
<% 
	} else {
%>
		없음
<%
	}
%>
<hr>
<ul>
			<li>회원 이름 : ${memberreq.userName}</li>
			<li>회원 계정 : ${memberreq.id}</li>
			<li>회원 암호 : ${memberreq.passWord}</li>
			<li>회원 전화번호 : ${memberreq.userNumber}</li>
		</ul>
</body>
</html>