<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String loginId = (String) session.getAttribute("loginId");
%>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/otherstyle.css">


<div id="o_wrap">
	<div id="o_header">

		<ul class="o_gnb">
			<li class="js-main-foward">메인</li>
			<li class="js-search-foward">검색</li>
			<li class="js-qna-foward">Q&A</li>
			<li class="js-review-foward">Review</li>
			<li class="js-mypage-foward">MyPage</li>
			<li><input type="hidden" value="<%=loginId%>" class="js-session"></li>
			<li><input type="hidden" ></li>
			<li><input type="hidden" ></li>
	
			<li class="menuBtn"><button type="button"
					class="btn btn-info js-foward-regi">회원가입</button></li>
			<li class="menuBtn">
				<button type="button" class="btn btn-primary js-foward-login">로그인</button>
			</li>
		</ul>


	</div>
	<!-- //header -->

	<div id="o_sub_contents">
		<div class="o_inner">
			123123
			<ul class="clfix">
				<li>1</li>
				<li>2</li>
			</ul>
		</div>
		<!-- //inner -->
	</div>
	<!-- //sub_contents -->

	<div id="footer">
		<p>copyright 호텔의 불시착</p>
	</div>
	<!-- //footer -->
</div>
<!-- //wrap -->
</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/main-form.js"></script>
</html>