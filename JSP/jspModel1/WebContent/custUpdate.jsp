<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id= request.getParameter("id");

CustUserDao dao = CustUserDao.getInstance();
CustUserDto dto = dao.getCust(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custUpdate</title>
</head>
<body>


	<h1>수정페이지</h1>
	<form action="custUpdateAf.jsp">
	<table>
		<col width="100px"><col width="100px">
		<tr>
			<td>아이디</td>
			<td >
				<input type="text" name="id" value="<%=dto.getId() %>" readonly="readonly">
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
		<td>
			<input type="submit" value="정보변경">
		</td>
		</tr>
		
	</table>
	</form>


</body>
</html>