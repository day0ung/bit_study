<%@page import="sample03.DtoClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String addr = "경기도";
int age = 24;
%>

<%
/* request.setAttribute("addr", addr);
request.setAttribute("age", age);  >>따로따로 보내지말고 dto로 만들어서 보냄*/

request.setAttribute("dto", new DtoClass(addr,age)); //생성하면서 집어넣기
//session.setAttribute("dto", new DtoClass(addr,age)); //session에 집어넣기
//application.setAttribute("dto", new DtoClass(addr,age)); //풀어줄때도application으로해야함

pageContext.forward("NewFile3.jsp"); //forward는 >> request/session.setAttribute만 가능하다
response.sendRedirect("NewFile3.jsp"); //session.setAttribute만 가능

//response.sendRedirect("Newfile3.jsp?addr="+addr+"&age="+age);
%>

</body>
</html>