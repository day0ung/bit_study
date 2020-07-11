<%@page import="calendarEx.CalendarDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="dto.MemberDto"%>
<%@page import="calendarEx.CalendarDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table a{color: #000; font-weight: bold; text-decoration: none}
table th:first-child{color: red;}
table th:last-child{color: blue;}
table th{background-color: #ffccff;}
</style>
<meta charset="UTF-8">
<%!
//nvl함수 
// 글자가 null이거나 빈칸이면 true
public boolean nvl(String msg){
	return msg ==null || msg.trim().equals("")? true: false;
}

//날짜를 클릭했을때 그날의 일정이 모두 보이게 하는 calendarlist.jsp 로 이동하는 함수
public String callist(int year, int month, int day){
	String str = "";//%s 이곳에 문자열이 넘어온다 라는 뜻
	str += String.format("&nbsp;<a href='%s?year=%d&month=%d&day=%d'>",
						    	"callist.jsp",year,month, day); //%s > .jsp, %d >year,month,day에 해당됨
	str += String.format("%2d", day); //<a href=""> 날짜(이곳을 의미)</a>
	str += "</a>";
		// <a href='callist.jsp?year=2020&month=02&day=05>_5</a>이렇게나옴, 5일이니까 한자리니까
	return str;
}

//펜이미지를 클릭하면, 일정추가할 수 있는 화면(calwrite.jsp)으로 이동하는 함수
public String showPen(int year, int month, int day){
	String str = "";
	
	String image = "<img src='../image/penci.png' width='18px' height='18px'>";
	
	str = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", 
						"calwrite.jsp",year,month,day,image); 
	/*
		<a href='% calwrite.jsp ?year= 2020 &month= 02 &day= 05'>
		%s --> image = "<img src='./image/pen2.png width='18px' height='18px'>";
	   </a>
	*/	
	return str;
}

// 한자리숫자 1을 -> 01로 만들어 주는 함수
public String two(String msg){
	return msg.trim().length()<2?"0"+msg.trim():msg.trim();
}

//날짜별로 테이블이 하나씩들어감, 각날짜별로 테이블 만들어주는함수
public String makeTable(int year, int month, int day, List<CalendarDto> list){
	String str ="";
	
	//2020 2 5 -> 20200205
	String dates = (year + "") + two(month + "") + two(day + "");
	
	str += "<table>";
	str += "<col width='98'>";
	
	for(CalendarDto dto : list){ //8보다 작다 7까지 임
		if(dto.getRdate().substring(0, 8).equals(dates)){
			str += "<tr bgcolor='#f9dcf0'>"; //transparent  투명
			str += "<td style='border:hidden'>";
			str += "<a href='caldetail.jsp?seq=" + dto.getSeq() +"'>";
			str += "<font style='font-size:6px;color:#d84aac'>";
			str += dot3(dto.getTitle()); //제목글자가 넘어가면 김부장미팅개많은글씨...로 표시해야함
			str += "</font>";
			str += "</a>";
			str += "</td>";
			str += "</tr>";
		}
	}
	str += "</table>";
	return str;
	
}

//일정제목이 너무 길때 ...으로 처리하는 함수 
public String dot3(String msg){
	String str = "";
	if(msg.length() >= 6){
		str = msg.substring(0, 6); //0부터 5까지만 가져오라는 것
		str += "...";
	}else{
		str = msg.trim();
	}
	return str;
}
%>
<title>Insert title here</title>
</head>
<body>
<%
	//session얻어오기 1번방법 둘다됨
	Object ologin = session.getAttribute("login"); //loginaf에서  session.setAttribute("login", mem);이렇게 해놈
	//session 얻어오기 2번방법
	//request.getSession().getAttribute(name);
	MemberDto mem = null;
	if(ologin == null){ //session기한이 다되었다는 의미 
		%>
		<script type="text/javascript">
		alert("로그인 해주셍");
		location.href = "login.jsp";
		</script>
		<%
	}
	mem = (MemberDto)ologin;
