<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custadd.jsp</title>
</head>
<body>

<h3>고객 추가</h3>

<div align="center">
<!-- model1에서는 custaddAf.jsp감 
	model2에서는 custuseradd로  >>parameter를 타고 왔음
 -->
<form action="custuseradd">
	<!-- 값넘기기 밖에서보여주지않고 내부에서만하는것 hidden -->
	<input type="hidden" name="command" value="addAf">
	<table>
	<col width="100px"><col width="300px">
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td align="center">아이디</td>
		<td>
			<input type="text" name="id" size="20">
		</td>	
	</tr>
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td align="center">이름</td>
		<td>
			<input type="text" name="name" size="20">
		</td>	
	</tr>
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td align="center">주소</td>
		<td>
			<input type="text" name="address" size="20">
		</td>	
	</tr>
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td align="center" colspan="2">
			<input type="submit" value="고객추가">
			<input type="reset" value="취소">
		</td>	
	</tr>	
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	
	</table>
</form> 

</div>

</body>
</html>