<%@page import="bit.com.a.util.CalendarUtil"%>
<%@page import="bit.com.a.model.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
List<PollDto> plists = (List<PollDto> )request.getAttribute("plists");
%>

<!-- ������ ���  -->
<c:if test="${login.auth eq '1' }">

<table calss="list_tale" style="width: 95%">
<col width="50"><col width="50"><col width="300">
<col width="100"><col width="100"><col width="50">
<col width="50"><col width="100">
<tr>
	<th>��ȣ</th>
	<th>���̵�</th>
	<th>����</th>
	<th>������</th>
	<th>������</th>
	<th>�����</th>
	<th>��ǥ��</th>
	<th>�����</th>
</tr>
<%
	for(int i = 0; i < plists.size(); i ++){
		PollDto poll = plists.get(i);
		%>
			<tr bgcolor="#aabbcc">
				<td><%=i+1 %></td>
				<td><%=poll.getId() %>
				<td><%=poll.getQuestion() %>
				<td><%=poll.getSdate() %>
				<td><%=poll.getEdate() %>
				<td><%=poll.getItemcount() %>
				<td><%=poll.getPolltotal() %>
				<td><%=poll.getRegdate() %>
			</tr>	
		<%
	}
%>

</table>
</c:if>


<!-- ����� ���  -->
<c:if test="${login.auth eq '3' }">
<table calss="list_tale" style="width: 95%">
<col width="50"><col width="50"><col width="300"><col width="100">
<col width="100"><col width="100"><col width="50">
<col width="50"><col width="100">
<tr>
	<th>��ȣ</th>
	<th>���̵�</th>
	<th>����</th>	<!--������Ŭ���ϸ�, ��ǥ�ϰ��ؾ��� ���� ��ǥ���ߴٸ� ���ϰ��ؾ���  -->
	<th>���</th>	
	<th>������</th>
	<th>������</th>
	<th>�����</th>
	<th>��ǥ��</th>
	<th>�����</th>
</tr>
<%
for(int i = 0; i <plists.size(); i++){
	PollDto poll = plists.get(i);
%>
	<tr bgcolor="#aabbcc">
		<td><%=i+1 %></td>
				<td><%=poll.getId() %></td>
				<%
				boolean isS = poll.isVote(); //�̰� get�� ��ǥ ���� ����, pollservice���� ������°���  getPollAllList(�� true��ǥ�� /false ��ǥ����
					//��ǥ����                        �Ⱓ����
				if(isS == true || CalendarUtil.isEnd(poll.getEdate()) == true){
				%>
				<td>[����]<%=poll.getQuestion() %></td>
				<%
				}else{ 
				%>
					<td>
						<a href="polldetail.do?pollid=<%=poll.getPollid() %>">
							<%=poll.getQuestion() %>
						</a>
					</td>
				<%
				}
				%>
				<td>
				<%
				//�������
				if(isS == true || CalendarUtil.isEnd(poll.getEdate()) == true){
				%>
					<a href="pollresult.do?pollid=<%=poll.getPollid() %>">���</a>
				<%
				}else{
				%>
					<img alt="" src="image/pen.gif">
				<%
				}
				%>
				</td>
				<td><%=poll.getSdate() %></td>
				<td><%=poll.getEdate() %></td>
				<td><%=poll.getItemcount() %></td>
				<td><%=poll.getPolltotal() %></td>
				<td><%=poll.getRegdate() %></td>
			</tr>
<%
}
%>
</table>

</c:if>

<c:if test="${login.auth eq '1' }">
	<a href="pollmake.do">��ǥ�����</a>
</c:if>