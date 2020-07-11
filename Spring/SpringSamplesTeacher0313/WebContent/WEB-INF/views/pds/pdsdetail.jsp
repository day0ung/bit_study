<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="list_table" style="width: 85%">
<colgroup>
	<col width="200"><col width="500">
</colgroup>
<tr>	
	<th>아이디</th>
	<td style="text-align: left">${pds.id }</td>
</tr>

<tr>	
	<th>제목</th>
	<td style="text-align: left">${pds.title }</td>
</tr>

<tr>	
	<th>다운로드</th>
	<td style="text-align: left">
		<input type="button" name="btnDown" value="다운로드"  onclick="filedowns('${pds.filename}', '${pds.seq }')">
	</td>
</tr>

<tr>	
	<th>조회수</th>
	<td style="text-align: left">${pds.readcount }</td>
</tr>

<tr>	
	<th>다운로드수</th>
	<td style="text-align: left">${pds.downcount }</td>
</tr>

<tr>	
	<th>파일명</th>
	<td style="text-align: left">${pds.filename }</td>
</tr>

<tr>	
	<th>등록일</th>
	<td style="text-align: left">${pds.regdate }</td>
</tr>

<tr>	
	<th>내용</th>
	<td style="text-align: left">
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>
</table>

<script>
function filedowns(filename,seq){
	location.href="fileDownLoad.do?filename="+filename+"&seq="+seq;
}

</script>