package kr.ac.kopo.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;

public class BoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		BoardService service = new BoardService();
		List<BoardVO> boardList = service.getBoardList(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", boardList);
		mv.setViewName("board");
		
		return mv;
	}
	
	
	
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		
//		BoardVO vo = new BoardVO();
//		BoardService service = new BoardService();
//		
//		List<BoardVO> boardList = service.getBoardList(vo);
//
//		request.setAttribute("boardList", boardList);
//		
//		return "/jsp/board/boardList.jsp";
//	}
}