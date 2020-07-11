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
<p id="demo"></p>
<br>
<button type="button">click</button>
<!-- Ajax사용할때, model1,model2접근하기 -->
<script type="text/javascript">
$(function () {
	//model1
	$("button").click(function () {
		$.ajax({
			url:"data.jsp", //"data.jsp",<<DB에서 접속하는 파일
			type:"get", //jsp에서는상관이없음
			datatype:"json",
			success:function( obj ){
				//alert("success");
				//alert(obj);
				//json은 key값으로 접근
				//alert(obj.name); //이렇게하면 undifind json파일이 문자열로넘어왔기때문
				
				//String -> json으로 바꾸는것
				var data = JSON.parse(obj);
				alert(data.name +","+data.num);
				
				//json -> String으로 바꾸기
				var str = JSON.stringify(data);
				alert(str.num); //undefined가 나옴
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