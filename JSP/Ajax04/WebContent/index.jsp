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
<!-- maven >> gson >> jar 2.8.5 다운로드하고 lib파일에 넣기 -->

<p id="demo"></p>
<br>
<button type="button">click</button>
<!-- servlet에서 ajax통신할때 데이터받는방식 -->
<script type="text/javascript">
$(document).ready(function (){
		$("button").click(function () {
			$.ajax({
				url:"./hello",
				type:"post",
				datatype:"json",
				data:"num=1", /* 위에있는값 넣을때: + $("#id").val(), */
				success:function( data ){
					//alert("success");
					//alert(data);
					
					//list통채로날려준것 접근할때
					//alert(data[0].number + data[0].name);
					$.each( data, function (i, val) {
						$("#demo").append("i:" + i + " "+ "number: " + +val.number 
											+ "name: "+val.name+"<br>"  );
					});
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