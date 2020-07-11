<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
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
//session안의 로그인아이디 얻기
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem ==null){
	response.sendRedirect("login.jsp");
}

String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);

BbsDao dao = BbsDao.getInstance();

BbsDto bbs = dao.getBbs(seq);
request.setAttribute("_bbs", bbs);
%>

 <h1>수정하기</h1>
 <div align="center">
 
 <form action="bbsupdateAf.jsp" method="post">
 <input type="hidden" name="seq" value="${_bbs.seq }"> 
 <table border="1">
 <col width="200"><col width="400">
 
 <tr>
 	<th>아이디</th>
 	<td>
 		<%-- <input type="text" name="id" size="50px" value="<%=mem.getId() %>"> --%>
 		<input type="text" name="id" size="50px" value=${login.id } readonly="readonly"> <!-- el태그>바로세션에있는것 접근 -->
 	</td>
 </tr>
 
 <tr>
 	<th>제목</th>
 	<td>
 		<input type="text" name="title" size="50px">
 	</td>
 </tr>
 
 <tr>
 	<th>내용</th>
 	<td>
 		<textarea rows="20" cols="50px" name="content"></textarea>
 	</td>
 </tr>
 <tr>
 	<td colspan="2">
 		&nbsp;<input type="submit" value="수정완료">
 	</td>
 </tr>
 
 </table>
 
 </form>
 </div>
  <a href="bbslist.jsp">글목록</a>
</body>
</html>