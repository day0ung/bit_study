<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
//댓글의 여백과 이미지를 추가하는 함수
//ref >> 제목과 댓글의 그룹번호
//step 현재글에대해서 그다음칸들[세로방향]
//depth > 깊이, 글에대해서 댓글(depth1개),대댓글(depth2개 )이달렸을때 [가로방향]
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;"; //화살표그림다음에 여백주기위해
	
	String ts = "";
	
	//depth만큼 떨어뜨려준다음에  
	for(int i =0; i<depth; i++){
		ts += nbsp; //앞부분 여백
	}
	
	return depth==0?"":ts + rs; //depth가 0이면? 제목/그렇지않으면  댓글(여백하고 이미지가들어갈 수 있도록)
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/ui.css">
</head>
<body>
<% 
//검색이 들어왔을때(아래의 location코드들 다시 받기) 
String searchWord = request.getParameter("searchWord");
String choice = request.getParameter("choice");

if(choice == null || choice.equals("")){
	choice = "sel";
}

//검색어를 지정하지않고 choice가 넘어왔을때
if(choice.equals("sel")){ //검색어는 썻는데, 선택을 안했을때 빈문자로 돌려줌
	searchWord = "";
}
if(searchWord == null){ //선택은했는데 검색어가없을때
	searchWord = ""; //비워주겠다.. 빈문자초기화
	choice = "sel";
}
%>



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

<!-- 검색시 페이지가 넘어갔을때, 다른페이지도 검색되것이 나오도록 쓰는 함수  -->
<script type="text/javascript">
$(document).ready(function () {
	var _choice = '<%=choice %>';
	var _searchWord = '<%=searchWord %>';
	if(_choice != '' && _choice != 'sel'){		
		if(_searchWord != ""){			
			$("#choice").val(_choice);
			$("#search").val(_searchWord);
		}
	}
});

</script>


<%
//paging과 관련한 것들
String spageNumber = request.getParameter("pageNumber"); //맨처음들어왔을땐 null값
int pageNumber = 0;
//두번째들어왔을때는 값을 갖고 들어옴
if(spageNumber != null && !spageNumber.equals("")){
	pageNumber = Integer.parseInt(spageNumber);
}


	//작성글 뿌려주기위한 함수 불러주기
	BbsDao dao = BbsDao.getInstance();
	
	//검색추가한 후에 bbslist파라미터 2개 있는 함수로 변경
	//List<BbsDto> list = dao.getBbsList();
	//List<BbsDto> list = dao.getBbsList(choice, searchWord);
	
	//page와 list
	List<BbsDto> list = dao.getBbsPagingList(choice, searchWord, pageNumber);
	//el태그로 쓰기 >>접근하려면 앞부분의 " "문자열로 접근
	//request.setAttribute("list", list);

//총글의 갯수 >>페이징에 필요한것
//int len = dao.getAllBbs();
int len = dao.getAllBbs(choice, searchWord);
System.out.println("총 글의 갯수는: " + len);

int bbsPage = len / 10; //예시) 22개의 글 -> 3페이지여야함
if(len % 10 > 0){
	bbsPage = bbsPage +1;
}
%>

<!-- session의 정보 꺼내기 -->
<h4 align="right" style="background-color: #f0f0f0">
	환영합니다<%-- session에서 얻어온것 --%><%=mem.getId() %>
</h4>
<a href="./CalendarEx/calendar.jsp">일정관리</a>
<h1>게시판</h1>
<ul>
    <li><a href="./bbslist_css.jsp">게시판</a></li>
    <li><a href="./CalendarEx/calendar.jsp">일정관리</a></li>
    <li><a href="./pdslist.jsp">자료실</a></li>
  </ul>
<div align="center">

<table border="1">
<col width="70"><col width="600"><col width="150">

<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>

<%
if(list == null || list.size() ==0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다.</td>
	</tr>
	<% 
}else{
	for(int i = 0; i < list.size(); i ++){
		BbsDto bbs = list.get(i);		
	%>
	<tr>
		<!-- 번호 -->
		<th><%=i + 1 %></th> 
		<%-- 
		<!-- 제목 -->
		<td>
			<%=arrow(bbs.getDepth()) %> <!-- 댓글과 이미지  보여주기 위한 함수 호출 //호출은계속되고 있음 -->
			<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"> <!-- 글의번호 seq를 가져가서 뿌려줘야함  -->
			<%=bbs.getTitle() %> 
			</a>
		</td>
		 --%>
		 <!-- 삭제된 글 표시하기 -->
		 <td>
			<%
			if(bbs.getDel() == 0){
				%>
				<%=arrow( bbs.getDepth() ) %>			
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
					<%=bbs.getTitle() %>
				</a>	
				<%
			}else{
				%>		
				<font color="#ff0000">이 글은 작성자에 의해서 삭제되었습니다</font> 
				<%
			}
			%>
		</td> 
		<!-- 작성자 -->
		<td align="center"><%=bbs.getId() %></td>
		
	</tr>
	<%
	}
}
%>

</table>

<%
//페이지 보여주기 [1][2][3][4]
for(int i= 0; i < bbsPage; i ++){
	if(pageNumber == i){ //pagenumber는 현재페이지   [1] 2 [3]
		%>
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			<%=i +1 %>
		</span>&nbsp;
		<%
	}else{ //그 외의 페이지 
		%>
		<!-- href=#none : 아무것도 실행하지 않으며 페이지 최상단으로 이동 x
			 href=# :아무것도 실행 x 최상단으로 이동함	-->		   <!-- 현재페이지 넘버 넘겨주기 -->
		 <a href="#none" title="<%=i +1 %>페이지" onclick="goPage(<%=i %>)"
		  style="font-size: 15pt; color: #000; font-weight: bold">
		  [<%=i +1 %>]
		  </a>&nbsp;  
		<%
	}
}

%>


</div>
<a href="bbswrite.jsp">글쓰기</a>

<br>

<div align="center">

<select id="choice">
	<option value="sel">선택</option>
	<option value="title">제목</option>
	<option value="writer">작성자</option>
	<option value="content">내용</option>
</select>

<input type="text" id="search" value="">

<button onclick="searchBbs()">검색</button>

</div>

<br><br><br>

<script type="text/javascript">
//검색버튼누르면 실행되는 검색함수
function searchBbs() {
	var choice = document.getElementById("choice").value;
	var word = $("#search").val(); //textfield
	//alert(choice);
	//alert(word);

	if(word == ""){ //제목을하고 검색만눌렀을때 다시 선택으로 바꿔줌
		document.getElementById("choice").value = 'sel';
	}
	
	location.href = "bbslist.jsp?searchWord=" + word + "&choice=" + choice;
	
}

//검색페이징함수 보내주는 함수 -> 검색도같이되게 바꿔줌 
function goPage( pageNum ) {
	var choice = $("#choice").val();
	var word = $("#search").val();
//	alert("pageNum:" + pageNum);
	if(word == ""){
		document.getElementById("choice").value = 'sel';
	}
	var linkStr = "bbslist.jsp?pageNumber=" + pageNum;
	if(choice != 'sel' && word != ""){
		linkStr = linkStr + "&searchWord=" + word + "&choice=" + choice;
	}
	location.href = linkStr;
//	location.href = "bbslist.jsp?pageNumber=" + pageNum;
}


</script>

</body>
</html>