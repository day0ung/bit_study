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

<!-- xml 불러오기 -->
<script type="text/javascript">
var target = [];
var link = [];
var aname = [];

$(function () {
	$("button").click(function () {
		$.ajax({
			url:"data.xml",
			datatype:'xml',
			//type:get 없어도됨
			success:function(data){
				//alert('success');
				var xml = $(data).find("xmldata"); //root tag값 위치찾기 
				var len = xml.find("news").length;//node의 길이값 3개(찾기)
				//alert(len);
				
				//데이터 담기(target,link,name)
				for(i = 0; i <len; i++){
					target[i] = xml.find("news").eq(i).find("target").text();
					link[i] = xml.find("news").eq(i).find("link").text();
					aname[i] = xml.find("news").eq(i).find("aname").text();
				}
				
				//p tag에 데이터 출력하기
				for(i = 0; i <len; i++){
					$("#demo").append(target[i] +
							" " +link[i] +
							" " +aname[i] + "<br>");
				}
				
				
			},
			error:function(){
				alert('error');
			}
		});
		
	});
});

</script>
</body>
</html>