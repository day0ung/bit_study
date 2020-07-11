<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HR Tables</h1>
<p>모든 테이블의 목록을 출력한다.</p>

<%!
//선언부
public boolean has$(String msg){
	
	//$가 포함되어있는 테이블은 링크가 되지 않도록 하기 위한 함수
	return msg.contains("$"); //contains >>$라는 문자를 포함하고 있는지
}

%>

<%
//ojdbc6.jar에 들어가있는 클래스
Class.forName("oracle.jdbc.driver.OracleDriver");

//ip주소가져오기<dbdeveloper의 new orcle오른쪽클릭 후 -properties
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String password = "hr";

Connection conn = DriverManager.getConnection(url, user, password);

String sql = "SELECT * FROM TAB"; //테이블정보다가져올땐 tab
PreparedStatement psmt = conn.prepareStatement(sql);

//데이터받아오는부분
ResultSet rs = psmt.executeQuery();

ResultSetMetaData rsmd = rs.getMetaData(); //column정보가 들어옴
int count = rsmd.getColumnCount();		//column의 갯수

%>

<table border="1">
<tr>
	<%
	for(int i = 1; i < count + 1; i ++){
	%>
		<td><%=rsmd.getColumnName(i) %></td>
	<%
	}
	%>
</tr>
<%
while( rs.next() ){ //while 계속돌면서 tr이 생성된다
	%>	
	<tr>
		<%
		for(int i = 1; i < count +1; i++){
			String cols = rs.getString(i);
			//td만들어지는데 db에서 결과값을 보면 1번은 tname, 2번은 tabtype,..d
			if(i == 1 && !has$(cols)){ //i = 1 테이블명// !has$(cols)>> false엿을때 포함하지않았을때
				%>
				<!-- table명에 $가 붙지않은것들에 a태그걸어줌 실제테이블들 -->
				<td>
					<a href="table.jsp?tname=<%=cols %>"><%=cols %></a>
				</td>
				<%
			}else{ //2번째
				%>
				<td><!-- $가 붙은명칭 -->
					<%=rs.getString(i) %>
				</td>
				<%
			}
				
			
		}
		
		%>
	</tr>
	<%
}
%>
</table>

<%
//후처리 해주기
if(rs != null ) rs.close();
if(psmt != null) psmt.close();
if(conn != null) conn.close();
%>
</body>
</html>