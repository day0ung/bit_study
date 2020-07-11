<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
System.out.println("seq:" +seq);

PdsDao dao = PdsDao.getInstance();
boolean isS = dao.deletePds(seq);

if(isS){
	%>
	<script type="text/javascript">
	alert("삭제 하였습니다.");
	location.href = "pdslist.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("삭제 되지 않았습니다.");
	loction.href = "pdslist.jsp";
	</script>
	<%
}
%>
</body>
</html>