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
	<th>���̵�</th>
	<td>${login.id }
		<input type="hidden" name="id" value="${login.id }">
	</td>
</tr>

<tr>
	<th>��ǥ����</th>
	<td>
		<select name="syear">
			<%
			for(int i = tyear; i < tyear+ 6; i ++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
		
		<select name="smonth">
			<%
			for(int i = 1; i <= 12; i ++){
			%>
			<option <%=(tmonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
		
		<select name="sday">
			<%
			for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i ++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
			~
		<select name="eyear">
			<%
			for(int i = tyear; i < tyear+ 6; i ++){
			%>
			<option <%=(tyear+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
		
		<select name="emonth">
			<%
			for(int i = 1; i <= 12; i ++){
			%>
			<option <%=(tmonth+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
		
		<select name="eday">
			<%
			for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i ++){
			%>
			<option <%=(tday+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>��
		
	</td>
</tr>

<tr>
	<th>��ǥ����</th>
	<td>
		<textarea rows="10" cols="50" name="question"></textarea>
	</td>
</tr>

<tr>
	<th>��ǥ ���׼�</th>
	<td>
		<select name="itemcount" onchange="pollchange(this)"> <!-- this�ϸ� select�� �Ѿ -->
			<%
			for(int i =2; i <= 10; i ++){ /* �Ʊ� 10���� �������Ʊ⶧���� 10������ */
			%>
			<option <%=(4+"").equals(i+"")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
			
			<%
			}
			%>
		</select>
	</td>
</tr>

<tr>
	<th>��ǥ �� ����</th><!-- �����ϴ� ������ ����ĭ -->
	<td>
	<!-- pollbean���� poll1~10���� �Ѥ����  -->
	<%
	for(int i = 1; i <= 10; i ++){
	%>
		<div id='poll<%=i %>'>
			<%=(i +"") %>��: <input type="text" name="poll<%=i %>" size="60">
		</div>
		
	<%
	}
	%>
	</td>
</tr>

<tr>
	<td colsapn="2">
		<input type="submit" value="��ǥ�����">
	</td>
</tr>
</table>

</form>

<script>
$(document).ready(function(){
	//������ ���� �ʱ�ȭ
	for( i =5; i <= 10; i ++){
		$("#poll" +i).hide();
	}
	
});

function pollchange( obj ){ //������ ������ �����ϴ� �Լ�
	var num = obj.options[obj.selectedIndex].value;
	alert(num);

	//��� �ʱ����
	for(i =1; i <= 10; i ++){
		$("#poll" +i).val("");
		$("#poll" +i).hide();
	}

	for(i = 1;i < num; i ++){
		$("#poll" + i).show();
	}
}
</script>