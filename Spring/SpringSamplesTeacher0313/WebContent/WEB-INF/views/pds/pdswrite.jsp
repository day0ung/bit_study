<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<form name="frmForm" id="_frmForm" action="pdsupload.do" method="post" enctype="multipart/form-data"><!-- ���Ͽø����� �ݵ�� post��� -->

<table class="list_table">
<tr>
	<th>���̵�</th>
	<td style="text-align: left;">
		<input type="text" name="id" readonly="readonly" value="${login.id }" size="50">
	</td>
</tr>

<tr>
	<th>����</th>
	<td style="text-align: left;">
		<input type="text" name="title" size="50">
	</td>
</tr>

<tr>
	<th>���Ͼ��ε�</th>
	<td style="text-align: left;">
		<input type="file" name="fileload" style="width:400px">
	</td>
</tr>

<tr>
	<th>����</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2" style="height: 50px; text-align: center;">
		<a href="#none" id="_btnPds" title="�ڷ�ø���">
			<img alt="" src="image/bwrite.png">
		</a>
	</td>
</tr>

</table>
</form>

<script>
$("#_btnPds").click(function(){
	//���, ���� ��ĭ�˻�
	
	$("#_frmForm").submit();
});
</script>