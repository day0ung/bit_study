<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ����¡�̶�� jsp �ҽ��ڵ� [1]..[10]--%>

<!-- paging ���� -->
<%
/*	  < > : [1] ~ [10] -> [11] ~ [20] 
	��ó��					�ǳ�
	  << < [1][2][3][4] > >>
*/

int totalRecordCount; //��ü ���� ��  23 -> 3page
int pageNumber;	//���������� 0 ~ 9 -> [1] ~ [10]
int pageCountPerScreen; //��ũ���� �������� , [1] ~[10], [1]~ [5] �� �����Ҽ� ����
int recordCountPerPage; //���������� ���� ��  [1] -> 10

//DB���ٿͼ� �޾��ִ°�
String st1 = request.getParameter("totalRecordCount");
if(st1 == null) totalRecordCount = 0; //ó����������
else totalRecordCount = Integer.parseInt(st1);

String st2 = request.getParameter("pageNumber"); //����������
if(st2 == null ) pageNumber = 0;
else pageNumber = Integer.parseInt(st2);

String st3 = request.getParameter("pageCountPerScreen"); //��ũ���� ������ �� 
if(st3 == null ) pageCountPerScreen = 0;
else pageCountPerScreen = Integer.parseInt(st3);

String st4 = request.getParameter("recordCountPerPage"); //��ũ���� ������ �� 
if(st4 == null ) recordCountPerPage = 0;
else recordCountPerPage = Integer.parseInt(st4);

//----�� �������� ��  [1][2][3] -> 3������
int totalPageCount = totalRecordCount/ recordCountPerPage;
//		2					23			10
//ex ���� 23�� �ִٰ� ġ��, �ѱ��Ǽ��� 23�� �������� 10��
if((totalRecordCount % recordCountPerPage) != 0){
	totalPageCount++;
}

//---- ���������� [1] , [11], [21] ���� �����Ұų���
int screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen; //������������ 0���ͽ����ؼ�, ���������ٰ� +1
//			0			=		0					10					10
//			10					9					10	
//������������ 0�̸�, ������ 10�ϸ� 0 �̳���, ������������ 9�� ������ 10���ϰ� ���ϱ� 10�ϸ� 10�̳���

//----�� ������ [10] [20] [30] 1�̸� 10�̵ǰ� 11�̸� 20�� �ǰ� 21�̸� 30����
int screenEndPageIndex	= (((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen;
//			10  			=		0				10						10					10

//----���������� �ٽð�� �ֳĸ� 1���� 10���� ���������� ���� ���� ���� [1] ~ [3] �� �������ϼ�������
							
if(screenEndPageIndex > totalPageCount){
	screenEndPageIndex = totalPageCount;
}

//��ó��, 0 ~ 9�������°��� 1 ~10���� �ٲ��־����
if((pageNumber + 1) %pageCountPerScreen == 0){
	screenStartPageIndex = (((pageNumber +1) /pageCountPerScreen) * pageCountPerScreen) - pageCountPerScreen;
	screenEndPageIndex = pageNumber +1; 
}
System.out.println("screenStartpageIndex: "+ screenStartPageIndex);
System.out.println("screenEndPageIndex: "+ screenEndPageIndex);
%>


<!-- ������ ���  > �̰��� bbslist���� �θ�����-->
<div style="float: left; width: 96%; text-align: center;">
	<!-- << -->
	<a href="#none" title="ó��������" onclick="goPage(0)">
		<img alt="" src="./image/arrow_first.gif" style="width: 9px; height: 9px;">
	</a> <!-- ó�������� �鿣�尬�ٿ��°� -->
	
	<!-- < [11] ~ [20] -> [1] ~ [10] 10�� ������ �̵���Ű�°�-->
	<%
	if (screenStartPageIndex > 1){ //�ѱ��Ǽ��� 100�� �Ѿ�� ���δ�
		%>
		<a href="#none" title="����������" onclick="goPage(<%=screenStartPageIndex -1%>)">
			<img alt="" src="./image/arrow_back.gif" style="width: 9px; height: 9px;">
		</a>
		<%
	}
	%>
	<!-- [1] 2 [3] -->
	<%
	for(int i = screenStartPageIndex; i < screenEndPageIndex; i ++){
		if(i == pageNumber){//���������� 2
		%>
		<span style="font-size: 9pt; color: #000000; font-weight: bold;">
			<%=i+1 %>		
		</span>
		<%
		}else{ //�׿��� ������ [1] 2 [3]
			%>
			<a href="#none" title="<%=i +1 %>������" onclick="goPage(<%=i %>)"
			 style="font-size: 7.5pt; color: #000000; font-weight: normal;">
			 [<%=i+1 %>]
			</a>
			<%
		}
	} 
	%>
	<!-- >  : 1 ~ 10 -> 11~20-->
	<%
	if(screenEndPageIndex < totalPageCount){ // [11][12][13]��Ż���������ں��� ��������, 13�� �������϶� 
		%>
		<a href="#none" title="����������" onclick="goPage(<%=screenEndPageIndex %>)"> 
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
	<a href="#none" title="������������" onclick="goPage(<%=end_page %>)">
		<img alt="" src="./image/arrow_end.gif" style="width: 9px; height: 9px;">
	</a>
</div>