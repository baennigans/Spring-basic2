<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>인공지능소프트웨어과 스프링프레임워크</title>

<link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("../../images/customer/visual.png") no-repeat center;
}
</style>
</head>

<body>
	<!-- header 부분 -->

	<header id="header">

		<div class="content-container">
			<!-- ---------------------------<header>--------------------------------------- -->

			<h1>인공지능소프트웨어과</h1>

		</div>

	</header>

	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- main --------------------------------------- -->



			<main class="main">
				<h2 class="main title">공지사항</h2>

				<div class="breadcrumb">
					<h3 class="hidden">경로</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>

				<div class="search-form margin-top first align-right">
					<h3 class="hidden">공지사항 검색폼</h3>
					<form class="table-form">
						<fieldset>
							<legend class="hidden">공지사항 검색 필드</legend>
							<label class="hidden">검색분류</label> <select name="f">
								<option value="title">제목</option>
								<option value="writerId">작성자</option>
							</select> <label class="hidden">검색어</label> <input type="text" name="q"
								value="" /> <input class="btn btn-search" type="submit"
								value="검색" />
						</fieldset>
					</form>
				</div>

				<div class="notice margin-top">
					<h3 class="hidden">공지사항 목록</h3>
					<table class="table">
						<thead>
							<tr>
								<th class="w60">번호</th>
								<th class="expand">제목</th>
								<th class="w100">작성자</th>
								<th class="w100">작성일</th>
								<th class="w60">조회수</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="n" items="${list}">
								<tr>
									<td>${n.id}</td>
									<td class="title indent text-align-left">${n.title}</td>
									<td>${n.writerId}</td>
									<td>${n.regDate}</td>
									<td>${n.hit}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>

				<div class="indexer margin-top align-right">
					<h3 class="hidden">현재 페이지</h3>
					<div>
						<span class="text-orange text-strong">1</span> / 1 pages
					</div>
				</div>

				<div class="margin-top align-center pager">

					<div>


						<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>

					</div>
					<ul class="-list- center">
						<li><a class="-text- orange bold" href="?p=1&t=&q=">1</a></li>

					</ul>
					<div>


						<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>

					</div>

				</div>
			</main>


		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->



	<footer id="footer">
		<div class="content-container">

			<div id="company-info">
				<div id="copyright" class="margin-top">인공지능 소프트웨어과 실습 중 ~~~~~</div>
			</div>
		</div>
	</footer>
</body>

</html>