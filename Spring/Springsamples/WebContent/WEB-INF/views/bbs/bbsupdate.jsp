<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="bbsupdateAf.do" method="post"> 
<table class="list_table"  style="width: 85%">
	
	<tr>
		<td>���̵�</td>
		<td>
			<input type="text" id="id" size="30" name="id" value="${login.id }">
			<input type="hidden" id="seq" name="seq" value="${bbs.seq }">
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
  	<input id="_update" type="submit" value="����">          
   </td>
</tr>
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
</form> 
<script type="text/javascript">
$("#_update").click(function(){
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