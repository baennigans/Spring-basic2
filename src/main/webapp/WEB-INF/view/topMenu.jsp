<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BGH BANK</title>
<style>
	.topMenu-bar1 {
        text-align: right;
        margin-right: 40px;
    }
    .topMenu-item1 {
        display: inline-block;
        padding: 10px;
    }
	.topMenu-item1 a {
		color: #333;
		text-decoration: none;
	}
	.topMenu-item1 a:hover {
		color: #EB0000;
	}
	.logo1{
		display: inline-block;
		margin-left: 100px;
	}
	.topMenu-bar2 {
        float: right;
        margin-right: 40px;
    }
    .topMenu-item2 {
        display: inline-block;
        padding: 10px;
    }
	.topMenu-item2 a {
		color: #00008C;
		font-size: 20px;
		text-decoration: none;
		font-weight: bold;
	}
	.topMenu-item2 a:hover {
		color: #0078FF;
	}
    .topMenu-item3 {
        display: inline-block;
        padding: 10px;
    }
	.topMenu-item3 a {
		color: #B90000;
		font-size: 20px;
		text-decoration: none;
		font-weight: bold;
	}
	.topMenu-item3 a:hover {
		color: #EB0000;
	}
	.red-line {
		border-bottom: 3px solid #EB0000;
		margin-top: 25px;
	}
	.blue-line {
		border-bottom: 3px solid #00008C;
		margin-top: 25px;
	}
</style>
</head>

<body>
	<div class="topMenu-bar1">
		<c:choose>
		<c:when test="${ empty login }">
			<div class="topMenu-item1">
				<a href="${ pageContext.request.contextPath }/login.do">로그인</a>
			</div>
			<div class="topMenu-item1">
				<a href="${ pageContext.request.contextPath }/insertUser.do">회원가입</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="topMenu-item1">
				<a href="${ pageContext.request.contextPath }/myPage.do">마이페이지</a>
			</div>
			<div class="topMenu-item1">
				<a href="${ pageContext.request.contextPath }/logout.do">로그아웃</a>
			</div>
		</c:otherwise>
		</c:choose>
		<div class="topMenu-item1">
			<a href="${ pageContext.request.contextPath }/introduce.do">은행소개</a>
		</div>
	</div>
	<a href="${ pageContext.request.contextPath }/main.do">
		<img src="logo2.png" alt="로고" class="logo1">
	</a>
	<div class="topMenu-bar2">
		<c:choose>
		<c:when test="${ user.role == '1' }">
			<div class="topMenu-item2">
				<a href="${ pageContext.request.contextPath }/product.do">상품관리</a>
			</div>
			<div class="topMenu-item2">
				<a href="${ pageContext.request.contextPath }/userList.do">회원관리</a>
			</div>
			<div class="topMenu-item2">
				<a href="${ pageContext.request.contextPath }/accountList.do">계좌관리</a>
			</div>
			<div class="topMenu-item2">
				<a href="${ pageContext.request.contextPath }/noticePaging.do">공지사항</a>
			</div>
			<div class="topMenu-item2">
				<a href="${ pageContext.request.contextPath }/boardPaging.do">게시판</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/getAccount.do?id=${user.id}">계좌조회</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/transferAccount.do?id=${user.id}">계좌이체</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/createAccount.do">계좌개설</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/deleteAccount.do?id=${user.id}">계좌해지</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/agree.do">약관동의</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/noticePaging.do">공지사항</a>
			</div>
			<div class="topMenu-item3">
				<a href="${ pageContext.request.contextPath }/boardPaging.do">게시판</a>
			</div>
		</c:otherwise>
		</c:choose>
	</div>
	<c:choose>
	<c:when test="${ user.role == '1' }">
		<div class="blue-line"></div>
	</c:when>
	<c:otherwise>
		<div class="red-line"></div>
	</c:otherwise>
	</c:choose>
</body>
</html>