%>
<h1>일정관리</h1>

<hr>
<%
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 1); //현재달의 1일로 맞춰놓음 그래야 요일을 구할 수 있음

//얻어온게 없다고 생각하지만 버튼  >를 클릭했을때 연도와 월바뀜
String syear = request.getParameter("year");
String smonth = request.getParameter("month");

int year = cal.get(Calendar.YEAR);
if(nvl(syear) == false ){
	//빈문자일때 true아닐대 false >파라미터가 넘어왔다는 뜻
	year = Integer.parseInt(syear);
}
int month = cal.get(Calendar.MONTH) +1 ;
if(nvl(smonth) == false){
	month = Integer.parseInt(smonth);
}

if(month < 1){
	month = 12;
	year --;
}
if(month >12){
	month = 1;
	year++;
}

cal.set(year, month -1, 1); //연월일 셋팅 완료

//요일 구하기
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

// << year --
String pp = String.format("<a href='%s?year=%d&month=%d'>"
						+"<img src='../image/left.gif'></a>",
						"calendar.jsp", year -1, month);
// <  month --
String p = String.format("<a href='%s?year=%d&month=%d'>"
						+"<img src='../image/prec.gif'></a>",
						"calendar.jsp", year, month -1);
// >  month ++
String n = String.format("<a href='%s?year=%d&month=%d'>"
						+"<img src='../image/next.gif'></a>",
						"calendar.jsp", year, month +1);
// >> year ++
String nn = String.format("<a href='%s?year=%d&month=%d'>"
		+"<img src='../image/last.gif'></a>",
		"calendar.jsp", year + 1, month);

//dao불러오기
CalendarDao dao = CalendarDao.getInstance();

List<CalendarDto> list = dao.getCalendarList(mem.getId(), year + two(month + ""));
%>

<div align="center">
<table border="1">
<col width="100"><col width="100"><col width="100"><col width="100">
<col width="100"><col width="100"><col width="100">       

<tr	height="100">
	<td colspan="7" align="center" style="padding-top: 20px">
		<%=pp %>&nbsp;&nbsp;<%=p %>&nbsp;
		<font color="black" style="font-size: 50px">
			<%=String.format("%d년&nbsp;&nbsp;%2d월", year, month) %>
		</font>
		<%=n %>&nbsp;&nbsp;<%=nn %>
	</td>
</tr>

<tr height="50">
	<th align="center">일</th>
	<th align="center">월</th>
	<th align="center">화</th>
	<th align="center">수</th>
	<th align="center">목</th>
	<th align="center">금</th>
	<th align="center">토</th>
</tr>
<tr height="100" align="left" valign="top">
<%
//위쪽 빈칸 >>요일구하면나옴
for(int i = 1; i < dayOfWeek;i ++){
	%>
	<td style="background-color: #cecece">&nbsp;</td>
	
	
	<%
}
%>


<%-- 날짜 --%>
<%
//몇일까지 있는지 구해야함. getActualmaximun
int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
for(int i =1; i <= lastday; i ++){
	%>	<!-- 날짜 뿌려, 이미지 뿌림 -->
	<td><%=callist(year, month, i) %>&nbsp;&nbsp;<%=showPen(year, month, i)%>
		<%=makeTable(year, month, i, list)%>
	</td>
	<%								//i가 맨마지막날짜가 아닐때
	if((i + dayOfWeek -1)%7 == 0 && i != lastday){
		%>
		<!-- 개행 -->
		</tr><tr height="100" align="left" valign="top">
		<%
	}
}
%>

<!-- 밑에빈칸  -->
<%
cal.set(Calendar.DATE, lastday); // 그 달의 마지막 날짜
int weekday = cal.get(Calendar.DAY_OF_WEEK); //마지막날짜의 요일
for(int i = 0; i <7 - weekday; i++){
	%>
	<td style="background-color: #cecece">&nbsp;</td>
	<%
}

%>
</tr>

</table>
</div>
</body>
</html>