<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>
    <%
    request.setCharacterEncoding("UTF-8");

    String userName = request.getParameter("name");
    String userRoom = request.getParameter("room");
    String[] foods = request.getParameterValues("food");
    String reservDate = request.getParameter("reservDate");

    LocalDate date = LocalDate.parse(reservDate);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    String formattedDate = date.format(formatter);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 결과</title>
</head>
<body>
    <h1 style="color: blue;"><%= userName %>님의 예약 내용</h1>
    <hr>
    <ul>
        <li>선택한 룸 : <%= userRoom %></li>
        <li>
            추가 요청사항 : 
            <%
                if (foods != null) {
                    for (int i = 0; i < foods.length; i++) {
                        out.print(foods[i]);
                        if (i < foods.length - 1) out.print(", ");
                    }
                } else {
                    out.print("없음");
                }
            %>
        </li>
        <li>예약 날짜 : <%= formattedDate %></li>
    </ul>
</body>
</html>