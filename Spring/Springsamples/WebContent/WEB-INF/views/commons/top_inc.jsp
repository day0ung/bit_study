<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>    

<jsp:useBean id="nows" class="java.util.Date"/> <%-- 객체를 생성하는 태그  Date noew = new Date() 와 같음 이코드는 setAttibute가 필요없ㅇ므--%>
<%--
Date nows = new Date();
--%>

<div style="width: 100%;height: 53px; border-bottom: 1px solid #5e5e5e">
	<div style="width: 100%; height: 100%; clear: both; display: inline-block; ">
	
	<div id="_title_image" style="width: 30%; float: left; display: inline;">
		<img alt="" src="./image/bbslogo1.jpg" style="height: 53px">
	</div>
	
	<div id="_title_today" style="width: 70%; float: left; text-align: right;">
		<div style="position: relative; top: 27px">
			
			<c:if test="${login.id ne '' }"> <!-- ne == not login아이디가 빈문자열이아닐때 -->
				<a href="logout.do" title="로그아웃">[로그아웃]</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			
			<c:if test="${login.name ne ''}">
				[${login.name }]님 환영합니다
			</c:if>
			
			<fmt:formatDate value="${nows }" var="now" pattern="yyyy/MM/dd"/>
			${now }
		
		</div>	
	</div>
	
	</div>
</div> 












