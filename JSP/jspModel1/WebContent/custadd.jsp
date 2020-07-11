<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 고객정보 추가 -->
<h1>고객정보 추가</h1>
<form action="custaddAf.jsp">
<table>
	<col width="100px"><col width="100px">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id">
		</td>		
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name">
		</td>		
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address">
		</td>		
	</tr>
	<tr>
	<td>
		<input type="submit" value="고객추가">
	</td>
	<td>
		<input type="reset" value="취소">
	</td>
	</tr>

</table>
</form>
</body>
</html>