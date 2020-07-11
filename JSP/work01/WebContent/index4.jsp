<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
//return값이 있는 함수 하나 만들기
public String setClolorHTML(String str, String color){
	return "<font color=\"" + color + "\">" + str +"</font>"; //"\ >> 따옴표
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String redText = setClolorHTML("빨강 텍스트", "#ff0000");
String greenText = setClolorHTML("초록 텍스트", "#00ff00");
String blueText = setClolorHTML("파랑 텍스트", "#0000ff");
%>
<%=redText %><br>
<%=greenText %><br>
<%=blueText %>
</body>
</html>