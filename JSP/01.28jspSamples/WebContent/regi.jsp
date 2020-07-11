<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h1>회원가입</h1>
<p>환영합니다</p>
<div align="center">
<form action="regiAf.jsp" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" id="id" name="id" size="20">
			id 확인
			<p id="idcheck" style="font-size: 8px"></p><!-- 아이디 존재유무를확인하기위한 p tag -->
			<input type="button" id="btn" value="id확인"> <!-- 이것을 클릭했을때  ajax가 동작해야함 -->
		</td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td>
			<input type="text" name="pwd" size="20">
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" size="20">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="email" size="20">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="회원가입">
		</td>
	</tr>

</table>

</form>
</div>

<!-- 아이디확인 Ajax -->
<script type="text/javascript">
$(function () {
	$("#btn").click(function () {
		//alert("btnclick")
		
		$.ajax({
			type:"post",
			url:"./idcheck.jsp",
			//data:"id=" + $("#id").val(),
			data:{ "id":$("#id").val() }, //json타입의 데이터 보내기/ }, 하고 여려개 보낼수 잇음
			success:function( data ){
				//location.href 사용은  make no sense
				alert(data.trim());
				if(data.trim() =="사용해도되 아이디가없거든"){
					//p tag에 문자 넣어주기
					$("#idcheck").css("color","#0000ff");
					$("#idcheck").html('사용할 수 있는 id 입니다.');
				}else{
					$("#idcheck").css("color","#ff0000");
					$("#idcheck").html('사용중인 id 입니다.');
					$("#id").val(""); //사용할 수 없는 아이디일때는 지워지게
				}
			},
			error:function(){
				alert("error");
			}
		});
	});
});

</script>
</body>
</html>