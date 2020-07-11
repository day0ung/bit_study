<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <form action="bbswriteAf.do" method="post">
<table class="list_table"  style="width: 85%">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" id="id" size="30" name="id" value="${login.id }">

		</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>
		 <input id="title" name="title" type="text" size="30">
		</td>
	</tr>
	
	<tr>
		<td>내용</td>
		<td>
			<textarea id="content" name="content" rows="20" cols="70"></textarea>
		</td>
	</tr>
	<tr>
   <td colspan="2" style="height: 50px; text-align: center;">
  	<input id="_btnWrite" type="submit" value="글쓰기">          
   </td>
</tr>
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
</form>
<script type="text/javascript">
$("#_btnWrite").click(function(){
	var title = $("#title").val();
	var content = $("#content").val();
	var id = $("#id").val();
	if($("#title").val() == ""){
		alert("제목을입력해주세요");
	}else if($("#content").val() == ""){
		alert("내용을 입력해주세요");
	}else{
		submit();
	}
	
});


</script>
</body>
</html>