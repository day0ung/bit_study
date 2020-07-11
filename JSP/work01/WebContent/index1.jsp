<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 시간을 얻어올때 java에서 얻어오기 -->
<%
Date nowtime = new Date();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>시간출력</p>
<p>
	현재시간은 <%=nowtime %>입니다
</p>
<br>
<input type="text" value="<%=nowtime %>">

</body>
</html>