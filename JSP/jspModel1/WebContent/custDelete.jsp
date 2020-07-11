<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
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
boolean isS = dao.deleteCust(id);

if(isS){
%>
	<script type="text/javascript">
	alert("정상적으로 삭제되었습니다");
	location.href = "custUserList.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("삭제되지 않았습니다");
	location.href = "custUserList.jsp";
	</script>
<%
}
%>

</body>
</html>