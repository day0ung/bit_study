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

<!-- ajax문법의 형식 (file과 통신(jsp) -->
<script type="text/javascript">
$(function () {
	$("button").click(function () {
		//{}을잡아줬으면 json방식 혹은 두개의데이터가 들어간다라는것
		$.ajax({
			//---------------- 송신용-------------------------
			url:"data.jsp", //가야할 곳
			type:"get", 	//get,post방식
			//data:"t1=XYZ&t2:자차카", //보내주는 parameter
			data:{t1:"home",t2:"성공"}, //보내주는 parameter
			//----------------------------------------------
			
			//------------------수신용-------------------------
			success: function (data,status,xhr) {
				//alert("성공");
				$("#demo").html(data); //text하면전부다나옴
				alert(status);
				alert(xhr);
			},
			error:function(xhr, status, error){
				alert("실패");
			},
			complete:function(xhr, status){ //동작이완전히 끝났을때
				//alert("통신종료");
			}
		});
		
	});
});

</script>
</body>
</html>