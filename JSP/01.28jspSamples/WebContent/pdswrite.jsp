
<%@page import="java.util.Date"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");

//시간을 취득
String fname = (new Date().getTime()) + "";
System.out.println(fname); //1580695744313 system time이 출력됨

//old 			 new 
//mydata.txt ->  1580695744313.txt 업로드 
//1580695744313 --down load --> mydata.txt 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자료올리기</h1>

<div align="center">
<%--
	id,title, content -> 자료형: String  Form Field data
	file -> 자료형: Byte 반드시 post
 --%>												<!-- cos.jar필요함 -->		
 <form action="pdsupload.jsp" method="post" enctype="multipart/form-data">
 
 <table border="1">
 <col width="200"><col width="500">
 
 <tr>
 	<th>아이디</th>
 	<td><%=mem.getId() %>
 		<input type="hidden" name="id" value="<%=mem.getId() %>">
 	</td>
 </tr>
 
 <tr>
 	<th>제목</th>
 	<td>
		<input type="text" name="title" size="50"> 	
 	</td>
 </tr>

 <tr>
 	<th>파일 업로드</th>
 	<td> <!--  type을 file로 하면 string으로 받을 수 없음 getpararmeter가 안됌, -->
		<input type="file" name="fileload" style="width: 400px"> 	
 	</td>
 </tr>

<tr>
 	<th>내용</th>
 	<td> 
 		<textarea rows="20" cols="50" name="content"></textarea>
 	</td>
 </tr>
 
 <tr align="center">
 	<td colspan="2">
 		<input type="submit" value="올리기">
 	</td>	
 </tr>
 
 </table>
 
 </form>


</div>

</body>
</html>