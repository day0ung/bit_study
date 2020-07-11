<%@page import="sample03.DtoClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = request.getAttribute("dto");
	DtoClass dto = (DtoClass)obj;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Newfile3.jsp</h3>

address:<input type="text" value="<%=dto.getAddr()%>">
<br>
age:<p><%=dto.getAge() %></p>
</body>
</html>