package kr.ac.kopo.controller.biz.board;

import java.util.List;

public class BoardService {
	
	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao = new BoardDAO();
	}

	public void insertBoard(BoardVO vo) {
		boardDao.insertBoard(vo);
		
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> boardList = boardDao.getBoardList();
		return boardList;
	}

	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = boardDao.getBoard(vo);
		return board;
	}

	public void updateBoard(BoardVO vo) {
		boardDao.updateBoard(vo);		
	}

	public void deleteBoard(BoardVO vo) {
		boardDao.deleteBoard(vo);
	}

	public List<BoardVO> searchBoardList(BoardVO vo) {
		List<BoardVO> boardList = boardDao.searchBoardList(vo);
		return boardList;
	}

	public List<BoardVO> selectBoard(int pageNo) {
		List<BoardVO> boardList = boardDao.selectBoard(pageNo);
		return boardList;
	}

	public int selectBoardCount() {
		int totalCount = boardDao.selectBoardCount();
		return totalCount;
	}
	
}
