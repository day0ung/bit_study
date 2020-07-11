<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- core tag는 링크와  jar파일이 필요하다 -->
<%--
	EL: 표현식(값, 판별)
	Core: 제어문(for, if) -EL tag와 같이 사용한다
 --%>
 
 <%
 request.setAttribute("data", "JSTL입니다");
 %>
 
 ${ data }
 <br>

 <!--Core tag >> set request.set과 동일-->
<%--
//아래의 코드와 동일함 java버전
String cdata ="core JSTL입니다";
request.setAttribute("cdata", cdata); 
//set var="cadata" << 두가지작업을 한꺼번에 해주는것
--%> 
<!-- var변수에 value값를 집어넣겟다는 것 -->
 <c:set var="cdata" value="core JSTL입니다"/>
 ${ cdata }
 <br><br>
 
 
 <!-- out.println 내장객체  웹에다가 던져주는것-->
<%--
out.println(cdata);
--%>
<%
session.setAttribute("sessionData", "저장된데이터");
%>
<c:set var="sdata" value="${ sessionData }"/>
<c:out value="${ sdata }"/>
<br><br>


<!-- -----------if core에는 else문이 없음--------------  -->
<%
request.setAttribute("count", "10");
%>
<%
String sCount = (String)request.getAttribute("count");
int count = Integer.parseInt(sCount);
if(count >= 10){
	%>
	<p>count:<%=count %></p>
	<%
}
%>
		<!-- coretag 사용 -->
<c:if test="${ count >=10 }">
	<p>core count: <c:out value="${count }"></c:out>
</c:if>

<br><br>

<!-- 넣은데이터 판단하기 -->
<%
	request.setAttribute("name", "홍길동");
%>

<c:if test="${ name eq '홍길동' }">
	<p> 제이름은 홍길동이 맞습니다.</p>
</c:if>

<!-- 데이터판단할때 다른처리방법  -->
<%
	request.setAttribute("name", "일지매"); /* 위 홍길동과 같은 name을사용해도 되지만 홍길동데이터는 사라짐 */
%>

<c:if test="${ name =='일지매' }" var="flg"></c:if> <!-- 조건이 참이면 flg안에 데이터가 들어가진다  -->
<c:if test="${ flg }">
	<p>이름은 일지매 입니다</p>
</c:if>



<!--  --------------for---------- -->
<%
for(int i =0; i <10; i++){
	%>
	<%=i %>
	<%
}
%>

<br>
<<%-- begin="0" 0부터시작 end="9" 9까지 step="1" 1씩증가 varStatus="i" 변수 = i> --%>
<!-- for문자체가 foreach임 -->
<c:forEach begin="0" end="9" step="1" varStatus="i">
	<c:out value="${ i.index }"></c:out>
</c:forEach>

<br><br>


<!-- dto에있는 데이터 list얻어오기 -->
<%
List<MemberDTO> list = new ArrayList<>();
MemberDTO mem = new MemberDTO();
mem.setMessage("하이");
list.add(mem);

mem = new MemberDTO();
mem.setMessage("안녕");
list.add(mem);

mem = new MemberDTO();
mem.setMessage("반가워");
list.add(mem);

request.setAttribute("list", list);
%>

<%--
for(int i=0; i< list.size(); i++){
	MemberDTO m = list.get(i);
}
for(MemberDTO m : list){
	
}
--%>
<c:forEach begin="0" end="2" var="m" items="${ list }" varStatus="i">
<p>index: <c:out value="${i.index }"/></p>
<p>data:<c:out value="${ m.message }"></c:out> <!-- dto에 set/getter없으면 접근할 수 없음 -->
</c:forEach>


<br><br>
<!-- -----------map--------- -->
<%
	Map<String, String> map = new HashMap<>();
	map.put("apple", "사과");
	map.put("pear", "배");
	map.put("banana", "바나나");
	
	request.setAttribute("map", map);
%>

<!-- map을 꺼낼때는 for each문으로 -->
<c:forEach var="obj" items="${map }">
	key:<c:out value="${obj.key }"></c:out>
	valu:<c:out value="${obj.value }"></c:out>
</c:forEach>
</body>
</html>