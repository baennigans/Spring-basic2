package kr.ac.kopo.controller.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.controller.biz.JDBCUtil;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static final int LIST_SIZE = 15;

	private static String BOARD_INSERT = "insert into B_BOARD (board_no, user_id, board_title, board_detail) values (seq_b_board_board_no.nextval, ?, ?, ?) ";
	private static String BOARD_LIST = "select * from B_BOARD order by board_no desc ";
	private static String BOARD_GET = "select * from B_BOARD where board_no=? ";
	private static String BOARD_UPDATE = "update B_BOARD set board_title=?, board_detail=? where board_no=? ";
	private static String BOARD_DELETE = "delete B_BOARD where board_no=? ";
	private static String BOARD_SEARCH = "select * from B_BOARD where board_title like ? or user_id=? ";
	private static String BOARD_SELECT = "select * from (select rownum rnum, b.* from (select a.* from B_BOARD a order by board_no desc)b ) where rnum >=? and rnum<= ? ";
	private static String BOARD_COUNT = "select count(*) cnt from b_board";
	
	
	public List<BoardVO> selectBoard(int pageNo) {
		int start = (pageNo -1) * LIST_SIZE + 1;
		int end   = pageNo      * LIST_SIZE;
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_SELECT);
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("BOARD_NO"));
				board.setId(rs.getString("USER_ID"));
				board.setTitle(rs.getString("BOARD_TITLE"));
				board.setDetail(rs.getString("BOARD_DETAIL"));
				board.setDate(rs.getDate("BOARD_DATE"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
			}
		return boardList;
	}
	
	
	public int selectBoardCount() {
		int totalCount = 0;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_COUNT);
			rs = stmt.executeQuery();
			rs.next();
			totalCount = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return totalCount;
	}	
	
	
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getDetail());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("BOARD_NO"));
				board.setId(rs.getString("USER_ID"));
				board.setTitle(rs.getString("BOARD_TITLE"));
				board.setDetail(rs.getString("BOARD_DETAIL"));
				board.setDate(rs.getDate("BOARD_DATE"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}

	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getNo());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setNo(rs.getInt("BOARD_NO"));
				board.setId(rs.getString("USER_ID"));
				board.setTitle(rs.getString("BOARD_TITLE"));
				board.setDetail(rs.getString("BOARD_DETAIL"));
				board.setDate(rs.getDate("BOARD_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getDetail());
			stmt.setInt(3, vo.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public List<BoardVO> searchBoardList(BoardVO vo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_SEARCH);
			stmt.setString(1, "%"+vo.getTitle()+"%");
			stmt.setString(2, vo.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("BOARD_NO"));
				board.setId(rs.getString("USER_ID"));
				board.setTitle(rs.getString("BOARD_TITLE"));
				board.setDetail(rs.getString("BOARD_DETAIL"));
				board.setDate(rs.getDate("BOARD_DATE"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}
