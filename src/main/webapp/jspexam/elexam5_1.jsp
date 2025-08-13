<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>저장된 객체 추출(5_1)</h2>
<hr>
pageScope 객체에서 추출 : ${ pageScope.msg }<br>
requestScope 객체에서 추출 : ${ requestScope.msg }<br>
sessionScope 객체에서 추출 : ${ sessionScope.msg }<br>
applicationScope 객체에서 추출 : ${ applicationScope.msg }<br>
<hr>
msg 추출 : ${msg}<br>
</body>
</html>



