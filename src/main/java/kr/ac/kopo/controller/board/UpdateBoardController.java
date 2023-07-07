package kr.ac.kopo.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;

public class UpdateBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String no = request.getParameter("no");
		
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));

		BoardService service = new BoardService();
		BoardVO board = service.getBoard(vo);

		request.setAttribute("board", board);
		
		return "/jsp/board/updateBoard.jsp";
	}

}