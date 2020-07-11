<%@page import="dto.QnADTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	QnADTO dto = (QnADTO) request.getAttribute("dto");
	String loginId = session.getAttribute("loginId") + "";
	if (loginId == null || loginId.equals("")) {
		response.sendRedirect(request.getContextPath() + "/fowardlogin");
	}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Comment</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<nav class="hotelcol-1">Nav</nav>
	<div class="hotelcol-2">
		<header>
			<div class="btn-group" role="group" aria-label="Basic example"
				style="float: right; padding-top: 15px; position: fixed; margin-left: 62rem;">
				<button type="button" class="btn btn-info js-foward-regi">회원가입</button>
				<button type="button" class="btn btn-primary js-foward-login">로그인</button>
			</div>
		</header>
		<main class="hotelcontent">

			<article>

				<h1>QnA Comment</h1>


				<div class="detailbox">
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="col" colspan="2">detail</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">제목</th>
								<td><%=dto.getTitle()%></td>
							</tr>

							<tr>
								<th scope="row" colspan="6">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">내용</span>
										</div>
										<textarea class="form-control" aria-label="With textarea"
											readonly="readonly" style="background-color: #fff"><%=dto.getContent()%></textarea>
									</div>
								</th>
							</tr>
						</tbody>
					</table>

				</div>

				<br> <br>

				<form action="qnacomment" method="get">
					<table class="table table-sm">
						<thead>
							<tr>
								<th scope="col" colspan="2">comment</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">제목</th>
								<td><input type="text" name="title" required="required"></td>
							</tr>
							<tr>
								<th scope="row">작성자</th>
								<td><%=loginId%><input type="hidden" name="loginId"
									value="<%=loginId%>"></td>
							</tr>
							<tr>
								<th scope="row" colspan="6">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">내용</span>
										</div>
										<textarea class="form-control" name="content"
											aria-label="With textarea" style="background-color: #fff"></textarea>
									</div>
								</th>

							</tr>
						</tbody>
					</table>
					<input type="hidden" name="command" value="qnacommentAf"> <input
						type="hidden" name="seq" value="<%=dto.getSeq()%>">
					<button type="submit">답글 달기</button>
				</form>

			</article>

		</main>
		<footer></footer>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/JS/main-form.js"></script>
</body>
</html>