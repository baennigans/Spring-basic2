package kr.ac.kopo.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String no = request.getParameter("no");
		
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));

		BoardService service = new BoardService();
		service.deleteBoard(vo);
		
		request.setAttribute("msg", "게시글 삭제가 완료되었습니다.");
		
		return "boardPaging.do";
	}
}
