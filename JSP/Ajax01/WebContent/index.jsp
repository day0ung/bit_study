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
<!-- AJAX : Asynchronous JavaScript And Xml 비동기통신
	Ajax목적: 비동기 상태로 데이터를 송수신하기위함
	synchronous :동기 (동기화처리:순서대로가져가는것)
	예시) CustUserAdd.jsp --- > CustUserAddAf.jsp  ->
		    form         name    DB insert
	Asynchronous :비동기(화면내부에서 유지한상태로 DB에서가져오는것
	예시) CustuserAdd.jsp <-  DB,Controller, Dao
	현재 form을 유지한 상태로 데이터 통신을 수행 (id확인할때사용한다.)
	
	ajax == JQuery소속
-->
<!--
	현재보고있는화면에  
	HTML파일을불러들여서 데이터 뿌려주기 
	데이터불러들이기 >>. load
-->
<p id="demo"></p>
<br>
<button type="button">click</button>

<script type="text/javascript">
$(function () {
	$("button").on("click",function () { //on은 server와 통신하는것이 불가
 	//$("button").click(function () {
		//html파일 데이터를 전체 불러옴
 		//$("#demo").load("data.html")
		
		//파라미터로넘기는방법, html파일안의 id값이용해서 data2만가져오기
		//$("#demo").load("data.html #data2")
		
		//jsp파일에 데이터 던져주고, 읽어와서 화면에 뿌리기 /
		//$("#demo").load("data.jsp", "t1=abc&t2=가나다"); //(읽을데이터가있는곳, 넘길데이터(파라미터))
		//$("#demo").load("data.jsp",{ t1:"ABC", t2:"라마바"}); //json과 비슷한방식(key:value)
		
		//함수를사용하는방법
		$("#demo").load("data.jsp", { t1:"ABC", t2:"라마바"}, function (data, status, xhr) { //(data):넘어온데이터
			//alert(data); //데이터전체영역을 불러온다. { t1:"ABC", t2:"라마바"}하기전 데이터넘겨준게없기때문에 t1,t2 = null로 뜬다
						 //{ t1:"ABC", t2:"라마바"}데이터를 넣어주면 해당데이터가 넘어오면서 값이 나옴
			$("#demo").append("data= "+ data +"<br>");
			$("#demo").append("status= "+ status +"<br>"); //데이터갖고온것이 성공해서 :success
			$("#demo").append("xhr= "+ xhr +"<br>");
		});
		
		/* $("#demo").load("data.jsp", //데이터불러올, JSP파일
						{ t1:"ABC", t2:"라마바"}, //데이터 송신
						function (data, status, xhr) {  //데이터수신
						$("#demo").append("data= "+ data +"<br>");
						$("#demo").append("status= "+ status +"<br>"); //데이터갖고온것이 성공해서 :success
						$("#demo").append("xhr= "+ xhr +"<br>");
						}
		); */
	});
	
	
});
</script>
</body>
</html>