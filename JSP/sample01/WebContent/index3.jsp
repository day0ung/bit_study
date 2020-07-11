<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp 내장객체 알아보기 -->
<%
//내장객체: 동적할당(new) 하지않고 사용할 수 있는 object
//가장많이사용하는것: request
/*
request    -> getParameter,setAttribute,getAttribute  
response   -> sendRedirect,
out
session
*/						//getParameter return값 String
String name = request.getParameter("name"); // form <input type="text"로 넘어올수 있음 name을 parameter를통해서 받음
System.out.println("name:" +  name);        //<a
											//lacation.href
											//submit() - jquary
//web창에서 url로 파라미터넘겨주는방법 http://localhost:8090/sample01/index3.jsp?name=홍길동 >>?name=홍길동 이라고 치면 콘솔창에 나옴

String age = request.getParameter("age");
System.out.println("age:" +age);
//sample01/index3.jsp?name=홍길동&age=24 //& >>parameter 여려개의 값이 넘어올때 받기

String hobby[] = request.getParameterValues("hobby"); //checkbox에서 사용

//?name=홍길동&age=24&hobby=수영&hobby=독서 >> & 파라미터를 넘겨받는부분을 여려개의 값 받기
if(hobby !=null && hobby.length >0){
	for(int i = 0; i <hobby.length; i++){
		System.out.println("hobby: " + hobby[i]);
	}
}
%>
</body>
</html>