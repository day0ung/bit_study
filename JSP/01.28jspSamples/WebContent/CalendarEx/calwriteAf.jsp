<%@page import="calendarEx.CalendarDto"%>
<%@page import="calendarEx.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("utf-8");%>

<%!
public String two(String msg){
	return msg.trim().length()<2?"0"+msg.trim():msg.trim();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//누구의 일정인지 id얻어오기
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String hour = request.getParameter("hour");
String min = request.getParameter("min");

System.out.println(id + title+ content);
System.out.println(year+ month+ day+ hour + min);

//rdate - 202001311422가 나옴
String rdate = year+two(month) + two(day) +two(hour) + two(min);

CalendarDao dao = CalendarDao.getInstance();

boolean isS = dao.addCalendar(new CalendarDto(id, title, content, rdate));

if(isS){
	%>
	<script type="text/javascript">
	alert("일정추가 됨")
	location.href = "calendar.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("추가되지않음")
	location.href = "calendar.jsp";
	</script>
	<%
}
%>
</body>
</html>