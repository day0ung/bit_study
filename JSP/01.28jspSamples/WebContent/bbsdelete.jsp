<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
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
int seq = Integer.parseInt( request.getParameter("seq") );
System.out.println("seq:" + seq);

BbsDao dao = BbsDao.getInstance();
boolean isS = dao.deleteBbs(seq);

if(isS){
	%>
	<script type="text/javascript">
	alert("삭제하였습니다");
	location.href = 'bbslist.jsp';
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("삭제되지 않았습니다");
	location.href = 'bbslist.jsp';
	</script>	
	<%
}
%>
</body>
</html>