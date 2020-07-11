<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
System.out.println("id:" + id);

CustUserDao dao = CustUserDao.getInstance();
CustUserDto cust = dao.getCustuser(id);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserdetail.jsp</title>
</head>
<body>

<h3>고객 정보</h3>

<div align="center">

<table style="width: 600">
<col width="200"><col width="400">

<tr>
	<td height="2" bgcolor="#000000" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td align="center">아이디</td>
	<td><%=cust.getId() %></td>
</tr>

<tr>
	<td height="2" bgcolor="#000000" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td align="center">이름</td>
	<td><%=cust.getName() %></td>
</tr>

<tr>
	<td height="2" bgcolor="#000000" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td align="center">주소</td>
	<td><%=cust.getAddress() %></td>
</tr>

<tr>
	<td height="2" bgcolor="#000000" colspan="3"></td>
</tr>

<%-- 수정, 삭제, 목록으로 돌아가기 --%>
<tr bgcolor="#f6f6f6">
	<td>고객정보 변경</td>
	<td>
		<form action="custuserupdate.jsp" method="get">
			<input type="hidden" name="id" value="<%=cust.getId() %>">
			<input type="submit" value="수정">	<!-- 주소만 수정가능 -->
		</form>
		
		<form action="custuserdelete.jsp" method="get">
			<input type="hidden" name="id" value="<%=cust.getId() %>">
			<input type="submit" value="삭제">	
		</form>
		
		<form action="custuserlist.jsp" method="get">
			<input type="submit" value="고객목록">
		</form>
	</td>
</tr>
</table>

</div>


</body>
</html>




