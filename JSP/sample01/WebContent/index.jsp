<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <!-- 변수선언 html바깥에 해도됨 -->
 <%
 	String str = "Hello jsp";
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석문 -->
<%-- 
     JSP 주석문
	 Java Server Page
 
 	 client    ------>           server(web/WAS)   <--------> web서버에서Server( DB)로 접근
 	 		 request              java + html코드
 	 	 localhost:8080/sample
 	 	 						 web server/
 	 	 						 web container(servlet/jsp 내포되어있음) 내가작업하는위치임
 	 	 						 			  get/post ->보안
 	 	 		<------------    해석
 	 	 		response
 								 Spring Framework    Mybatis Framework
 	Servlet = Java(HTML)
 	JSP     = HTML(Java)
 			=html,javascript,css,jqeury,java 사용가능
 --%>
<!-- jsp는 서버코드와 client코드를 구분해야한다. -->
<h1>Hello JSP</h1>

<%
	//Java 영역
	//Scriptlet = sciprt + applet
	System.out.println("console 출력");
	
    /*
	   내장(암시)객체: new를 하지않고 바로사용할 수 있는 Object
	   request, response, session, out>>웹으로 내보내는 내장객체
	   HttpServletRequest >>간단히만들어놓은것 request

	   session은 생성이필요했음,
	*/
	out.println("Web 출력<br>");
	out.println("Web 출력");
%>

<%
out.println("<h3>hello jsp분리해서 써도 무방함</h3>");
%>

<%
System.out.println("str = "+str);
out.println("str = "+str);
%>
<br>
<%=str %> <!-- value만 취득하겟다 -->
<br><br>

<!-- p tag 10번적기 -->
<%
for(int i = 0; i <10; i++){
%>

<p class="demo">P tag<%=i +1 %></p>

<%
}
%>

<!-- 위와 동일한 코드 -->
<%
for(int i = 0; i <10; i++){
	out.println("<p class='demo'>P tag"+(i + 1) +"</p>");
}
%>

<!-- javascipt -->
<p id="demo">p demo</p>

<script type="text/javascript">
document.getElementById("demo").innerHTML = "chanege p tag content";
</script>
</body>
</html>