<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session은 jsp에서 내장객체임 -->
<%
int i;

if(session.getAttribute("count") != null){
	i = (Integer)session.getAttribute("count");
}else{
	i = 0; //첫번째 방문
}

i++;
%>
방문횟수:<input type="text" value="<%=i %>" size="20">


<%
//내장객체 이용해서 세션접근
//session에 저장해서 +되게 만들기  Integer인이유: object를 넣어야하기 때문에
session.setAttribute("count", new Integer(i));

//request를 통한 session접근
//session에 접근하는 다른방법 위와 동일하다
//request.getSession().setAttribute("count", new Integer(i));
%>

</body>
</html>