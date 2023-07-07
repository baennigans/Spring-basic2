package kr.ac.kopo.controller.biz.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.controller.biz.JDBCUtil;

public class CommentDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String COMMENT_LIST = "SELECT * FROM B_COMMENT WHERE BOARD_NO = ? ";

	
	public List<CommentVO> getComment(CommentVO cvo) {
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(COMMENT_LIST);
			stmt.setInt(1, cvo.getBoardNo());
			rs = stmt.executeQuery();
			while (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setNo(rs.getInt("COMMENT_NO"));
				comment.setBoardNo(rs.getInt("BOARD_NO"));
				comment.setId(rs.getString("USER_ID"));
				comment.setDetail(rs.getString("COMMENT_DETAIL"));
				comment.setDate(rs.getString("COMMENT_DATE"));
				commentList.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return commentList;
	}
}
