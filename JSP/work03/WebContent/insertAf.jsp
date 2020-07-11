<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id= request.getParameter("id");
String pwd= request.getParameter("pwd");

String hobby[]= request.getParameterValues("hobby");

String age = request.getParameter("age");

String story = request.getParameter("story");

/* System.out.println(id);
System.out.println(pwd);
for(int i = 0; i <hobby.length; i++){
	System.out.println(hobby[i]);
}
System.out.println(age);
System.out.println(story); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertAf</title>
</head>
<body>
id:<%=id %><br>
password:<%=pwd %><br>

<%
if(hobby != null && hobby.length > 0){
	for(int i= 0; i < hobby.length; i++){
%>
취미:<%=hobby[i] %><br>

<%
	}
}else{
	%>
취미: 없음
	<%	
}
%>
<br>
age:<%=age %><br>
story:<%=story %><br>

</body>
</html>