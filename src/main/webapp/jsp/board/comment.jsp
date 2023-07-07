<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.comment-container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-bottom: 100px;
}
</style>
<script>
	function fn_comment(code) {

		$.ajax({
			type : 'POST',
			url : "<c:url value='/board/addComment.do'/>",
			data : $("#commentForm").serialize(),
			success : function(data) {
				if (data == "success") {
					getCommentList();
					$("#comment").val("");
				}
			},
			error : function(request, status, error) {
				//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}

	/**
	 * 초기 페이지 로딩시 댓글 불러오기
	 */
	$(function() {
		getCommentList();
	});

	/**
	 * 댓글 불러오기(Ajax)
	 */
	function getCommentList() {
		$.ajax({
					type : 'GET',
					url : "<c:url value='/board/commentList.do'/>",
					dataType : "json",
					data : $("#commentForm").serialize(),
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					success : function(data) {

						var html = "";
						var cCnt = data.length;

						if (data.length > 0) {
							for (i = 0; i < data.length; i++) {
								html += "<div>";
								html += "<div><table class='table'><h6><strong>"
										+ data[i].writer + "</strong></h6>";
								html += data[i].comment + "<tr><td></td></tr>";
								html += "</table></div>";
								html += "</div>";
							}
						} else {
							html += "<div>";
							html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
							html += "</table></div>";
							html += "</div>";
						}
						$("#cCnt").html(cCnt);
						$("#commentList").html(html);
					},
					error : function(request, status, error) {
					}
				});
	}
</script>


</head>
<body>
	<div class="comment-container">
		<form id="commentForm" name="commentForm" method="post">
			<br>
			<br>
			<div>
				<div>
					<span><strong>Comments</strong></span> <span id="cCnt"></span>
				</div>
				<div>
					<table class="table">
						<tr>
							<td><textarea style="width: 1000px" rows="3" cols="30"
									id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
								<br>
								<div>
									<a href='#' onClick="fn_comment('${result.code }')"
										class="btn pull-right btn-success">등록</a>
								</div></td>
						</tr>
					</table>
				</div>
			</div>
			<input type="hidden" id="b_code" name="b_code"
				value="${result.code }" />
		</form>
		<form id="commentListForm" name="commentListForm" method="post">
			<div id="commentList"></div>
		</form>
	</div>
</body>
</html>