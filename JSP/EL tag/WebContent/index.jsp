<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
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
	JSP의 특징: html, JavaScript, CSS, Java
	
	<%! 선언부(class,function, variable(global변수) %>
	<% 코드부  %>
	<%= value부%>
	
	EL이 나오게된 목적: front end에서 java를 사용하지 않기 위해서
	--------------------
	EL tag ->  value취득		<--Java
	Core tag -> 제어문 (jar파일필요)
	-------------------
	jsp tag 
	
	 EL (Expression Language)
	 
	 JSTL (Jsp Standard Tag Library)

 --%>
 
 <%
String str = "hello";
request.setAttribute("_str", str);  //request scope
%>

<%
String s = (String)request.getAttribute("_str");
%>

<%
out.println("s = " + s);
%>
<br><br>
s = <%=s %>
<br><br>
<!-- EL -->
s = ${ _str } <!-- 문자열을 갇고온것임  -->

<br><br>
<%='값' %>
<!-- 위와 아래는 동일한 표현식 -->
<br>
${ '값' }
<br>
<%=2+3 %>
<br>
${ 2+3 }
<br><br>

<!-- 삼항연산자 -->
${ 3>2?100:200 }
<br><br>

<!-- 주의사항: 데이터집어넣을때 object인경우 -->
<%
	request.setAttribute("data", "안녕하세요"); //data라는 문자열에 안녕하세요라는 객체를저장
%>
${ data }
<br><br>

--Object가 동적할당 되었는지? --
<br>
data = ${ empty data }<!-- true/false판정 데이터가 비워져있으면 t -->
<br>
data = ${ not empty data }<!-- true/false판정 데이터가 있으면 t -->

1 < 9 : ${ 1 <9 } <!--판별식 true가 출력 -->
<br>
2+3 : ${ 2+3 }<!-- 연산식 variable 값이 출력됨 -->
<br><br>

<%
	Integer a, b;
	a = 10;
	b = 3;
	
	request.setAttribute("a", a); //java에서는 object사용, el에서는 문자열사용
	request.setAttribute("b", b);
	
	Boolean c;
	c = false;
	request.setAttribute("c", c);
%>
<!-- 표현하기 -->
<pre>
a:${ a }
b:${ b }
c:${ c }

a+b: ${ a+b }

eq:${a eq b } <!-- false가 나온다 -->
eq:${a ==b } <!-- false가 나온다 -->

ne:${ a ne b }
ne:${ a != b }

gt:${ a gt b }
gt:${ a > b }

lt:${ a lt b }
lt:${ a < b }

le:${ a le b }<!-- <= -->
ge:${ a ge b }<!-- >= -->

div:${a div b } <!-- a/b -->
mod:${a mod b } <!-- a%b -->

c:${ !c }

${ a == 10 && !c } <!-- true -->
</pre>

<!-- dto에서 갖고온데이터 EL표현하기 -->
<br>
<%
MemberDTO mem = new MemberDTO();
mem.setMessage("Hello EL");

request.setAttribute("mem", mem);
%>

<%= mem.getMessage() %>
<br>
<!-- el에서 접근하느것은 ""에 있는 문자열임 -->
${ mem.message }
<br><br>

<!-- el배열접근하기 -->
<%
String array[] = {"hello","world"};

request.setAttribute("array", array);
%>

<%=array[0] %>
<br>
${ array[0] }
<br><br>

<!-- el list 접근하기 -->
<%
	List<String> list = new ArrayList<>();
	list.add("world");
	list.add("el");
	
	request.setAttribute("list", list);
%>

<%=list.get(0) %>
<br>
${ list[0] }
<br><br>

<!-- list안에있는 메세지 꺼내기 -->
<%
	List<MemberDTO> memlist = new ArrayList<>();
	
	MemberDTO m = new MemberDTO();
	m.setMessage("첫번째 메시지");
	memlist.add(m);
	
	m = new MemberDTO();
	m.setMessage("두번째 메시지");
	memlist.add(m);
	
	request.setAttribute("memlist", memlist);
%>

<%=memlist.get(1).getMessage() %>
<br>
${ memlist[1].message }<!-- el은 문자열로접근-->

<br><br>

<!-- el map에 접근하여 데이터 꺼내기 -->
<%
	//어떤 오브젝트도 받아주고싶다면 뒤에< , object>를 넣으면됨
	HashMap<String, String> map = new HashMap<>();
	
	map.put("apple","사과");
	map.put("grape","포도");
	
	request.setAttribute("map", map);
%>
		<!-- //map은 key값으로 접근 -->
<%=map.get("apple") %>
<br>
${map.apple }
<br> <!-- 다른방법, 배열을사용해서 >>배열안에 키값을넣으면되는데 문자열로 넣으면됨  -->
${map["apple"] }
</body>
</html>