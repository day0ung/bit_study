<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%
//DB로 접근해서 id확인하기, html코드필요없음
String id = request.getParameter("id");
System.out.println(id); //id 한글로하면 깨져, 그래서 영어로해야함

//db접근
MemberDao dao = MemberDao.getInstance();
boolean b = dao.getId(id);

///b= 가 true면 아이디가 있다는 것
if(b == true){ //id 있음
	out.println("안됌 아이디가 이미있음");
}else{ //id 없음
	out.println("사용해도되 아이디가없거든");
}

%>
