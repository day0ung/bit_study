<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- index.jsp데이터 받기 -->
 <%
 //String name = request.getParameter("name");
 
 //pageContext 짐풀기
 String name = (String)request.getAttribute("name");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 받은데이터 name을 텍스트 필드에 넣기 -->
<h3>NewFile.jsp</h3>
<input type="text" value="<%=name %>"><br>

<p><%=name %></p>
</body>
</html>