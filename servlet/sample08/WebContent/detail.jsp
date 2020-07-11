<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//scriptlet
	//Java영역
	
	//servlet에서 받은 짐풀기 (object로)
	Member mem = (Member)request.getAttribute("member");
	System.out.println(mem.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail.jsp</title>
</head>
<body>

<h3>Detail.jsp</h3>

이름:<p><%=mem.getName() %></p>

나이:<input type="text" value="<%=mem.getAge() %>">


</body>
</html>