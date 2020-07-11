<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

CustUserDao dao = CustUserDao.getInstance();
CustUserDto dto = dao.getCust(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custUserDetail</title>
</head>
<body>
<h1>상세정보</h1>


<form action="custUpdate.jsp">
<table>
	<col width="100px"><col width="100px">
	<tr>
		<td>아이디</td>
		<td >
			<input type="text" name="id" value="<%=dto.getId() %>">
		</td>		
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" value="<%=dto.getName() %>">
			
		</td>		
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address" value="<%=dto.getAddress() %>">
		</td>		
	</tr>
	<tr>
		<td>고객정보 변경</td>
	<td>
		<form action="custUpdate.jsp" method="get">
			<input type="hidden" name="id" value="<%=dto.getId() %>">
			<input type="submit" value="수정">	<!-- 주소만 수정가능 -->
		</form>
		
		<form action="custDelete.jsp" method="get">
			<input type="hidden" name="id" value="<%=dto.getId() %>">
			<input type="submit" value="삭제">	
		</form>
		
		<form action="custUserList.jsp" method="get">
			<input type="submit" value="고객목록">
		</form>
	</td>
	</tr>
	<tr>
		
	</tr>
</table>
</form>	
</body>
</html>