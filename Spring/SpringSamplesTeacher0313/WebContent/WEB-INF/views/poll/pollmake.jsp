<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) +1;
int tday = cal.get(Calendar.DATE);
%>

<form action="pollmakeAf.do" method="post">
<table class="list_table">
<colgroup>
<col width="200px"><col width="500px">
</colgroup>

<tr>
	<th>아이디</th>
	<td>${login.id }
		<input type="hidden" name="id" value="${login.id }">
	</td>
</tr>

<tr>
	<th>투표기한</th>
	<td>
		<select name="syear">
			<%
			for(int i = tyear; i < tyear+ 6; i ++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>년
		
		<select name="smonth">
			<%
			for(int i = 1; i <= 12; i ++){
			%>
			<option <%=(tmonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>월
		
		<select name="sday">
			<%
			for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i ++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>일
			~
		<select name="eyear">
			<%
			for(int i = tyear; i < tyear+ 6; i ++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>년
		
		<select name="emonth">
			<%
			for(int i = 1; i <= 12; i ++){
			%>
			<option <%=(tmonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>월
		
		<select name="eday">
			<%
			for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i ++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>일
		
	</td>
</tr>

<tr>
	<th>투표내용</th>
	<td>
		<textarea rows="10" cols="50" name="question"></textarea>
	</td>
</tr>

<tr>
	<th>투표 문항수</th>
	<td>
		<select name="itemcount" onchange="pollchange(this)"> <!-- this하면 select가 넘어감 -->
			<%
			for(int i =2; i <= 10; i ++){ /* 아까 10개로 만들어놓아기때문에 10이하임 */
			%>
			<option <%=(4+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			
			<%
			}
			%>
		</select>
	</td>
</tr>

<tr>
	<th>투표 상세 문항</th><!-- 좋아하는 과일을 적는칸 -->
	<td>
	<!-- pollbean에서 poll1~10까지 넘ㅇ어옴  -->
	<%
	for(int i = 1; i <= 10; i ++){
	%>
		<div id='poll<%=i %>'>
			<%=(i +"") %>번: <input type="text" name="poll<%=i %>" size="60">
		</div>
		
	<%
	}
	%>
	</td>
</tr>

<tr>
	<td colsapn="2">
		<input type="submit" value="투표만들기">
	</td>
</tr>
</table>

</form>

<script>
$(document).ready(function(){
	//보기의 갯수 초기화
	for( i =5; i <= 10; i ++){
		$("#poll" +i).hide();
	}
	
});

function pollchange( obj ){ //보기의 갯수를 갱신하는 함수
	var num = obj.options[obj.selectedIndex].value;
	alert(num);

	//모두 초기ㅗ하
	for(i =1; i <= 10; i ++){
		$("#poll" +i).val("");
		$("#poll" +i).hide();
	}

	for(i = 1;i < num; i ++){
		$("#poll" + i).show();
	}
}
</script>