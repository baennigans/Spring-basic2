<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.ac.kopo.controller.biz.JDBCUtil"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%
	Connection conn = null;
	PreparedStatement stmt = null;
	try {
		conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO B_COMMENT (COMMENT_NO, BOARD_NO, USER_ID, COMMENT_DETAIL, COMMENT_DATE) VALUES (seq_B_COMMENT_COMMENT_NO.nextval, ?, ?, ?, ?) ";
		stmt = conn.prepareStatement(sql);

		String detail = request.getParameter("detail");
		String no = request.getParameter("no");
		String date = request.getParameter("date");
		
		stmt.setInt(1, Integer.parseInt(no));
		stmt.setString(2, "null");
		stmt.setString(3, detail);
		stmt.setString(4, date);
		stmt.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(stmt, conn);
	}
	%>
</body>
</html>