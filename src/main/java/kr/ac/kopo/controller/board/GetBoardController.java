package kr.ac.kopo.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;
import kr.ac.kopo.controller.biz.comment.CommentDAO;
import kr.ac.kopo.controller.biz.comment.CommentVO;

public class GetBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String no = request.getParameter("no");
		
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		BoardService service = new BoardService();
		BoardVO board = service.getBoard(vo);

		CommentVO cvo = new CommentVO();
		cvo.setBoardNo(Integer.parseInt(no));
		CommentDAO dao = new CommentDAO();
		List<CommentVO> commentList = dao.getComment(cvo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("getBoard");
		
		
//		request.setAttribute("board", board);
//		request.setAttribute("commentList", commentList);
		
		return "/jsp/board/getBoard.jsp";
	}

}