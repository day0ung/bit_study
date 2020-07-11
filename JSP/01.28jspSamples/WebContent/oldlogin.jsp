<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8ac007;
	padding: 10px;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 쿠키를 저장할 수 있는 javascript -->
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>
<h2>Login Page</h2>

<div class="center">

<form action="LoginAf.jsp" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" id="id" name="id" size="20">
			<input type="checkbox" id="chk_save_id">Save ID <!-- 클릭했을때 위의 데이터를 쿠키에저장해야함 -->
		</td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td>
			<input type="password" name="pwd" size="20">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="로그인">
			<button type="button" onclick="location.href='regi.jsp'">회원가입</button>
		</td>
	</tr>
</table>

</form>
</div>

<!-- 쿠키를 저장하기위해 script로 접근 -->
<script type="text/javascript">
/*
 session: java로 접근 ->server (login한 정보 저장) Object
 cookie: javaScript로 접근 -> client(login했던 아이디 저장)
//쿠키생성
$.cookie("user_id","abc123"); // setter (쿠키있음이라고 알림뜸) parameter가 1개면  getter
//쿠키삭제 (현재경로)
$.removeCookie("user_id",{ path: './'});
 
 */
 
var user_id = $.cookie("user_id"); // $.cookie쿠키를 접근할 수 있는 요소
if(user_id != null){
	//alert("쿠키있음");
	$("#id").val(user_id);
	$("#chk_save_id").attr("checked","checked"); //prop과 attr은 다르다 prop true로 해도됨
}

$("#chk_save_id").click(function () {
	if($("#chk_save_id").is(":checked")){
		//alert("체크됨");
		if($("#id").val().trim() == ""){
			alert("아이디를입력해주세요");
			//체크박스 체크안되게
			$("#chk_save_id").prop("checked",false);
		}else{
			//쿠키저장
			$.cookie("user_id",$("#id").val().trim(), {expires:7, path:'./'}); //{expires:7, path:'./'}); 기한 7일, 현재경로
		}
	}else{
		//alert("체크취소");
		$.removeCookie("user_id",{ path:'./'});
	}
});
</script>
</body>
</html>