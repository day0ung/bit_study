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

<!-- 관리자 모드  -->
<c:if test="${login.auth eq '1' }">

<table calss="list_tale" style="width: 95%">
<col width="50"><col width="50"><col width="300">
<col width="100"><col width="100"><col width="50">
<col width="50"><col width="100">
<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>질문</th>
	<th>시작일</th>
	<th>종료일</th>
	<th>보기수</th>
	<th>투표수</th>
	<th>등록일</th>
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


<!-- 사용자 모드  -->
<c:if test="${login.auth eq '3' }">
<table calss="list_tale" style="width: 95%">
<col width="50"><col width="50"><col width="300"><col width="100">
<col width="100"><col width="100"><col width="50">
<col width="50"><col width="100">
<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>질문</th>	<!--질문을클릭하면, 투표하게해야함 만약 투표를했다면 못하게해야함  -->
	<th>결과</th>	
	<th>시작일</th>
	<th>종료일</th>
	<th>보기수</th>
	<th>투표수</th>
	<th>등록일</th>
</tr>
<%
for(int i = 0; i <plists.size(); i++){
	PollDto poll = plists.get(i);
%>
	<tr bgcolor="#aabbcc">
		<td><%=i+1 %></td>
				<td><%=poll.getId() %></td>
				<%
				boolean isS = poll.isVote(); //이게 get임 투표 가능 여부, pollservice에서 갖고오는거임  getPollAllList(의 true투표함 /false 투표안함
					//투표했음                        기간종료
				if(isS == true || CalendarUtil.isEnd(poll.getEdate()) == true){
				%>
				<td>[마감]<%=poll.getQuestion() %></td>
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
				//결과보기
				if(isS == true || CalendarUtil.isEnd(poll.getEdate()) == true){
				%>
					<a href="pollresult.do?pollid=<%=poll.getPollid() %>">결과</a>
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
	<a href="pollmake.do">투표만들기</a>
</c:if>