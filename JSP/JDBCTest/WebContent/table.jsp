<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//tname파라미터 확인하기
	String tname = request.getParameter("tname");
	System.out.println("tname = " + tname);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- table의 정보들을 출력 -->
<h1>HR Table</h1>

<p>지정테이블의 정보를 출력한다</p>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");

//ip주소가져오기<dbdeveloper의 new orcle오른쪽클릭 후 -properties
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String password = "hr";

Connection conn = DriverManager.getConnection(url, user, password);

//파라미터로받아온이름 tname 모든정보 sql에 넣기> query문작성
String sql = "SELECT * FROM " +  tname;

PreparedStatement psmt = conn.prepareStatement(sql);
ResultSet rs = psmt.executeQuery();
 

ResultSetMetaData rsmd = rs.getMetaData(); //column명 얻어오기
int count = rsmd.getColumnCount(); //column갯수 
%>

<!-- 시각화 -->
<table border="1">
<tr> <!-- 제목 -->
<%
	for(int i = 1; i < count +1 ; i ++){
	%>
	<td><%=rsmd.getColumnName(i) %></td>	
	<%
	}

%>
</tr>
<%
while( rs.next() ){ //rs.next() while돌리면서 게속 데이터를 뽑아냄
	%>
	<tr>
		<%
		for(int i  = 1; i < count +1; i++){
			%>
			<td><%=rs.getString(i) %></td>
			<%		
		}
		%>
	</tr>
	<%
}
%>
</table>
</body>
</html>