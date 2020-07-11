<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//bbslist.jsp에서 seq를 넘겨줌 문자열로 받아온 후 변화
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
작성자
제목
작성일 
조회수  ->readcount()
내용

버튼: (수정, 삭제), 댓글, 목록
 --%>
 
 <%
 //session을 통해서 얻어오기
 MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
 %>
 
 <%
 //data얻어오기
 BbsDao dao = BbsDao.getInstance();
 
 //카운트수 먼저올라가고나서 
 dao.readcount(seq);
 
 //조회수가 갱신되면 거기에 맞춰서 데이터 seq 꺼내기
 BbsDto bbs = dao.getBbs(seq); 
 %>
 
 <h1>상세 글 보기 </h1>
<div>
<table border="1">
<colgroup>
	<col style="width: 150">
	<col style="width: 600">
</colgroup>

<tr>
	<th>작성자</th>
	<td><%=bbs.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=bbs.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=bbs.getWdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=bbs.getReadcount() %></td>
</tr>
<!-- 개발자용 -->
<tr>
	<th>정보</th>
	<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="10" cols="90" readonly="readonly"><%=bbs.getContent() %></textarea>
	</td>
</tr>
</table>
<%
//로그인한 사람과 작성자명과 같아야함
//bbs.getId =작성자/ mem.getId =로그인한 사람
if(bbs.getId().equals(mem.getId())){
%>
<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>
<%
}
%>


<%-- 댓글 --%>
<form action="answer.jsp" method="get">
	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
	<input type="submit" value="댓글">
</form>
</div>

<button type="button" onclick="location.href=bbslist.jsp">목록</button>

<script type="text/javascript">
function updateBbs( seq ) {
	location.href = "bbsupdate.jsp?seq=" + seq;
}

function deleteBbs( seq ) {
	location.href = "bbsdelete.jsp?seq=" +seq;
	alert("정말삭제하시겠습니까?");
}
</script>
</body>
</html>