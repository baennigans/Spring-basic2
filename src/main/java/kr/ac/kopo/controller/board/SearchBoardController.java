package kr.ac.kopo.controller.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;

public class SearchBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String word = request.getParameter("word");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(word);
		vo.setId(word);
		
		BoardService service = new BoardService();
		List<BoardVO> boardList = service.searchBoardList(vo);
		
		request.setAttribute("boardList", boardList);	
		
		return "/jsp/board/boardList.jsp";
	}

}
