<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BGH BANK</title>
<%
String msg = (String) request.getAttribute("msg");
if (msg != null && !msg.isEmpty()) {
%>
<script>
alert('<%=msg%>');
</script>
<%
}
%>
</head>
<style>
.main{
	display: flex;
	width: 70%;
	margin: 0 auto;
	margin-top: 50px;
}
#wrapper{
  height: auto;
  min-height: 800px;
  padding-bottom: 70px;
}
footer{
  height: 20px;
  position : relative;
  transform : translateY(-100%);
}
</style>
<body>
	<div id="wrapper">
	<header>
		<%@ include file="/WEB-INF/view/topMenu.jsp"%>
	</header>
	<section>
		<div>
			<img src="../main.png" alt="메인" class="main">
		</div>
	</section>
	</div>
	<footer>
		<%@ include file="/WEB-INF/view/bottomMenu.jsp"%>
	</footer>
</body>
</html>