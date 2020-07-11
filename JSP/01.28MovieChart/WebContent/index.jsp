<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="main.MovieManager"%>
<%@page import="main.MovieVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 크롤링, 데이터를 수집해서 뿌려주기 -->
<%
//java에서 만든 list꺼내기
List<MovieVo> list = MovieManager.getCGVdata(); 
//list > json으로 바꿔주기 (하이차트 -> demo -> piechart -> edit in codepen)	jquery추가.
for(int i = 0; i < list.size(); i++) {
   System.out.println(list.get(i).toString());
}

// list -> json

//js코드의 key ==name과 y이다
String jsonlike = "[";

for(MovieVo m : list ) {
   jsonlike += "{name:'" + m.getTitle() + "', y:" + m.getLike() + "},";  
}

jsonlike = jsonlike.substring(0,jsonlike.lastIndexOf(",")); // 맨 끝 , 제거
jsonlike += "]";
System.out.println(jsonlike);

request.setAttribute("jsonlike", jsonlike); // 데이터 묶기

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- hichart edit in codepen의 html 코드복사해서가져오기 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
</head>
<body>
<!-- 하이차트의 html 복붙 -->
<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
<!-- 하이차트의 js코드 복붙 -->
<script type="text/javascript">
Highcharts.chart('container', {
  chart: {
    plotBackgroundColor: null,
    plotBorderWidth: null,
    plotShadow: false,
    type: 'pie'
  },
  title: {
    text: '영화가 좋아요'
  },
  tooltip: {
    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
  },
  plotOptions: {
    pie: {
      allowPointSelect: true,
      cursor: 'pointer',
      dataLabels: {
        enabled: true,
        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
      }
    }
  },
  series: [{
    name: 'Brands',
    colorByPoint: true,
    data: <%= request.getAttribute("jsonlike")%>
  }]
});
</script>

</body>
</html>