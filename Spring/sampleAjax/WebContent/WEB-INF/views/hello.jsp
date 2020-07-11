<%@page import="bit.com.a.model.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<h1>Hello</h1>
<!--1번째 방법  -->
<%
MyClass cls = (MyClass)request.getAttribute("myCls");
%>
number:<%=cls.getNumber() %><br>
name:<%=cls.getName() %><br>

<!-- EL tag -->
[EL tag]number:${myCls.number }<br>
[EL tag]name:${myCls.name }<br>

<br><br>


<!-- 2번째 방법 -->
<!-- form으로 이동하기 -->
<form action="move.do">
<input type="submit" value="move">
</form>

<!-- 3번재 Ajax -->
<form>
아이디:<input type="text" id="checkid"><br>
<button type="button" id="_check" onclick="idcheck()">id check</button>
</form>

<script type="text/javascript">
function idcheck(){
	alert("chek");
	$.ajax({
		url:"./idcheck.do", //현재경로에서 컨트롤러로가라
		type:"get",
		data:"id="+$("#checkid").val(),
		success:function( data ){
			alert("success");
			alert(data); //오케이
		},
		error:function(){
			alert("error");
		}	
	});
}
</script>



<!-- 4번째 다수의 데이터 json으로날려서  controller에서  dto로 받기  Form -->
<br>
<form method="post">
이름:<input type="text" id="_name" value="홍길동"><br>
전화:<input type="text" id="_phone" value="010-12"><br>
이메일:<input type="text" id="_email" value="@namver.com"><br>
생년월일:<input type="text" id="_birth" value="961208"><br>
<button type="button" id="account">account</button>
</form>


<script type="text/javascript">
$("#account").click(function(){
	//alert("click");
	//json -> dto
	//json으로 묶기
	var human = {
			name:$("#_name").val(),
			phone:$("#_phone").val(),
			email:$("#_email").val(),
			birth:$("#_birth").val()
	};

	$.ajax({
			url:"./account.do",
			type:"post",
			data: human,
			dataType:"json",
			async: true,
			success:function( resp ){
				alert("success");
				alert(resp.msg);
				alert(resp.name);
			
			},
			error:function(){
				alert("error");
			}	
	});
});

</script>


<br><br>
<!-- 5번째 방법 대량의 데이터 날려주기[json으로 보내고 controller에서 map -->
이름:<input type="text" id="_name1" value="일지매친구"><br>
전화:<input type="text" id="_phone1" value="010-12"><br>
이메일:<input type="text" id="_email1" value="@namver.com"><br>
생년월일:<input type="text" id="_birth1" value="2009-02-25"><br>
<button type="button" id="account1">account</button>

<script type="text/javascript">
//json -> map
	$("#account1").on("click", function(){
		alert("count1");

		var data = {};
		data["name"] = $("#_name1").val();
		data["phone"] = $("#_phone1").val();
		data["email"] = $("#_email1").val();

		var birth = $("#_birth1").val();
		data["birth"] = birth.replace(/-/g,""); //2020-02-25 ->20200225
		//alert(data["birth"]);

		$.ajax({
			contentType: 'application/json',
			dataType: "json",
			url: "updateUser.do",
			type: "post",
			data: JSON.stringify(data), //배열식으로 저장한데이터는 >>stringify : json을 String으로 바꿔주는것 <-> parse 
			success:function( resp ){
				alert("success");
				alert(resp.name);
				alert(resp.age);
			
			},
			error:function(){
				alert("error");
			}	
		});
	});
	

</script>

</body>
</html>