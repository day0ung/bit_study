<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//controller custuseradd.java에서 isS판별한것 얻어오기
String str = request.getParameter("isS");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 컨트롤러를 거쳐서 보내주기 -->
<%
if(str.equals("true")){
%>
	<script type="text/javascript">
	alert("성공적으로 추가되었습니다.")
	location.href = "custuserlist"; //컨트롤러(web)로 다시보내주기
	</script>
<%	
}else{
%>
	<script type="text/javascript">
	alert("추가되지 않았습니다.");
	location.href="custuseradd?command=add";
	</script>
<%
}
%>
</body>
</html>