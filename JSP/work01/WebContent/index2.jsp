<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- calendar로 날짜 얻어오기  -->
<%
Calendar cal = Calendar.getInstance();
int nowhour = cal.get(Calendar.HOUR_OF_DAY);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<P>
	현재 시각은 <%=nowhour %>시 입니다.

</P>
<%
	if(nowhour > 6 && nowhour < 12){
%>
	<p>안녕히 주무셨습니까?</p>
<%
	}else if(nowhour >12 && nowhour <18){
%>
	<p>안녕하세요</p>
<%
	}else{
	
%>
	<p>안녕히 주무세요</p>
<%
	}
%>
</body>
</html>