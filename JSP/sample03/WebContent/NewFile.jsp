<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//한글안깨지게
request.setCharacterEncoding("utf-8");
%>    
<!-- 데이터 받아주기 scriptlet [< % ] 사용하는이유 server로 접근하기 위함-->
<%
String age = request.getParameter("age");
String addr = request.getParameter("addr");
String command = request.getParameter("command");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>age:<%=age %></p>
<p>address:<%=addr %></p>
<p>command:<%=command %></p>
</body>
</html>