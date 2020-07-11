<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="_youtube_">
	<iframe id="_youtube" width="640" height="360" src="http://www.youtube.com/embed/" 
		frameborder="0" allowfullscreen>
		
	</iframe>
</div>
<table class="list_table">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>유튜브 고유번호</th>
		<th>삭제</th>
	</tr>
</thead>

<tbody>
<c:if test="${empty list }">
<tr>
	<td colspan="4">작성된목록이 없습니다.</td>
</tr>
</c:if>

<c:forEach items="${list }" var="you" varStatus="vs">

<tr class="_hover_tr">
	<td>${vs.count }</td>
	<td style="text-align: left;" id="_v${you.vname }ed2" >
		<div class="c_vname" vname='${you.vname }'>${you.title }</div>
	</td>	
	<td>${you.vname }</td>
	<td>
		<img alt="" src="image/del.png" id="ck_seq" seq="${you.seq }"/>
	</td>
</tr>

</c:forEach>
</tbody>
</table>

<script type="text/javascript">
$(document).ready(function (){
	$("#_youtube_").hide();

	$("._hover_tr").mouseover(function (){
		$(this).children().css("backgroundcolor", "#f0f5ff")
	}).mouseout(function (){
		$(this).children().css("backgroundcolor", "#fff")
	});
});

$("#_btnSearch").click(function (){

	$("#_frmForm").attr("action", "yutube.do").submit();
	
});

$(".c_vname").click(function (){
	$("#_youtube_").show();
	$("#_youtube").attr("src", "http://www.youtube.com./embed/"+$(this).attr("vname") );
});

$("#ck_seq").click(function(){
	   var seq = $(this).attr("seq");
	    $.ajax({
	      type:'post',
	      url:'./youtubedelte.do',
	      async:true, // 비동기로 처리하겠다.
	      data:{"seq":seq},
	      success:function(){
	         alert('성공적으로 삭제되었습니다');
	         location.reload();
	      },
	      error:function(){
	         alert('error');
	      }

	     
	   }); 
	   
	});
</script>