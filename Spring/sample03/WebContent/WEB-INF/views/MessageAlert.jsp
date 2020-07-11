<%@page import="bit.com.a.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
	int MsgNum = Integer.parseInt(message);
	
%>

<%
if(MsgNum == 1){
	MemberDto login = (MemberDto)session.getAttribute("login");
	%>
	<script type="text/javascript">
	alert('<%=login.getId()%>' + "님 환영합니다.");
	location.href="bbslist.do";
	</script>
	<%
}
%>