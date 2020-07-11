<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQeury 사용하기 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h3>입력페이지</h3>

<form id="frm"><!-- name은 전송용 -->
이름:<input type="text" name="name" size="20" placeholder="이름"><br><br>

생년월일:<input type="text" name="birth" size="20" placeholder="생년월일"><br><br>

<button type="button" id="btn">전송</button>
</form>

<script type="text/javascript">
$(function () {
	$("#btn").on("click", function () {
		$("#frm").attr("action","NewFile.jsp").submit(); /* setter가 되면서 submit이 되면서 정보가다 전송됨 */
	});
});

</script>
</body>
</html>