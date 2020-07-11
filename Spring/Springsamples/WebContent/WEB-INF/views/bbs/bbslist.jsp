<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- �ھ��ױ׸� ����ϱ�����  -->

<!-- �˻� + ����¡ ���� -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

<form action="" name="frmForm1" id="_frmFormSearch" method="post">
<table style="margin: 3px auto;">
	<tr>
		<td>�˻�:</td>
		<td style="padding-left: 5px;">
			<select id="_s_category" name="s_category">
				<option value="" selected="selected">����</option>
				<option value="title">����</option>
				<option value="contents">����</option>
				<option value="writer">�ۼ���</option>
			</select>
		</td>
		<td style="padding-left: 5px;">
			<input type="text" id="_s_keyword" name="s_keyword">
		</td>	
		<td style="padding-left: 5px;">
			<span class="button blue">
				<button id="_btnSearch">�˻�</button>
			</span>
		</td>
	</tr>
</table>
<!-- paging ������������ �� page�ѹ��� 0 �̿����� ture-->
<input type="hidden" name="pageNumber" id="_pageNumber" value="${(empty pageNumber)?0:pageNumber }">
<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage" value="${(empty recordCountPerPage)?0:recordCountPerPage }">
</form>

</div>

<!-- arrow class ���� -->
<jsp:useBean id="ubbs" class="bit.com.a.util.BbsArrow"/> <!-- ��ü������ ���������� �����ϴ� ����̴ٸ� -->
<table class="list_table" style="width: 85%">
<colgroup>
	<col style="width: 70px"> 
	<col style="width: auto"> 
	<col style="width: 100px"> 
</colgroup>
<thead>
  <tr>
    <th>��ȣ</th>
    <th>����</th>
    <th>�ۼ���</th>
  </tr>	
</thead>

<tbody>
	<c:if test="${empty bbslist }">
	<tr>
		<td colspan="3">�ۼ��� ���� �����ϴ�</td>
	</tr>
	</c:if>
	<c:forEach items="${bbslist }" var="bbs" varStatus="vs"> <!-- var bbs => ��ü -->
	
	<!-- arrow�� setting -->
	<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/> <!-- named =�Ʊ� �����߾����� ��ü ubbs depth�� �Ʊ� arrow�ȿ� �����س��� private int dpeth = 0 �� ���� -->
	
	<tr class="_hover_tr">
		<td>${vs.count }</td>
		<td style="text-align: left;">
			<jsp:getProperty property="arrow" name="ubbs"/>  <!-- jsp:set���� setting�����ְ� �̰����� get�ϸ鼭 ����Ʈ�� �ѷ��� -->
		
			<c:if test="${bbs.del eq 1 }">
				<font style="color: red;">***�� ���� �Խ��ڿ� ���ؼ� ���� �Ǿ����ϴ�***</font> 	
			</c:if>
			<c:if test="${bbs.del eq 0 }">
				<a href="bbsdetail.do?seq=${bbs.seq }">
					${bbs.title }
				</a>			
			</c:if>
		</td>
		<td>${bbs.id }</td>		
	</tr>		
	</c:forEach>
</tbody>
</table>
<!-- ������ jsp �ҷ����� -->
<div id="paging_wrap">
	<!-- include: jsp������ �������°� --> <!-- flush >> refresh���ϰڴ� -->  <!-- paging.jsp�� setting���� -->
	<jsp:include page="/WEB-INF/views/bbs/paging.jsp" flush="false">
		<jsp:param name="totalRecordCount" value="${totalRecordCount }" />
		<jsp:param name="pageNumber" value="${pageNumber }" />
		<jsp:param name="pageCountPerScreen" value="${pageCountPerScreen }" />
		<jsp:param name="recordCountPerPage" value="${recordCountPerPage }" />
	</jsp:include>
</div>
<script>
function goPage(pageNumber){
	$("#_pageNumber").val(pageNumber);
	$("#_frmFormSearch").attr("action", "bbslist.do").submit();
}


$("#_btnSearch").click(function(){
	$("#_frmFormSearch").attr("action", "bbslist.do").submit();
});
</script>


