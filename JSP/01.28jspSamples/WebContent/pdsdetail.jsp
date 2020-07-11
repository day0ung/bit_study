<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq); 

MemberDto mem = (MemberDto)request.getSession().getAttribute("login");

PdsDao dao = PdsDao.getInstance();

dao.readcount(seq);

PdsDto pds = dao.getPds(seq);

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>상세 보기</h1>
<div>
<table border="1">
<tr>
	<th>작성자</th>
	<td><%=pds.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=pds.getTitle() %></td>
</tr>

<tr>
	<th>등록일</th>
	<td><%=pds.getRegdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=pds.getReadcount() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="10" cols="90" readonly="readonly"><%=pds.getContent() %></textarea>
	</td>
</tr>
</table>
<%
if(pds.getId().equals(mem.getId())){
%>
<button type="button" onclick="updatePds(<%=pds.getSeq() %>)">수정</button>
<button type="button" onclick="deletePds(<%=pds.getSeq() %>)">삭제</button>
<%	
}
%>
<script type="text/javascript">
function updatePds( seq ) {
	location.href = "pdsupdate.jsp?seq=" +seq;
}

function deletePds( seq ) {
	location.href = "pdsdelete.jsp?seq=" +seq;
	alert("정말 삭제 하시 겟습니까?");
}
</script>
</div>
</body>
</html>