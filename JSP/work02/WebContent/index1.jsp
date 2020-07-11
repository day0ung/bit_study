<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
//늘어나야함 그래서 선언부
int size = 0;
%>

<%
size++; //계속증가됨
%>

<!-- 테이블이 늘어나게끔 -->
<table border="1">
	<%
	for(int i =1; i < size; i++){ //row를 늘리는것 1X.., 2X.. 3X..
	%>
		<tr>
			<%
			for(int j = 1; j<size;j++){ //column늘리는것 1X1,1X2,...
			%>
					<td><%=i %>x<%=j %>=<%=i*j %></td>
				
			<%
			}
			%>
		</tr>
		
	<%
	}
	%>
</table>
</body>
</html>