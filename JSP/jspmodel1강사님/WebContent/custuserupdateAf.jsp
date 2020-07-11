<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String address = request.getParameter("address");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserupdateAf.jsp</title>
</head>
<body>

<%
CustUserDao dao = CustUserDao.getInstance();
int count = dao.updateCustUser(id, name, address);

if(count > 0){
%>
	<script type="text/javascript">
	alert("정상적으로 수정되었습니다");
	location.href = "custuserlist.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("수정되지 않았습니다");
	location.href = "custuserlist.jsp";
	</script>
<%
}
%>

</body>
</html>