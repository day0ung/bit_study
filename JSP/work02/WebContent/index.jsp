<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
//선언부
int i = 0;
%>

<%
int j = 0;
%>

<%
i++;
j++;
%>

i=<%=i %><br>
j=<%=j %><br>
</body>
</html>