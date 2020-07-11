<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="list_table" style="width: 85%">
<colgroup>
	<col width="50"><col width="100"><col width="300"><col width="50">
	<col width="50"><col width="50"><col width="100"><col width="50">
</colgroup>
<thead>
<tr>
	<th>��ȣ</th><th>�ۼ���</th><th>����</th><th>�ٿ�ε�</th>
	<th>��ȸ��</th><th>�ٿ��</th><th>�ۼ���</th><th>����</th>
</tr>
</thead>

<tbody>
<c:forEach var="pds" items="${pdslist }" varStatus="vs">
<tr class="_hover_tr">
	<td>${vs.count }</td>
	<td>${pds.id }</td>
	<td style="text-align: left;">
		<a href="pdsdetail.do?seq=${pds.seq }">${pds.title }</a>
	</td>
	<td>
		<input type="button" name="btnDown" value="�ٿ�ε�" onclick="filedowns('${pds.filename }', '${pds.seq }')">
	</td>
	<td>${pds.readcount }</td>
	<td>${pds.downcount }</td>
	<td>
		<font size="1">${pds.regdate }</font>
	</td>
	<td>
		<img alt="" src="image/del.png" data_file_seq="${pds.seq }" class="btn_fileDelte"> <!-- datafileseq ������� ������ attribute -->
		
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<!-- �߰���ư -->
<div id="button_wrap">
	<span calss="button blue">
		<button type="button" id="_btnAdd">�ڷ��߰�</button>
	</span>
</div>

<script>
$("#_btnAdd").click(function(){
	location.href="pdswrite.do";
});
</script>
