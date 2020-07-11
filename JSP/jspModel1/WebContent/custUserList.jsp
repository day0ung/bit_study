<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//list 가져오기 getCustUserList에서 작성한것들 불러오기
CustUserDao dao = CustUserDao.getInstance();
List<CustUserDto> list = dao.getCustUserList();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custUserList.jsp</title>
</head>
<body>
<h1>고객목록</h1>
<div align="center">

<form action="muldel.jsp" method="post">

<table style="width: 700">
<col width="100"><col width="300"><col width="300">
<tr><!-- 첫번재 라인(파란색)만들기 -->
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr>
	<th bgcolor=#ffff00>
		<input type="checkbox" name ="alldel" 
				onclick="deletechecks(this.checked)"> 
				<!-- this.checked체크박스가 체크가 되이ㅓ있는지 -->
	</th>
	<th>ID</th>
	<th>NAME</th>
</tr>

<tr><!-- 두번재 라인(파란색)만들기 -->
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<%
//list 추가해주기
if(list.size() == 0){
	%>
	<tr bgcolor="#f6f6f6">
		<td colspan="3" align="center">고객리스트가 존재하지않습니다.</td> <!-- colspan 3개를 합쳐라 > 가로  -->
	</tr>
	<tr><!-- 라인(파란색)만들기 -->
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<%
}else{ //리스트가 뿌려지는 부분
	//리스트를 뿌릴때는 for/for each사용하면됨
	for(int i = 0; i <list.size(); i++){
		CustUserDto cust = list.get(i);
		%>
		<tr bgcolor="#f6f6f6">
			<!-- 체크박스가 들어가게 하기 위함 멀티체크하려고 -->
			<td align="center" bgcolor="yellow">
												<!-- 체크를해줬을때 구분하려고, id로 구분, id는 dto가 갖고있음
														value의값은 id값으로 넘겨준다  -->
				<input type="checkbox" name="delck" value="<%=cust.getId() %>">
			</td>
			<td> <!-- ID뿌려주기 -->
				<%=cust.getId() %>
			</td>
			<td> <!-- NAME뿌려주고 링크걸기 -->
				<a href="custUserDetail.jsp?id=<%=cust.getId() %>">
					<%=cust.getName() %>
				</a>
			</td>
		</tr>
		<tr><!-- 라인(파란색)만들기 -->
			<td height="2" bgcolor="#0000ff" colspan="3"></td>
		</tr>
		
		
		<%
	}	
}
%>


<!-- 멀티삭제버튼, 고객정보를 추가하는 부분 -->
<tr>
	<!-- 다중삭제버튼 -->
	<td align="center" height="1" bgcolor="#c0c0c0" colspan="3">
		<input type="submit" value="고객정보삭제">
	</td>
</tr>
<tr><!-- 라인(파란색)만들기 -->
			<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<!-- 고객정보 추가 -->
<tr bgcolor="#f6f6f6">
	<td colspan="3">
		<a href="custadd.jsp">고객정보 추가</a>
	</td>
</tr>
</table>

</form>

</div>

<!-- deletecheks 멀티삭제 -->
<script type="text/javascript">
/* this.checked == ch 의 오브젝트는 input임 */

function deletechecks( ch ) {
	//alert(ch);
	//name= delck 는 다수이다 그래서 배열로잡음
	var arrCheck = document.getElementsByName("delck");
	
	//true로 들어왔을때 ==체크되었을때 전체체크되게 만들기
	for(i =0; i< arrCheck.length; i ++){
		arrCheck[i].checked = ch;
	}
}
</script>
</body>
</html>