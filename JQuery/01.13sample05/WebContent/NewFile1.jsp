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
/* 3개의 데이터 name, age, address 받기 */
String name = request.getParameter("name");
String sage = request.getParameter("age");
String address = request.getParameter("address");

int age = Integer.parseInt(sage);

out.println("이름:" + name);
out.println("나이:" + age);
out.println("주소:" + address);

/* 두번째꺼임 */
/* id= */
String _name = request.getParameter("name");
String _sage = request.getParameter("age");
String _address = request.getParameter("address");

int _age = Integer.parseInt(_sage);

out.println("이름:" + _name);
out.println("나이:" + _age);
out.println("주소:" + _address);
%>
</body>
</html>