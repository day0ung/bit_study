<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="hello">hello</a>

<%
	//controller에서 view에 데이터보내기
	response.sendRedirect("home.do");
%>

</body>
</html>