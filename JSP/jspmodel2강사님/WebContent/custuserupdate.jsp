<%@page import="dto.CustUserDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
    
<%--
String id = request.getParameter("id");
System.out.println("id:" + id);

CustUserDao dao = CustUserDao.getInstance();
CustUserDto cust = dao.getCustuser(id);
--%>

<%
CustUserDto cust = (CustUserDto)request.getAttribute("custuserdto");
%>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>custuserupdate.jsp</title>
</head>
<body>

<h3>수정</h3>

<div align="center">

<form action="custuserupdate" method="post">
	<input type="hidden" name="command" value="updateAf">

<table style="width: 600">
<col width="200"><col width="400">

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>아이디</td>
	<td><input type="text" size="30" name='id' value="<%=cust.getId() %>" readonly="readonly"></td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>이름</td>
	<td><input type="text" size="30" name="name" value="<%=cust.getName() %>"> </td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>주소</td>
	<td><input type="text" size="30" name="address" value="<%=cust.getAddress() %>"> </td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td colspan="2">
		<input type="submit" value="고객정보변경">
	</td>
</tr>

</table>
</form>

</div>

</body>
</html>