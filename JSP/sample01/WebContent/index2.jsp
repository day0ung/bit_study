<%@page import="sample01.MyUtil"%>
<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
//선언부 class만들기
public class MyClass{
	private int num;
	private String name;
	
	public MyClass(){
		num = 12;
		name = "world";
	}
	
	public String Print(){
		return num + " " +name;	
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 객체생성하기 -->
<%
MyClass cls1 = new MyClass();
%>

<%=cls1.Print() %>
<br>
<%
out.println(cls1.Print());
%>
<br><br>
<%-- 
YouClass, class만들어서 불러오기 
<%@page import="sample01.YouClass"%>자동적으로 추가됨
--%>
<%
YouClass ycls1 = new YouClass(100,"일지매");
%>

<%=ycls1.toString() %>

<!-- MyUtilclass의 static method호출하기  -->
<%
MyUtil.myfunc();
%>

<br><br>

<!-- java코드의 문자열을 textField에 넣기 -->
<%
String str = "hello";
%>
<input type="text" size="20" value="<%=str %>">
</body>
</html>