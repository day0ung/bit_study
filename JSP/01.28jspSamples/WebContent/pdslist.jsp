<%@page import="dto.MemberDto"%>
<%@page import="dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PdsDao dao = PdsDao.getInstance();
List<PdsDto> list = dao.getPdsList();

//session에서 로그인정보빼기
MemberDto mem = (MemberDto)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자료실</h1>
<div align="center">
<table border="1">
<col width="50"><col width="60"><col width="300">
<col width="80"><col width="80"><col width="100">

<tr>
	<th>번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>다운로드</th>
	<th>조회수</th>
	<th>다운로드횟수</th>
	<th>작성일</th>
</tr>

<%
if(list.size() == 0){
%>
	<tr>
	 	<td colspan="7">자료가 없습니다.</td>
	</tr>	
<%
}else{
	for(int i =0; i <list.size(); i ++){
		PdsDto pds = list.get(i);
%>
	<tr align="center" height="5">
		<td><%=i +1 %></td>
		<td><%=pds.getId() %></td>
		<td>
			<a href="pdsdetail.jsp?seq=<%=pds.getSeq() %>">
				<%=pds.getTitle() %>
			</a>
		</td>
		<td><!-- download하는부분 file다운로드시 그상태를 유지함  seq가고가는이유는 다운로드수를 늘려주기위함-->
		<!--loction.href=filedown?filename= .jsp가 아닌이유 : servlet으로 가져간다는것  web.xml추가 java eetools-->
			 <input type="button" name="btndown" value="파일"
				onclick="location.href='filedown?filename=<%=pds.getFilename() %>&seq=<%=pds.getSeq() %>'"> 
		 
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>
	
	</tr>
<%	
	}
}
%>
</table>
<br>
<a href="pdswrite.jsp">자료올리기</a>
</div>

</body>
</html>