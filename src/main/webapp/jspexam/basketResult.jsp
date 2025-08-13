<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 40px;
	}
.basket-box {
	border: 2px solid #888;
	border-radius: 15px;
	padding: 20px;
	width: 400px;
	
	background: linear-gradient(to left, #dfe9f3, #ffffff);
}
.checkbox{
	text-align: left;
}
</style>
</head>
<body>
	<div class="basket-box">
		<%
		Map<String, Integer> basket = (Map<String, Integer>) session.getAttribute("basket");
		if (basket == null || basket.isEmpty()) {
		%>
		<h3>선택한 상품이 없어요.</h3>
		<a href="<%=request.getContextPath()%>/clientexam/productlog.html">상품선택하기</a>
		<%
		} else {
		%>
		<h3>선택한 상품 리스트</h3>
		<hr>
		<ul>
			<%
			for (Map.Entry<String, Integer> entry : basket.entrySet()) {
			%>
			<li><%=entry.getKey()%> 상품 <%=entry.getValue()%>개</li>
			<%
			}
			%>
		</ul>
		<div class = checkbox>
		<a href="<%=request.getContextPath()%>/basket?action=clear">상품비우기</a><br>
		<a href="<%=request.getContextPath()%>/clientexam/productlog.html">상품선택하기</a>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>