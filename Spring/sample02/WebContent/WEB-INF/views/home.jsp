<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home</h1>

<%
//HelloController에서 addAttribute의 짐풀기
String name = (String)request.getAttribute("name");
out.println("name:"+name);

%>
<br>
<h3>${name }</h3>


<!-- View -> Controller데이터 전송  [HTML]-->
<a href="world.do?age=24&email=ab@naver.com">world로 이동</a>

<!-- View -> Controller데이터 전송[form]  -->
<form action="func.do">
	이름:<input type="text" name="name" value="홍길동"><br>
	주소:<input type="text" name="address" value="서울시"><br>
	나이:<input type="text" name="age" value="25"><br>
	<input type="submit" value="func이동"><br>
			
</form>
</body>
</html>