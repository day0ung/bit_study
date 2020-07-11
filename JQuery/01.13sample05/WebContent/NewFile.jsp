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
/* 파라미터 넘어가는 것은 무조건 String */
String  id = request.getParameter("id");

out.println("id:" + id); /* 외부로 내보내기 */
System.out.println("id:"+ id);/* 콘솔로 내보내기 */
%>

</body>
</html>