<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8"); //이거추가하지않으면 전체삭제가 되지않아염...
String delArr[] = request.getParameterValues("delck");

if(delArr != null){
	for(int i = 0;i < delArr.length; i++){
		System.out.println(delArr[i]);
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>muldel.jsp</title>
</head>
<body>
<%
	CustUserDao dao = CustUserDao.getInstance();
	/*
		for문을돌려서 하나삭제하는함수해도됨
	*/
	boolean isS = dao.deleteCustUsers(delArr);

if(isS){
%>
	<script type="text/javascript">
	alert("정상적으로 삭제되었습니다.");
	location.href = "custUserList.jsp";
	</script>
<%
}else{
	%>
	<script type="text/javascript">
	alert("삭제되지 않았습니다.");
	location.href = "custUserList.jsp";
	</script>
	
	<%
}
%>
</body>
</html>