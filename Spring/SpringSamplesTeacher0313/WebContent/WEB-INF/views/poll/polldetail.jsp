<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="polling.do" method="post">

<table class="list_table">
<colgroup>
	<col width="200px"><col width="500px">
</colgroup>

<tr>
	<th>��ǥ��ȣ</th>
	<td style="text-align: left;">
		<input type="text" name="pollid" value="${poll.pollid }" size="50" readonly>
	</td> 
</tr>


<tr>
	<th>���̵�</th>
	<td style="text-align: left;">
		<input type="text" name="id" value="${login.id }" size="50" readonly>
	</td> 
</tr>

<tr>
	<th>��ǥ����</th>
	<td style="text-align: left;">
		${poll.sdate }~${poll.edate }
	</td> 
</tr>

<tr>
	<th>��ǥ����</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" name="question">${poll.question }</textarea>
	</td> 
</tr>

<tr>
	<th>��ǥ�����</th>
	<td style="text-align: left;">
		${poll.itemcount }
	</td> 
</tr>

<tr>
	<th>��ǥ����</th>
	<td style="text-align: left;">
		<c:forEach items="${pollsublist }" var="psub" varStatus="vs"> <!--  var  �ϳ��� ��ü �Ѱ� �޴°�, �ű⿡���� ī��Ʈ�� �ϱ� ���ؼ� �ʿ��Ѱ� varastatus-->
			${vs.count }��:
			<input type="radio" name="pollsubid" ${vs.count == 1?"checked='checked'":"" }
			value="${psub.pollsubid }">
			
			<input type="text" name="answer" size="60" 
					value="${psub.answer }" readonly>
					<br>
		</c:forEach>
	</td> 
</tr>

<tr align="center">
	<td colspan="2">
		<input type="submit" value="��ǥ�ϱ�">
	</td>
</tr>
</table>
</form>