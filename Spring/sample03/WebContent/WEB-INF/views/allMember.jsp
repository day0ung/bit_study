<%@page import="bit.com.a.model.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>allMember.jsp</h1>

<%
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("memlist");
%>

<%
for(int i = 0;i < list.size(); i++){
	MemberDto mem = list.get(i);
	%>
	<p><%=mem.toString() %></p>
	<%
}
%>



</body>
</html>



