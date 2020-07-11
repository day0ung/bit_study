<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
    forward(view 이동하기), include(view 불러오기) -> iframe
--%>

<h3>index.jsp Start</h3>

<!-- 페이지 불러오기 (flush >>refrash하겟느냐인것) -->
<jsp:include page="NewFile.jsp" flush="false"></jsp:include>

<h3>index.jsp End</h3>

<%-- 페이지 이동하기 
<jsp:forward page="NewFile.jsp"></jsp:forward>
--%>


<!--  
EL,Core의 부족한점 > 객체생성을 못함, jsp에서는 생성할 수 있음
scriptlet< % 에서 할 수 있는것 MenberDto dto = new Memberdto();

-->

<!-- -----jsp객체생성하기----- -->
<%--
	MemberDTO mem = new MemberDTO();
	mem.setMessage("안녕하세요");
	String msg = mem.getMessage();
	
	request.setAttribute("mem", mem);
--%>
<%-- 	MemberDTO mem = new MemberDTO();이거랑같은코드 --%>
<jsp:useBean id="mem" class="dto.MemberDTO"></jsp:useBean> 

<%-- mem.setMessage("안녕하세요");와 같은 코드 name = 객체명 --%>
<jsp:setProperty property="message" name="mem" value="안녕하세요"/>

<%--  String msg = mem.getMessage();와 같은코드 --%>
<jsp:getProperty property="message" name="mem"/>

message:${mem.message }

</body>
</html>