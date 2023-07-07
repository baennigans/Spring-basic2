<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BGH BANK</title>
<style>
.container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: 1000px;
	margin: 50px auto;
	padding: 100px auto;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
}

.logo-img {
	width: 130px;
	padding: 20px;
	margin-top: 40px;
}

.getboard {
	text-align: center;
	width: 900px;
	margin: 0 auto;
	margin-top: 30px;
	padding: 100px auto;
	background-color: #fff;
	border-collapse: collapse;
	border: none;
}

input[type="text"], textarea {
	width: 100%;
	font-size: 16px;
	font-weight: bold;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

#updateBoard {
	width: 300px;
	margin: 30px auto;
	padding: 8px 16px;
	color: white;
	border: none;
	border-radius: 4px;
	background-color: #4CAF50;
}

#deleteBoard {
	width: 300px;
	padding: 8px 16px;
	color: white;
	border: none;
	border-radius: 4px;
	background-color: #f44336;
}

#getlist {
	margin: 30px auto;
	color: #B90000;
	text-decoration: none;
}

.comment-input-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

#detail {
	width: 800px;
	margin-left: 40px;
}

#commentInput {
	margin-left: 10px;
	padding: 8px 16px;
	font-size: 16px;
	font-weight: bold;
	text-decoration: none;
	color: #fff;
	background-color: #CD0000; border : none;
	border-radius: 4px;
	cursor: pointer;
	border: none;
}

.comment-table {
  width: 1000px;
  margin: 50px auto;
  margin-bottom: 100px;
  border-collapse: collapse;
}

.comment-table th:nth-child(1) {
	width: 15%;
}
.comment-table th:nth-child(2) {
	width: 65%;
}
.comment-table th:nth-child(3) {
	width: 20%;
}

.comment-table th, .comment-table td {
  padding: 8px;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.comment-table th {
  background-color: #f2f2f2;
  font-weight: bold;
}

.comment-table tr:hover {
  background-color: #f5f5f5;
}
</style>

<script>
	function addComment() {
		var detail = $("#detail").val();
		var no = $("#no").val();
		var date = new Date().toLocaleString();

		var data = {
			"detail" : detail,
			"no" : no,
			"date" : date
		};

		$.ajax({
			url : "jsp/board/insertComment.jsp",
			type : "POST",
			data : data,
			success : function(response) {
				var commentTable = $(".comment-table tbody");
				var newRow = $("<tr></tr>");
				var cell1 = $("<td></td>").text("${user.id}");
				var cell2 = $("<td></td>").text($("#detail").val());
				var cell3 = $("<td></td>").text(new Date().toLocaleString());

				newRow.append(cell1, cell2, cell3);
				commentTable.append(newRow);

				$("#detail").val("");
			},
			error : function(xhr, status, error) {
			}
		});
	}
</script>
<script>
	function checkForm() {
		if (confirm("게시글을 삭제하시겠습니까?")) {
			return true
		} else {
			return false
		}
	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/view/topMenu.jsp" />
	</header>
	<section>
		<div class="container">
			<a href="${ pageContext.request.contextPath }/main.do">
				<img src="logo3.png" alt="Bank 로고" class="logo-img">
			</a>
			<form action="${ pageContext.request.contextPath }/updateBoard.do" method="post">
				<input name="no" type="hidden" value="${board.no}" id="no" />
				<table border="1" class="getboard">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${board.title}" disabled /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="detail" cols="40" rows="10" disabled>${board.detail}</textarea></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="id" value="${board.id}" disabled /></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td><input type="text" name="date" value="${board.date}" disabled /></td>
					</tr>
					<tr>
						<c:if test="${user.id == board.id || user.role == '1'}">
							<td colspan="2"><input type="submit" value="수정하기" id="updateBoard" /></td>
						</c:if>
					</tr>
				</table>
			</form>
			<br />
			<c:if test="${user.id == board.id || user.role == '1'}">
				<form action="${ pageContext.request.contextPath }/deleteBoard.do?no=${board.no}" method="post" onsubmit="return checkForm()">
					<input type="hidden" name="no" value="${board.no}" />
					<input type="submit" value="삭제하기" id="deleteBoard" />
				</form>
			</c:if>
			<a href="${ pageContext.request.contextPath }/boardPaging.do" id="getlist">목록으로</a>
		</div>
		<div class="comment-input-container">
			댓글 : <input type="text" id="detail" class="input-field" placeholder="댓글을 입력해주세요.">
			<input type="button" id="commentInput" value="댓글 등록" onclick="addComment()">
		</div>
		<table class="comment-table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>댓글</th>
					<th>시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comment" items="${commentList}">
					<tr>
						<td>${comment.id }</td>
						<td>${comment.detail }</td>
						<td>${comment.date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<footer>
		<jsp:include page="/WEB-INF/view/bottomMenu.jsp" />
	</footer>
</body>
</html>