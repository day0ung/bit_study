
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String name = request.getParameter("name");
String address = request.getParameter("address");

System.out.println("id:" + id);
System.out.println("name:" + name);
System.out.println("address:" + address);
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

boolean isS = dao.addCustUser(id, name, address);
/* 
if(isS){
	response.sendRedirect("custuserlist.jsp");
}
 */
if(isS){ 
	%>
	<script type="text/javascript">
	alert("정상적으로 추가되었습니다");
	location.href = "custuserlist.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("추가되지 않았습니다. 다시 시도해 주십시오");
	location.href = "custadd.jsp";
	</script>
	<%
}
%>


</body>
</html>



