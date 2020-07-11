<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");

String postNum1 = request.getParameter("postNum1");
String postNum2 = request.getParameter("postNum2");

String address = request.getParameter("address");

String trans[] = request.getParameterValues("trans");

String money = request.getParameter("money");
String maga = request.getParameter("maga");

if(trans != null && trans.length > 0){
	for(int i = 0;i < trans.length; i++){
		System.out.println(trans[i]);		
	}
}




%>    
