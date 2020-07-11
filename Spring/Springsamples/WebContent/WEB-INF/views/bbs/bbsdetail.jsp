<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="" id="frm" name="frm" method="post">
<table class="list_table" style="width: 85%">
	<tr>
		<td>작성자</td>
		<td>
			<input type="text" id="id" size="30" name="id" value="${dto.id }" readonly="readonly">
			<input type="hidden" id="seq" name="seq" value="${dto.seq }">
		</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>
		 <input id="title" name="title" type="text" size="30"  readonly="readonly" value="${dto.title }">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea id="content" name="content" rows="20" readonly="readonly" cols="70">${dto.content }</textarea>
		</td>
	</tr>
	<tr>
		 <td colspan="2" style="height: 50px; text-align: center;">
	      <a href="#none" id="_reply" title="답글달기">
	         <img alt="" src="./image/breply.png">
	      </a>               
	   </td>
	</tr>
	<c:if test="${dto.id == login.id}">
	<tr>
	   <td colspan="2" style="height: 50px; text-align: center;">
	      <a href="#none" id="_btnUpdate" title="수정하기">
	         <img alt="" src="./image/bupdate.png">
	      </a>               
	      <a href="#none" id="_btnDelete" title="삭제하기">
	         <img alt="" src="./image/del.png">
	      </a>               
	   </td>
	 </tr>  
	 <tr>
	   <td colspan="2" style="height: 50px; text-align: center;">
	   </td>
	</tr>
	</c:if>
</table>
</form>
<script type="text/javascript">
$("#_btnUpdate").click(function(){
	$("#frm").attr("action", "bbsupdate.do").submit();

});
$("#_btnDelete").click(function(){
	alert("삭제하시겠습니까?");
	$("#frm").attr("action", "bbsdelete.do").submit();
});

$("#_reply").click(function(){
	alert("답글달기버튼클릭");
});
</script>
</body>
</html>