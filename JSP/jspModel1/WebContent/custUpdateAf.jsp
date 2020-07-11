<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id= request.getParameter("id");
String name = request.getParameter("name");
String address = request.getParameter("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
CustUserDao dao = CustUserDao.getInstance();
int count = dao.CustUpdate(id, name, address);
%>

<% 
if(count > 0) {
	%>
	<script type="text/javascript">
	alert("정상적으로 수정되었습니다..");
	location.href = "custUserList.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("수정되지 않았습니다.");
	location.href = "custUserList.jsp";
	</script>
	<%
}
%>

</body>
</html>