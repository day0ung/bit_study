<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 페이징이라는 jsp 소스코드 [1]..[10]--%>

<!-- paging 연산 -->
<%
/*	  < > : [1] ~ [10] -> [11] ~ [20] 
	맨처음					맨끝
	  << < [1][2][3][4] > >>
*/

int totalRecordCount; //전체 글의 수  23 -> 3page
int pageNumber;	//현재페이지 0 ~ 9 -> [1] ~ [10]
int pageCountPerScreen; //스크린당 페이지수 , [1] ~[10], [1]~ [5] 로 포현할수 있음
int recordCountPerPage; //한페이지당 글의 수  [1] -> 10

//DB갓다와서 받아주는것
String st1 = request.getParameter("totalRecordCount");
if(st1 == null) totalRecordCount = 0; //처음들어왔을때
else totalRecordCount = Integer.parseInt(st1);

String st2 = request.getParameter("pageNumber"); //현재페이지
if(st2 == null ) pageNumber = 0;
else pageNumber = Integer.parseInt(st2);

String st3 = request.getParameter("pageCountPerScreen"); //스크린당 페이지 수 
if(st3 == null ) pageCountPerScreen = 0;
else pageCountPerScreen = Integer.parseInt(st3);

String st4 = request.getParameter("recordCountPerPage"); //스크린당 페이지 수 
if(st4 == null ) recordCountPerPage = 0;
else recordCountPerPage = Integer.parseInt(st4);

//----총 페이지의 수  [1][2][3] -> 3페이지
int totalPageCount = totalRecordCount/ recordCountPerPage;
//		2					23			10
//ex 글이 23개 있다고 치면, 총글의수는 23개 페이지수 10개
if((totalRecordCount % recordCountPerPage) != 0){
	totalPageCount++;
}

//---- 시작페이지 [1] , [11], [21] 부터 시작할거냐임
int screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen; //현재페이지는 0부터시작해서, 페이지에다가 +1
//			0			=		0					10					10
//			10					9					10	
//현재페이지가 0이면, 나누기 10하면 0 이나옴, 현재페이지가 9고 나누기 10을하고 곱하기 10하면 10이나옴

//----끝 페이지 [10] [20] [30] 1이면 10이되고 11이면 20이 되고 21이면 30ㅇ됨
int screenEndPageIndex	= (((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen;
//			10  			=		0				10						10					10

//----끝페이지는 다시계산 왜냐면 1부터 10까지 딱떨이지지 않을 수도 있음 [1] ~ [3] 이 마지막일수도있음
							
if(screenEndPageIndex > totalPageCount){
	screenEndPageIndex = totalPageCount;
}

//후처리, 0 ~ 9까지가는것을 1 ~10까지 바꿔주어야함
if((pageNumber + 1) %pageCountPerScreen == 0){
	screenStartPageIndex = (((pageNumber +1) /pageCountPerScreen) * pageCountPerScreen) - pageCountPerScreen;
	screenEndPageIndex = pageNumber +1; 
}
System.out.println("screenStartpageIndex: "+ screenStartPageIndex);
System.out.println("screenEndPageIndex: "+ screenEndPageIndex);
%>


<!-- 페이지 출력  > 이것을 bbslist에서 부를거임-->
<div style="float: left; width: 96%; text-align: center;">
	<!-- << -->
	<a href="#none" title="처음페이지" onclick="goPage(0)">
		<img alt="" src="./image/arrow_first.gif" style="width: 9px; height: 9px;">
	</a> <!-- 처음페이지 백엔드갔다오는것 -->
	
	<!-- < [11] ~ [20] -> [1] ~ [10] 10개 단위로 이동시키는것-->
	<%
	if (screenStartPageIndex > 1){ //총글의수가 100개 넘어야 보인다
		%>
		<a href="#none" title="이전페이지" onclick="goPage(<%=screenStartPageIndex -1%>)">
			<img alt="" src="./image/arrow_back.gif" style="width: 9px; height: 9px;">
		</a>
		<%
	}
	%>
	<!-- [1] 2 [3] -->
	<%
	for(int i = screenStartPageIndex; i < screenEndPageIndex; i ++){
		if(i == pageNumber){//현재페이지 2
		%>
		<span style="font-size: 9pt; color: #000000; font-weight: bold;">
			<%=i+1 %>		
		</span>
		<%
		}else{ //그외의 페이지 [1] 2 [3]
			%>
			<a href="#none" title="<%=i +1 %>페이지" onclick="goPage(<%=i %>)"
			 style="font-size: 7.5pt; color: #000000; font-weight: normal;">
			 [<%=i+1 %>]
			</a>
			<%
		}
	} 
	%>
	<!-- >  : 1 ~ 10 -> 11~20-->
	<%
	if(screenEndPageIndex < totalPageCount){ // [11][12][13]토탈페이지숫자보다 적었을때, 13이 마지막일때 
		%>
		<a href="#none" title="다음페이지" onclick="goPage(<%=screenEndPageIndex %>)"> 
			<img alt="" src="./image/arrow_next.gif" style="width: 9px; height: 9px;">
		</a>
		<%
	}
	int end_page = 0;
	if(totalPageCount > 0){
		end_page = totalPageCount -1;
	}
	%>
	
	<!-- >> -->
	<a href="#none" title="마지막페이지" onclick="goPage(<%=end_page %>)">
		<img alt="" src="./image/arrow_end.gif" style="width: 9px; height: 9px;">
	</a>
</div>