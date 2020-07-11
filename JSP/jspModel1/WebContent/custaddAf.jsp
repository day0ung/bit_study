<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
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
<!-- 백엔드에 접근하는부분 dao와접근 -->
<%
CustUserDao dao = CustUserDao.getInstance();

boolean isS = dao.addCustUser(id, name, address);
/*
if(isS){ //참이 나왔으면 추가가 됬다느 의미 
	response.sendRedirect("custUserList.jsp");
}
>>틀린거아님 이동은 됨
*/
if(isS){
	%>
	<script type="text/javascript">
	alert("정상적으로 추가되었습니다.");
	location.href = "custUserList.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert(" 추가되지 않았습니다. 다시 시도해주십시오");
	location.href = "custadd.jsp";
	</script>
	
	<%
}

%>
</body>
</html>