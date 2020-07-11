<%@page import="sample02.Human"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 데이터 보내주기 -->
response(응답): sendRedirect ->원본이름 HttpServletResponse
<%--
[sendRedirect
//한글 encoding하기
request.setCharacterEncoding("utf-8");
//sendRedirect =URLEncoder가 필요함
String name = "홍길동";
name = URLEncoder.encode(name);
response.sendRedirect("NewFile.jsp?name=" +name);

--%>

<%--
[setAttribute-pageContext]
String name = "일지매";
request.setAttribute("name", name); //짐싸
//servlet에서 forward >>response소속

//pagecontext: 내장객체
pageContext.forward("NewFile.jsp"); //잘가

--%>


<%--
[NewFil1.jsp에 humanClass데이터 넘기기]
int num =1;
String name="성춘향";

Human human = new Human(num,name);
					//"human"과 Human human이 같을 필요없음
request.setAttribute("human", human); //짐싸
pageContext.forward("NewFile1.jsp");

--%>

<!-- sendRedirect, 짐붙일때, session을사용하기  -->
<%
int num = 2;
String name = "정수동";

Human human = new Human(num,name);

session.setAttribute("hman",human );//짐싸
response.sendRedirect("NewFile2.jsp");
//짐안가져가고 그냥감 되게끔하려면 request.setAttribute대신,session.setAttribute 사용하면됨

%>
</body>
</html>