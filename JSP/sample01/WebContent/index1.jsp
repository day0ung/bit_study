<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- scriptlet의 영역--%>
<%!
//선언부분의 영역: 변수(global)를 선언,함수선언,클래스선언 --잘안씀,알아는봐야함
			  //한번만실행됨
//scriptlet은 선언부, 코드부, value값을취득하는 부 3개가 있다.
int global_var = 0;

public void func(){
	System.out.println("func() 호출");
}
%>

<%
//코드부
global_var++;

int var =0;
var++;

out.println("global_var =" +global_var); //계속 증가됨
out.println("var =" +var); //var는 stack영역에 있음, 0으로 셋팅되면서 계속 ++

func();
%>
<%=global_var %>

</body>
</html>