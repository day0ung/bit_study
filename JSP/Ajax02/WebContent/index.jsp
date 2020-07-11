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
<!-- 
	Spring boot -> Ajax: json,xml통신(모델따로만들고 뷰따로만들자
	view(client) 	|	model(server) 따로따로만들음
	Ajax				get/post,send보내주는작업만함
	->Vue,react(Ajax가 하드코딩이라서)
 -->
 
 
 <!-- 통신 방법 1.json통신 2.xml통신(사용잘안함) 데이터갖고오기 -->
 <script type="text/javascript">
 $(function () {
	$("button").click(function () {
		$.ajax({
			url:"data.json",
			type:'get', //'',"" 상관없음
			datatype:'json',
			success:function(json){
				//alert('success');
				//alert(json); //[object Object],[object Object],[object Object]로 출력
				//alert(json[0].name+" "+json[0].age); //홍길동 24출력
				
				//----json데이터 모두를 ptag에 올릴때----
		
				/* 	
					for(i = 0; i < json.length; i++){
					$("#demo").append(json[i].name + " ");
					$("#demo").append(json[i].age + " ");
					$("#demo").append(json[i].address + " ");
					$("#demo").append(json[i].phone + "<br> ");
					} 
				*/
				//for(member m: list) m >> object 
				//한가지방법이더있음
				$.each(json, function (index, item) { //for 문이돌아가면 있는 index넘버, item= m과같은 오브젝트
					$("#demo").append(index + " ");
					$("#demo").append(item.name + " ");
					$("#demo").append(item.age + " ");
					$("#demo").append(item.address + " ");
					$("#demo").append(item.phone + "<br> ");
					
				})
			},
			error:function(){
				alert('fail');
			}
		});
		
	});
});
 
 </script>
</body>
</html>