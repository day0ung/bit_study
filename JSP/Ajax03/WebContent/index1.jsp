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
<!-- server와 통신하기(servlet) javascript는 유일하게 서버와통신하는것은 ajax임  -->
<script type="text/javascript">
$(function(){
   
   $("button").click(function(){
      //jar파일추가 잊지말것,
      // ajax : 서버와 데이터를 주고받을 수 있다.
      $.ajax({
         url:"custuser", // servlet 
         type:"get",
         datatype:"json",
         data:"id=abc&pwd=123",
         success:function(json){
           // alert("success");   
            
           //servlet에서 보낸 str의 키값으로 접근
           //alert(json.str);
            
           //servlet에서 보낸 map키값으로 접근
           //alert(json.map.title);
           
           alert(json.map.list);
           
           //list에 담은것 배열로접근하기
           var list = json.map.list;
           alert(list[0].number);
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