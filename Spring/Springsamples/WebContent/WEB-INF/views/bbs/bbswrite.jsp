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
		<td>���̵�</td>
		<td>
			<input type="text" id="id" size="30" name="id" value="${login.id }">

		</td>
	</tr>
	
	<tr>
		<td>����</td>
		<td>
		 <input id="title" name="title" type="text" size="30">
		</td>
	</tr>
	
	<tr>
		<td>����</td>
		<td>
			<textarea id="content" name="content" rows="20" cols="70"></textarea>
		</td>
	</tr>
	<tr>
   <td colspan="2" style="height: 50px; text-align: center;">
  	<input id="_btnWrite" type="submit" value="�۾���">          
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
		alert("�������Է����ּ���");
	}else if($("#content").val() == ""){
		alert("������ �Է����ּ���");
	}else{
		submit();
	}
	
});


</script>
</body>
</html>