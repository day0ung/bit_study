<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
%>

<% 
//데이터 받기
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");

System.out.println(id + pwd);
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDao dao = MemberDao.getInstance();

boolean isS = dao.addMember(new MemberDto(id, pwd, name, email, 0));

if(isS){
%>
	<script type="text/javascript">
	alert("성공적으로 가입");
	location.href = "login.jsp";
	</script>
<%
}else{
%>	
	<script type="text/javascript">
	alert("다시기입");
	location.href = "regi.jsp";
	</script>
<%	
}
%>

</body>
</html>