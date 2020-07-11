<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//DB꺼냇을때 json파일 만들기

//db를통해서 받아왔다는것을 가정
String userName = "홍길동";
int userNumber = 1001;
				//\"num\" >>key값
String json = "{ \"num\":" + userNumber + ", \"name\":\"" +userName + "\"}";
//{"num":1001, "name":"홍길동"}

out.println(json);
%>