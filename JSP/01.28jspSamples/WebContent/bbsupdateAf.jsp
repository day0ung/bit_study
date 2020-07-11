<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("utf-8");  %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);

String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println(id+title+ content);



BbsDao dao= BbsDao.getInstance();

boolean isS = dao.updateBbs(seq, title, content);

if(isS){
	%>
		<script type="text/javascript">
		alert("글수정 성공!");
		location.href = "bbslist.jsp";
		</script>
	<%
}else{
	%>
		<script type="text/javascript">
		alert("글수정 실패!");
		location.href ="bbslist.jsp";
		</script>
	<%
}
%>



</body>
</html>