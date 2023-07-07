package kr.ac.kopo.controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.biz.board.BoardService;
import kr.ac.kopo.controller.biz.board.BoardVO;

public class UpdateBoardProcessController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setTitle(title);
		vo.setDetail(detail);

		BoardService service = new BoardService();
		
		if (title == "" || detail == "") {
			request.setAttribute("msg", "제목/내용을 한 글자 이상 입력해주세요.");
			return "updateBoard.do";
		} else {
			service.updateBoard(vo);
			return "getBoard.do";
		}
	}

}